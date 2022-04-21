package com.simulacion.distribuciones.normal.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenerarNormalRequest {
    private int n;
    private float media;
    private float desvEstandar;
    private int cantidadIntervalos;
}
