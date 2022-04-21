package com.simulacion.distribuciones.pruebabondad.chicuadrado.service.in;

import com.simulacion.histogramalib.core.DistribucionEnum;
import com.simulacion.histogramalib.core.Histograma;

public interface PruebaChiCuadradoUseCase {
    boolean validarHipotesis(DistribucionEnum distribucion, Histograma histograma);
}
