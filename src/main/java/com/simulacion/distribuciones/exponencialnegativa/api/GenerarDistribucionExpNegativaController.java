package com.simulacion.distribuciones.exponencialnegativa.api;

import com.simulacion.distribuciones.exponencialnegativa.api.model.GenerarExpNegativaRequest;
import com.simulacion.distribuciones.exponencialnegativa.service.in.GenerarDistribucionExpNegativaUseCase;
import com.simulacion.distribuciones.shared.model.GeneradorResponse;
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
public class GenerarDistribucionExpNegativaController {
    private final GenerarDistribucionExpNegativaUseCase generarDistribucionExpNegativaUseCase;

    @Autowired
    public GenerarDistribucionExpNegativaController(GenerarDistribucionExpNegativaUseCase generarDistribucionExpNegativaUseCase) {
        this.generarDistribucionExpNegativaUseCase = generarDistribucionExpNegativaUseCase;
    }

    @PostMapping("/generador/exponencialnegativa")
    public ResponseEntity<Map<String, GeneradorResponse>> generarDistribucionExponencialNegativa(@RequestBody GenerarExpNegativaRequest request) {
        Map<String, GeneradorResponse> response = new HashMap<>();

        GeneradorResponse generadorResponse = generarDistribucionExpNegativaUseCase
                .generar(request.getN(), request.getMedia(), request.getCantidadIntervalos());

        response.put("generadorResponse", generadorResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
