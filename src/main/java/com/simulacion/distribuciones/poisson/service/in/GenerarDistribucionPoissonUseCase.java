package com.simulacion.distribuciones.poisson.service.in;

import com.simulacion.distribuciones.shared.model.GeneradorResponse;

public interface GenerarDistribucionPoissonUseCase {
    GeneradorResponse generar(int n, float media, int cantidadIntervalos);
}
