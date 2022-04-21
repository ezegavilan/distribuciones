package com.simulacion.distribuciones.poisson.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenerarPoissonRequest {
    private int n;
    private float media;
    private int cantidadIntervalos;
}
