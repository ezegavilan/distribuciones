package com.simulacion.distribuciones.uniformeab.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenerarUniformeABRequest {
    private int n;
    private float extremoIzquierdo;
    private float extremoDerecho;
    private int cantidadIntervalos;
}
