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
        double p = 1.0;
        int x = -1;
        double A = Math.exp(-media);

        do {
            x++;
            p *= rnd;
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
