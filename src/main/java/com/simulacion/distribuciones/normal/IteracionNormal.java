package com.simulacion.distribuciones.normal;

public class IteracionNormal {
    private final int iteracion;
    private final float valor;

    public IteracionNormal(int iteracion, float valor) {
        this.iteracion = iteracion;
        this.valor = valor;
    }

    public int getIteracion() {
        return iteracion;
    }


    public float getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Iteracion{" +
                "iteracion=" + iteracion +
                ", valor=" + valor +
                '}';
    }
}
