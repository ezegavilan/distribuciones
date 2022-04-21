package com.simulacion.distribuciones.poisson.service;

import com.simulacion.distribuciones.core.Tabla;
import com.simulacion.distribuciones.poisson.api.model.GeneradorPoissonResponse;
import com.simulacion.distribuciones.poisson.api.model.HistogramaPoissonDto;
import com.simulacion.distribuciones.poisson.api.model.IntervaloPoissonDto;
import com.simulacion.distribuciones.poisson.domain.TablaPoisson;
import com.simulacion.distribuciones.poisson.service.in.GenerarDistribucionPoissonUseCase;
import com.simulacion.distribuciones.shared.mapper.TablaIteracionMapper;
import com.simulacion.distribuciones.shared.model.TablaDto;
import com.simulacion.histogramalib.core.DistribucionEnum;
import com.simulacion.histogramalib.core.HistogramaFactory;
import com.simulacion.histogramalib.core.Intervalo;
import com.simulacion.histogramalib.core.poisson.HistogramaPoisson;
import com.simulacion.histogramalib.core.poisson.IntervaloPoisson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GenerarDistribucionPoissonService implements GenerarDistribucionPoissonUseCase {
    private final DistribucionEnum DISTRIBUCION = DistribucionEnum.POISSON;
    private final TablaIteracionMapper tablaIteracionMapper;

    @Override
    public GeneradorPoissonResponse generar(int n, float media, int cantidadIntervalos) {
        Tabla tabla = this.crearTabla(n, media);
        List<Float> muestra = new ArrayList<>();
        tabla.getIteraciones().forEach(iteracion -> muestra.add(iteracion.getValor()));

        HistogramaPoissonDto histogramaDto = this.crearHistograma(muestra, cantidadIntervalos);
        return GeneradorPoissonResponse.builder()
                .histograma(histogramaDto)
                .tabla(mapTabla(tabla)).build();
    }

    private HistogramaPoissonDto crearHistograma(List<Float> muestra, int cantidadIntervalos) {
        HistogramaPoisson histograma = (HistogramaPoisson) HistogramaFactory.get(DISTRIBUCION, cantidadIntervalos);
        histograma.generarHistograma(muestra);

        List<IntervaloPoissonDto> intervalos = new ArrayList<>();
        for (Intervalo intervalo: histograma.getIntervalos()) {
            intervalos.add(map((IntervaloPoisson) intervalo));
        }
        return HistogramaPoissonDto.builder()
                .intervalos(intervalos)
                .build();
    }

    private IntervaloPoissonDto map(IntervaloPoisson intervalo) {
        return IntervaloPoissonDto.builder()
                .intervalo(String.valueOf(intervalo.getIntervalo()))
                .valor(String.valueOf(intervalo.getValor()))
                .frecuencia(String.valueOf(intervalo.getFrecuencia()))
                .frecuenciaEsperada(String.valueOf(intervalo.getFrecuenciaEsperadaPoisson())).build();
    }

    private Tabla crearTabla(int n, float media) {
        Tabla tabla = new TablaPoisson(media);
        tabla.generarTabla(n);
        return tabla;
    }

    private TablaDto mapTabla(Tabla tabla) {
        return TablaDto.builder().iteraciones(tabla.getIteraciones().stream().map(tablaIteracionMapper::map).collect(Collectors.toList()))
                .build();
    }
}
