package com.simulacion.distribuciones.uniformeab.domain;

import com.simulacion.distribuciones.core.Iteracion;
import com.simulacion.distribuciones.core.Tabla;

import java.util.Random;

public class TablaUniformeAB extends Tabla {

    private final float extremoIzquierdo;
    private final float extremoDerecho;

    public TablaUniformeAB(float extremoIzquierdo, float extremoDerecho) {
        this.extremoIzquierdo = extremoIzquierdo;
        this.extremoDerecho = extremoDerecho;
    }

    public TablaUniformeAB(long randomSeed, float extremoIzquierdo, float extremoDerecho) {
        super(randomSeed);
        this.extremoIzquierdo = extremoIzquierdo;
        this.extremoDerecho = extremoDerecho;
    }

    public TablaUniformeAB(Random random, float extremoIzquierdo, float extremoDerecho) {
        super(random);
        this.extremoIzquierdo = extremoIzquierdo;
        this.extremoDerecho = extremoDerecho;
    }

    @Override
    public Iteracion crearIteracion(int iteracion, float random) {
        float valor = calcularValor(random);
        return new Iteracion(iteracion, random, valor);
    }

    @Override
    public void agregarIteracion(Iteracion iteracion) {
        this.iteraciones.add(iteracion);
    }

    private float calcularValor(float rnd) {
        return extremoIzquierdo + rnd * (extremoDerecho - extremoIzquierdo);
    }

    @Override
    public String toString() {
        return "TablaUniformeAB{" +
                "iteraciones=" + iteraciones +
                ", extremoIzquierdo=" + extremoIzquierdo +
                ", extremoDerecho=" + extremoDerecho +
                '}';
    }
}
