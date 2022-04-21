package com.simulacion.distribuciones.core;

public class Iteracion {
    protected final int iteracion;
    protected final float random;
    protected final float valor;

    public Iteracion(int iteracion, float random, float valor) {
        this.iteracion = iteracion;
        this.random = random;
        this.valor = valor;
    }

    public int getIteracion() {
        return iteracion;
    }

    public float getRandom() {
        return random;
    }

    public float getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Iteracion{" +
                "iteracion=" + iteracion +
                ", random=" + random +
                ", valor=" + valor +
                '}';
    }
}
