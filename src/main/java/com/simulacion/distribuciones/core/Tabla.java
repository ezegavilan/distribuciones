package com.simulacion.distribuciones.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Tabla {
    protected final List<Iteracion> iteraciones;
    protected final Random random;

    public Tabla() {
        this(new Random());
    }

    public Tabla(long randomSeed) {
        this(new Random(randomSeed));
    }

    public Tabla(Random random) {
        this.iteraciones = new ArrayList<>();
        this.random = random;
    }

    public void generarTabla(int n) {
        Iteracion currentIteracion;
        float rnd;
        int it;
        for (int i = 0; i < n; i++) {
            it = i+1;
            rnd = this.random.nextFloat();
            currentIteracion = this.crearIteracion(it, rnd);
            this.agregarIteracion(currentIteracion);
        }
    }

    public List<Iteracion> getIteraciones() {
        return iteraciones;
    }

    protected abstract Iteracion crearIteracion(int iteracion, float random);

    protected abstract void agregarIteracion(Iteracion iteracion);


}
