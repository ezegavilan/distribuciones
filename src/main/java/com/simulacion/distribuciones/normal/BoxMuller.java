package com.simulacion.distribuciones.normal;

public class BoxMuller extends TablaNormal {
    private final float media;
    private final float desvEstandar;

    public BoxMuller(float media, float desvEstandar) {
        super();
        this.media = media;
        this.desvEstandar = desvEstandar;
    }

    @Override
    public void generarTabla(int n) {
        IteracionNormal iteracionActual;
        int it;
        float rnd1, rnd2;
        for (int i = 0; i < n; i++) {
            it = i + 1;
            rnd1 = this.random.nextFloat();
            rnd2 = this.random.nextFloat();

            if (i % 2 == 0) {
                iteracionActual = new IteracionNormal(it, calcularN1(rnd1, rnd2));
            } else {
                iteracionActual = new IteracionNormal(it, calcularN2(rnd1, rnd2));
            }

            this.agregarIteracion(iteracionActual);
        }
    }

    private float calcularN1(float rnd1, float rnd2) {
        return (float) ((Math.sqrt(-2 * Math.log(rnd1)) * Math.cos(2*Math.PI*rnd2)) * (desvEstandar + media));
    }

    private float calcularN2(float rnd1, float rnd2) {
        return (float) ((Math.sqrt(-2 * Math.log(rnd1)) * Math.sin(2*Math.PI*rnd2)) * (desvEstandar + media));
    }

}
