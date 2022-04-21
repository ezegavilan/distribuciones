package com.simulacion.distribuciones.exponencialnegativa.service.in;

import com.simulacion.distribuciones.shared.model.GeneradorResponse;

public interface GenerarDistribucionExpNegativaUseCase {
    GeneradorResponse generar(int n, float media, int cantidadIntervalos);
}
