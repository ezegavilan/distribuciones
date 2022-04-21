package com.simulacion.distribuciones.poisson.service;

import com.simulacion.distribuciones.core.Tabla;
import com.simulacion.distribuciones.poisson.domain.TablaPoisson;
import com.simulacion.distribuciones.poisson.service.in.GenerarDistribucionPoissonUseCase;
import com.simulacion.distribuciones.pruebabondad.chicuadrado.service.in.PruebaChiCuadradoUseCase;
import com.simulacion.distribuciones.shared.mapper.HistogramaIntervaloMapper;
import com.simulacion.distribuciones.shared.mapper.TablaIteracionMapper;
import com.simulacion.distribuciones.shared.model.GeneradorResponse;
import com.simulacion.distribuciones.shared.model.HistogramaDto;
import com.simulacion.distribuciones.shared.model.TablaDto;
import com.simulacion.histogramalib.core.DistribucionEnum;
import com.simulacion.histogramalib.core.Histograma;
import com.simulacion.histogramalib.core.HistogramaFactory;
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
    private final HistogramaIntervaloMapper histogramaIntervaloMapper;
    private final PruebaChiCuadradoUseCase pruebaChiCuadradoUseCase;

    @Override
    public GeneradorResponse generar(int n, float media, int cantidadIntervalos) {
        Tabla tabla = this.crearTabla(n, media);
        List<Float> muestra = new ArrayList<>();
        tabla.getIteraciones().forEach(iteracion -> muestra.add(iteracion.getValor()));

        HistogramaDto histogramaDto = this.crearHistograma(muestra, cantidadIntervalos);
        return GeneradorResponse.builder()
                .histogramaDto(histogramaDto)
                .tablaDto(mapTabla(tabla)).build();
    }

    private HistogramaDto crearHistograma(List<Float> muestra, int cantidadIntervalos) {
        Histograma histograma = HistogramaFactory.get(DISTRIBUCION, cantidadIntervalos);
        histograma.generarHistograma(muestra);

        boolean pruebaChiCuadrado = pruebaChiCuadradoUseCase.validarHipotesis(DISTRIBUCION, histograma);

        return HistogramaDto.builder()
                .intervalos(histograma.getIntervalos().stream().map(histogramaIntervaloMapper::map).collect(Collectors.toList()))
                .pruebaBondadChiCuadrado(pruebaChiCuadrado)
                .build();
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
