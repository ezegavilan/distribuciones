package com.simulacion.distribuciones.pruebabondad.chicuadrado.service;

import com.simulacion.distribuciones.pruebabondad.chicuadrado.service.in.PruebaChiCuadradoUseCase;
import com.simulacion.histogramalib.core.DistribucionEnum;
import com.simulacion.histogramalib.core.Histograma;
import com.simulacion.histogramalib.pruebabondad.chicuadrado.HistogramaChiCuadrado;
import com.simulacion.histogramalib.pruebabondad.chicuadrado.PruebaBondadChiCuadrado;
import org.springframework.stereotype.Service;

@Service
public class PruebaChiCuadradoService implements PruebaChiCuadradoUseCase {

    @Override
    public boolean validarHipotesis(DistribucionEnum distribucion, Histograma histograma) {
        HistogramaChiCuadrado histogramaChiCuadrado = this.generarHistogramaChiCuadrado(histograma);

        float chiCuadradoCalculado = histogramaChiCuadrado.getChiCuadradoCalculado();
        int gradosLibertad = histogramaChiCuadrado.calcularGradosLibertad(distribucion);

        PruebaBondadChiCuadrado pruebaBondadChiCuadrado = new PruebaBondadChiCuadrado();
        return pruebaBondadChiCuadrado.validarHipotesis(chiCuadradoCalculado, gradosLibertad);
    }

    private HistogramaChiCuadrado generarHistogramaChiCuadrado(Histograma histograma) {
        HistogramaChiCuadrado histogramaChiCuadrado = new HistogramaChiCuadrado();
        histogramaChiCuadrado.generarHistogramaChiCuadrado(histograma);
        return histogramaChiCuadrado;
    }
}
