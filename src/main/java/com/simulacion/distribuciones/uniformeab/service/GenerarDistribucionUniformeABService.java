package com.simulacion.distribuciones.uniformeab.service;

import com.simulacion.distribuciones.core.Tabla;
import com.simulacion.distribuciones.pruebabondad.chicuadrado.service.in.PruebaChiCuadradoUseCase;
import com.simulacion.distribuciones.shared.mapper.HistogramaIntervaloMapper;
import com.simulacion.distribuciones.shared.mapper.TablaIteracionMapper;
import com.simulacion.distribuciones.shared.model.GeneradorResponse;
import com.simulacion.distribuciones.shared.model.HistogramaDto;
import com.simulacion.distribuciones.shared.model.TablaDto;
import com.simulacion.distribuciones.uniformeab.domain.TablaUniformeAB;
import com.simulacion.distribuciones.uniformeab.service.in.GenerarDistribucionUniformeABUseCase;
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
public class GenerarDistribucionUniformeABService implements GenerarDistribucionUniformeABUseCase {
    private final DistribucionEnum DISTRIBUCION = DistribucionEnum.UNIFORME_AB;
    private final HistogramaIntervaloMapper histogramaIntervaloMapper;
    private final TablaIteracionMapper tablaIteracionMapper;
    private final PruebaChiCuadradoUseCase pruebaChiCuadradoUseCase;

    @Override
    public GeneradorResponse generar(int n, float extremoIzquierdo, float extremoDerecho, int cantidadIntervalos) {
        Tabla tabla = this.crearTabla(n, extremoIzquierdo, extremoDerecho);
        List<Float> muestra = new ArrayList<>();
        tabla.getIteraciones().forEach(iteracion -> muestra.add(iteracion.getValor()));

        HistogramaDto histogramaDto = this.crearHistograma(cantidadIntervalos, muestra);
        return GeneradorResponse.builder()
                .histogramaDto(histogramaDto)
                .tablaDto(mapTabla(tabla)).build();
    }

    private HistogramaDto crearHistograma(int cantidadIntervalos, List<Float> muestra) {
        Histograma histograma = HistogramaFactory.get(DISTRIBUCION, cantidadIntervalos);
        histograma.generarHistograma(muestra);

        boolean pruebaChiCuadrado = pruebaChiCuadradoUseCase.validarHipotesis(DISTRIBUCION, histograma);

        return HistogramaDto.builder()
                .intervalos(histograma.getIntervalos().stream().map(histogramaIntervaloMapper::map).collect(Collectors.toList()))
                .pruebaBondadChiCuadrado(pruebaChiCuadrado)
                .build();
    }

    private Tabla crearTabla(int n, float izq, float der) {
        Tabla tabla = new TablaUniformeAB(izq, der);
        tabla.generarTabla(n);
        return tabla;
    }

    private TablaDto mapTabla(Tabla tabla) {
        return TablaDto.builder().iteraciones(tabla.getIteraciones().stream().map(tablaIteracionMapper::map).collect(Collectors.toList()))
                .build();
    }
}
