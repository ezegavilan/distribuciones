package com.simulacion.distribuciones;

import com.simulacion.distribuciones.core.Iteracion;
import com.simulacion.distribuciones.core.Tabla;
import com.simulacion.distribuciones.exponencialnegativa.domain.TablaExponencialNegativa;
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
        System.out.println(".: TABLA UNIFORME AB:.");
        System.out.println(tablaAB);

        Histograma histograma = new Histograma(5);
        histograma.generarHistograma(tablaAB.getIteraciones()
                .stream()
                .map(Iteracion::getValor)
                .collect(Collectors.toList()));
        System.out.println("\n.: HISTOGRAMA UNIFORME AB:.");
        System.out.println(histograma);

        System.out.println("\n------------------------------------------------------------------------");
        Tabla tablaExpNegativa = new TablaExponencialNegativa(12);
        tablaExpNegativa.generarTabla(300);
        System.out.println(".: TABLA EXPONENCIAL NEGATIVA :.");
        System.out.println(tablaExpNegativa);

        Histograma histograma1 = new Histograma(5);
        histograma1.generarHistograma(tablaExpNegativa.getIteraciones()
                .stream()
                .map(Iteracion::getValor)
                .collect(Collectors.toList()));

        System.out.println("\n.: HISTOGRAMA EXPONENCIAL NEGATIVA :.");
        System.out.println(histograma1);
    }
}
