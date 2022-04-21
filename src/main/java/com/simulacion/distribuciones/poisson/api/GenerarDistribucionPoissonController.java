package com.simulacion.distribuciones.poisson.api;

import com.simulacion.distribuciones.poisson.api.model.GeneradorPoissonResponse;
import com.simulacion.distribuciones.poisson.api.model.GenerarPoissonRequest;
import com.simulacion.distribuciones.poisson.service.in.GenerarDistribucionPoissonUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class GenerarDistribucionPoissonController {
    private final GenerarDistribucionPoissonUseCase distribucionPoissonUseCase;

    @Autowired
    public GenerarDistribucionPoissonController(GenerarDistribucionPoissonUseCase distribucionPoissonUseCase) {
        this.distribucionPoissonUseCase = distribucionPoissonUseCase;
    }

    @PostMapping("/generador/poisson")
    public ResponseEntity<Map<String, GeneradorPoissonResponse>> generarDistribucionPoisson(@RequestBody GenerarPoissonRequest request) {
        Map<String, GeneradorPoissonResponse> response = new HashMap<>();

        GeneradorPoissonResponse generadorResponse = distribucionPoissonUseCase
                .generar(request.getN(), request.getMedia(), request.getCantidadIntervalos());

        response.put("generadorResponse", generadorResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
