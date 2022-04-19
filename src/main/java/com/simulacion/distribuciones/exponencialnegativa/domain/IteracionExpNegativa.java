package com.simulacion.distribuciones.exponencialnegativa.domain;

import com.simulacion.distribuciones.core.Iteracion;

public class IteracionExpNegativa extends Iteracion {
    private final float lambda;

    public IteracionExpNegativa(float lambda, int iteracion, float random, float valor) {
        super(iteracion, random, valor);
        this.lambda = lambda;
    }

    @Override
    public String toString() {
        return "IteracionExpNegativa{" +
                "iteracion=" + iteracion +
                ", random=" + random +
                ", valor=" + valor +
                ", lambda=" + lambda +
                '}';
    }
}
