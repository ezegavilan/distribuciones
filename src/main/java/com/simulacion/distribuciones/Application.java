package com.simulacion.distribuciones;

import com.simulacion.distribuciones.core.Iteracion;
import com.simulacion.distribuciones.core.Tabla;
import com.simulacion.distribuciones.exponencialnegativa.domain.TablaExponencialNegativa;
import com.simulacion.distribuciones.normal.domain.BoxMuller;
import com.simulacion.distribuciones.normal.domain.IteracionNormal;
import com.simulacion.distribuciones.normal.domain.TablaNormal;
import com.simulacion.distribuciones.poisson.domain.TablaPoisson;
import com.simulacion.distribuciones.uniformeab.domain.TablaUniformeAB;
import com.simulacion.histogramalib.core.DistribucionEnum;
import com.simulacion.histogramalib.core.Histograma;
import com.simulacion.histogramalib.core.HistogramaFactory;

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

        Histograma histograma = HistogramaFactory.get(DistribucionEnum.UNIFORME_AB,5);
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

        Histograma histograma1 = HistogramaFactory.get(DistribucionEnum.EXPONENCIAL_NEGATIVA, 5);
        histograma1.generarHistograma(tablaExpNegativa.getIteraciones()
                .stream()
                .map(Iteracion::getValor)
                .collect(Collectors.toList()));

        System.out.println("\n.: HISTOGRAMA EXPONENCIAL NEGATIVA :.");
        System.out.println(histograma1);

        System.out.println("\n------------------------------------------------------------------------");
        Tabla tablaPoisson = new TablaPoisson(3.57f);
        tablaPoisson.generarTabla(10);
        System.out.println(".: TABLA POISSON :.");
        System.out.println(tablaPoisson);

        Histograma histograma2 = HistogramaFactory.get(DistribucionEnum.POISSON, 5);
        histograma2.generarHistograma(tablaPoisson.getIteraciones()
                .stream()
                .map(Iteracion::getValor)
                .collect(Collectors.toList()));

        System.out.println("\n.: HISTOGRAMA POISSON :.");
        System.out.println(histograma2);

        System.out.println("\n------------------------------------------------------------------------");
        TablaNormal boxMuller = new BoxMuller(11f, 0.3f);
        boxMuller.generarTabla(300);
        System.out.println(".: TABLA NORMAL - BOX MULLER :.");
        System.out.println(boxMuller);

        Histograma histoBoxMuller = HistogramaFactory.get(DistribucionEnum.NORMAL, 5);
        histoBoxMuller.generarHistograma(boxMuller.getIteraciones()
                .stream()
                .map(IteracionNormal::getValor)
                .collect(Collectors.toList()));

        System.out.println("\n.: HISTOGRAMA NORMAL - BOX MULLER :.");
        System.out.println(histoBoxMuller);
    }
}
