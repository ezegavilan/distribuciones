package com.simulacion.distribuciones.poisson.api.model;

import com.simulacion.distribuciones.shared.model.TablaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeneradorPoissonResponse {
    private TablaDto tabla;
    private HistogramaPoissonDto histograma;
}
