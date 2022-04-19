package com.simulacion.distribuciones.exponencialnegativa.domain;

import com.simulacion.distribuciones.core.Iteracion;
import com.simulacion.distribuciones.core.Tabla;
import com.simulacion.histogramalib.core.Decimal;

import java.util.Random;

public class TablaExponencialNegativa extends Tabla {
    private final float media;
    private final float lambda;

    public TablaExponencialNegativa(float media) {
        this.media = media;
        this.lambda = 1f/media;
    }

    public TablaExponencialNegativa(long randomSeed, float media) {
        super(randomSeed);
        this.media = media;
        this.lambda = 1f/media;
    }

    public TablaExponencialNegativa(Random random, float media) {
        super(random);
        this.media = media;
        this.lambda = 1f/media;
    }

    @Override
    protected Iteracion crearIteracion(int iteracion, float random) {
        float valor = this.calcularValor(random);
        float lambda = this.calcularLambda(valor);
        return new IteracionExpNegativa(lambda, iteracion, random, valor);
    }

    @Override
    protected void agregarIteracion(Iteracion iteracion) {
        this.iteraciones.add(iteracion);
    }

    private float calcularLambda(float media) {
        return Decimal.of(1f /media).value();
    }

    private float calcularValor(float rnd) {
        return Decimal.of((float) (-media * Math.log(1 - rnd))).value();
    }

    @Override
    public String toString() {
        return "TablaExponencialNegativa{" +
                "media=" + media +
                ", lambda=" + lambda +
                ", iteraciones=" + iteraciones +
                '}';
    }
}
