package com.simulacion.distribuciones.shared.mapper;

import com.simulacion.distribuciones.core.Iteracion;
import com.simulacion.distribuciones.shared.model.IteracionDto;
import org.springframework.stereotype.Service;

@Service
public class TablaIteracionMapperImpl implements TablaIteracionMapper {

    @Override
    public IteracionDto map(Iteracion iteracion) {
        return IteracionDto.builder()
                .iteracion(String.valueOf(iteracion.getIteracion()))
                .valor(String.valueOf(iteracion.getValor())).build();
    }
}
