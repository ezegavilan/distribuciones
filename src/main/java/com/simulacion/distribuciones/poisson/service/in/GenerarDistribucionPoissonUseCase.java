package com.simulacion.distribuciones.poisson.service.in;

import com.simulacion.distribuciones.poisson.api.model.GeneradorPoissonResponse;

public interface GenerarDistribucionPoissonUseCase {
    GeneradorPoissonResponse generar(int n, float media, int cantidadIntervalos);
}
