package com.simulacion.distribuciones.normal.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class TablaNormal {
    protected final List<IteracionNormal> iteraciones;
    protected final Random random;

    public TablaNormal() {
        this(new Random());
    }

    public TablaNormal(long randomSeed) {
        this(new Random(randomSeed));
    }

    public TablaNormal(Random random) {
        this.iteraciones = new ArrayList<>();
        this.random = random;
    }

    public abstract void generarTabla(int n);

    public List<IteracionNormal> getIteraciones() {
        return iteraciones;
    }

    protected void agregarIteracion(IteracionNormal iteracion) {
        this.iteraciones.add(iteracion);
    }

    @Override
    public String toString() {
        return "TablaNormal{" +
                "iteraciones=" + iteraciones +
                '}';
    }
}
