package com.simulacion.distribuciones.shared.mapper;

import com.simulacion.distribuciones.shared.model.IntervaloDto;
import com.simulacion.histogramalib.core.Intervalo;

public interface HistogramaIntervaloMapper {
    IntervaloDto map(Intervalo intervalo);
}
