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
        int x = -1;
        float A = (float) Math.exp(-media);

        do {
            p = p * rnd;
            x = x + 1;
        } while (p >= A);

        return x;
    }

    @Override
    public String toString() {
        return "TablaPoisson{" +
                "media=" + media +
                ", iteraciones=" + iteraciones +
                '}';
    }
}
