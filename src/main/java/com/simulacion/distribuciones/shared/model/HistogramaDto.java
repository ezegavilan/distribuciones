package com.simulacion.distribuciones.shared.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistogramaDto {
    private List<IntervaloDto> intervalos;
    private boolean pruebaBondadChiCuadrado;
}
