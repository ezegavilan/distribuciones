package com.simulacion.distribuciones.shared.mapper;

import com.simulacion.distribuciones.shared.model.IntervaloDto;
import com.simulacion.histogramalib.core.Intervalo;
import org.springframework.stereotype.Service;

@Service
public class HistogramaIntervaloMapperImpl implements HistogramaIntervaloMapper {
    @Override
    public IntervaloDto map(Intervalo intervalo) {
        return IntervaloDto.builder()
                .intervalo(String.valueOf(intervalo.getIntervalo()))
                .inferior(String.format("%.4f", intervalo.getInferior()))
                .superior(String.format("%.4f", intervalo.getSuperior()))
                .marcaClase(String.format("%.4f", intervalo.getMarcaClase()))
                .frecuenciaEsperada(String.valueOf(intervalo.getFrecuenciaEsperada()))
                .frecuencia(String.valueOf(intervalo.getFrecuencia()))
                .proporcion(String.format("%.4f", intervalo.getProporcion()))
                .frecuenciaAcumulada(String.valueOf(intervalo.getFrecuenciaAcumulada()))
                .proporcionAcumulada(String.format("%.4f", intervalo.getProporcionAcumulada()))
                .build();
    }
}
