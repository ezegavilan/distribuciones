package com.simulacion.distribuciones.poisson.domain;

import com.simulacion.distribuciones.core.Iteracion;
import com.simulacion.distribuciones.core.Tabla;

import java.util.Random;

public class TablaPoisson extends Tabla {
    private final float media;

    public TablaPoisson(float media) {
        this.media = media;
    }

    public TablaPoisson(long randomSeed, float media) {
        super(randomSeed);
        this.media = media;
    }

    public TablaPoisson(Random random, float media) {
        super(random);
        this.media = media;
    }

    @Override
    protected Iteracion crearIteracion(int iteracion, float random) {
        float valor = this.calcularValue(random);
        return new Iteracion(iteracion, random, valor);
    }

    @Override
    protected void agregarIteracion(Iteracion iteracion) {
        this.iteraciones.add(iteracion);
    }

    private float calcularValue(float rnd) {
        float p = 1;
        int value = -1;
        float a = (float) Math.exp(-media);

        do {
            p *= rnd;
            value++;
        } while (p > a);

        return value;
    }

    @Override
    public String toString() {
        return "TablaPoisson{" +
                "media=" + media +
                ", iteraciones=" + iteraciones +
                '}';
    }
}
