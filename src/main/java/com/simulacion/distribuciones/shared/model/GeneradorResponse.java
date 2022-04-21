package com.simulacion.distribuciones.shared.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeneradorResponse {
    private TablaDto tablaDto;
    private HistogramaDto histogramaDto;
}
