package com.simulacion.distribuciones.shared.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IntervaloDto {
    private String intervalo;
    private String inferior;
    private String superior;
    private String marcaClase;
    private String frecuenciaEsperada;
    private String frecuencia;
    private String proporcion;
    private String frecuenciaAcumulada;
    private String proporcionAcumulada;
}
