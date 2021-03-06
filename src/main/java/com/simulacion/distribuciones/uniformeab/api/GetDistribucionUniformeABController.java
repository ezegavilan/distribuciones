package com.simulacion.distribuciones.uniformeab.api;

import com.simulacion.distribuciones.shared.model.GeneradorResponse;
import com.simulacion.distribuciones.uniformeab.api.model.GenerarUniformeABRequest;
import com.simulacion.distribuciones.uniformeab.service.in.GenerarDistribucionUniformeABUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class GetDistribucionUniformeABController {
    private final GenerarDistribucionUniformeABUseCase generarDistribucionUniformeABUseCase;

    @Autowired
    public GetDistribucionUniformeABController(GenerarDistribucionUniformeABUseCase generarDistribucionUniformeABUseCase) {
        this.generarDistribucionUniformeABUseCase = generarDistribucionUniformeABUseCase;
    }

    @PostMapping("/generador/uniformeab")
    public ResponseEntity<Map<String, GeneradorResponse>> generarDistribucionUniformeAB(@RequestBody GenerarUniformeABRequest request) {
        Map<String, GeneradorResponse> response = new HashMap<>();

        GeneradorResponse generadorResponse = generarDistribucionUniformeABUseCase
                .generar(request.getN(), request.getExtremoIzquierdo(), request.getExtremoDerecho(), request.getCantidadIntervalos());

        response.put("generadorResponse", generadorResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
