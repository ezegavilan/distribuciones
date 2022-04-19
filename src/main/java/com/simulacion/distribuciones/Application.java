package com.simulacion.distribuciones;

import com.simulacion.distribuciones.core.Iteracion;
import com.simulacion.distribuciones.core.Tabla;
import com.simulacion.distribuciones.uniformeab.domain.TablaUniformeAB;
import com.simulacion.histogramalib.core.Histograma;

import java.util.stream.Collectors;

/**
 * @author ezegavilan95
 * Clase Placeholder para la aplicación Main
 */
public class Application {
    public static void main(String[] args) {
        Tabla tablaAB = new TablaUniformeAB(0, 10);
        tablaAB.generarTabla(300);
        System.out.println(".: TABLA :.");
        System.out.println(tablaAB);

        System.out.println("------------------------------------------------------------------------");

        Histograma histograma = new Histograma(5);
        histograma.generarHistograma(tablaAB.getIteraciones()
                .stream()
                .map(Iteracion::getValor)
                .collect(Collectors.toList()));
        System.out.println(".: HISTOGRAMA :.");
        System.out.println(histograma);
    }
}
