package com.simulacion.distribuciones.poisson.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistogramaPoissonDto {
    private List<IntervaloPoissonDto> intervalos;
}
