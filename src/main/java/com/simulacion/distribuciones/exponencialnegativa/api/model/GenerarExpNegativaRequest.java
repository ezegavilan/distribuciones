package com.simulacion.distribuciones.exponencialnegativa.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenerarExpNegativaRequest {
    private int n;
    private float media;
    private int cantidadIntervalos;
}
