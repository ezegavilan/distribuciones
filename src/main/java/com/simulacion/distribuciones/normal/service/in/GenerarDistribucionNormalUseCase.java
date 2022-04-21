package com.simulacion.distribuciones.normal.service.in;

import com.simulacion.distribuciones.shared.model.GeneradorResponse;

public interface GenerarDistribucionNormalUseCase {
    GeneradorResponse generar(int n, float media, float desvEstandar, int cantidadIntervalos);
}
