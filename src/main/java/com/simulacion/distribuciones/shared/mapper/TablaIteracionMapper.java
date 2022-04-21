package com.simulacion.distribuciones.shared.mapper;

import com.simulacion.distribuciones.core.Iteracion;
import com.simulacion.distribuciones.shared.model.IteracionDto;

public interface TablaIteracionMapper {
    IteracionDto map(Iteracion iteracion);
}
