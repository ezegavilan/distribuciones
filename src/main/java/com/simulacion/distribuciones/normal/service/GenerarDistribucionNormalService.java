package com.simulacion.distribuciones.normal.service;

import com.simulacion.distribuciones.normal.domain.BoxMuller;
import com.simulacion.distribuciones.normal.domain.IteracionNormal;
import com.simulacion.distribuciones.normal.domain.TablaNormal;
import com.simulacion.distribuciones.normal.service.in.GenerarDistribucionNormalUseCase;
import com.simulacion.distribuciones.pruebabondad.chicuadrado.service.in.PruebaChiCuadradoUseCase;
import com.simulacion.distribuciones.shared.mapper.HistogramaIntervaloMapper;
import com.simulacion.distribuciones.shared.model.GeneradorResponse;
import com.simulacion.distribuciones.shared.model.HistogramaDto;
import com.simulacion.distribuciones.shared.model.IteracionDto;
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
public class GenerarDistribucionNormalService implements GenerarDistribucionNormalUseCase {
    private final DistribucionEnum DISTRIBUCION = DistribucionEnum.NORMAL;
    private final HistogramaIntervaloMapper histogramaIntervaloMapper;
    private final PruebaChiCuadradoUseCase pruebaChiCuadradoUseCase;

    @Override
    public GeneradorResponse generar(int n, float media, float desvEstandar, int cantidadIntervalos) {
        TablaNormal tabla = this.crearTabla(n, media, desvEstandar);
        List<Float> muestra = new ArrayList<>();
        tabla.getIteraciones().forEach(iteracion -> muestra.add(iteracion.getValor()));

        HistogramaDto histogramaDto = this.crearHistograma(muestra, cantidadIntervalos);
        return GeneradorResponse.builder()
                .histogramaDto(histogramaDto)
                .tablaDto(mapTabla(tabla)).build();
    }

    private TablaNormal crearTabla(int n, float media, float desvEstandar) {
        TablaNormal tabla = new BoxMuller(media, desvEstandar);
        tabla.generarTabla(n);
        return tabla;
    }

    private TablaDto mapTabla(TablaNormal tabla) {
        return TablaDto.builder()
                .iteraciones(tabla.getIteraciones().stream().map(this::mapIteracion).collect(Collectors.toList()))
                .build();
    }

    private IteracionDto mapIteracion(IteracionNormal iteracion) {
        return IteracionDto.builder()
                .iteracion(String.valueOf(iteracion.getIteracion()))
                .valor(String.valueOf(iteracion.getValor())).build();
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
}
