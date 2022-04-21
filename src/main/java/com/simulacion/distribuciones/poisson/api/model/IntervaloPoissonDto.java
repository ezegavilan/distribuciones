package com.simulacion.distribuciones.poisson.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IntervaloPoissonDto {
    private String intervalo;
    private String valor;
    private String frecuenciaEsperada;
    private String frecuencia;
}
