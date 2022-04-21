package com.simulacion.distribuciones.uniformeab.service.in;

import com.simulacion.distribuciones.shared.model.GeneradorResponse;

public interface GenerarDistribucionUniformeABUseCase {
    GeneradorResponse generar(int n, float extremoIzquierdo, float extremoDerecho, int cantidadIntervalos);
}
