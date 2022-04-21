package com.simulacion.distribuciones.normal.api;

import com.simulacion.distribuciones.normal.api.model.GenerarNormalRequest;
import com.simulacion.distribuciones.normal.service.in.GenerarDistribucionNormalUseCase;
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
public class GenerarDistribucionNormalController {
    private final GenerarDistribucionNormalUseCase generarDistribucionNormalUseCase;

    @Autowired
    public GenerarDistribucionNormalController(GenerarDistribucionNormalUseCase generarDistribucionNormalUseCase) {
        this.generarDistribucionNormalUseCase = generarDistribucionNormalUseCase;
    }

    @PostMapping("/generador/normal")
    public ResponseEntity<Map<String, GeneradorResponse>> generarDistribucionNormal(@RequestBody GenerarNormalRequest request) {
        Map<String, GeneradorResponse> response = new HashMap<>();

        GeneradorResponse generadorResponse = generarDistribucionNormalUseCase
                .generar(request.getN(), request.getMedia(), request.getDesvEstandar(), request.getCantidadIntervalos());

        response.put("generadorResponse", generadorResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
