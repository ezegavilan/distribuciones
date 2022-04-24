package com.simulacion.distribuciones;

public class PoissonApp {
    public static void main(String[] args) {
        double media = 3;
        double random;
        for (int i = 0; i < 10; i++) {
            double p = 1.0;
            int x = -1;
            double A = Math.exp(-media);

            do {
                random = Math.random();
                x++;
                p *= random;
                System.out.println(media);
                System.out.println(random);
            } while (p >= A);

            System.out.println("X: " + x);
        }
    }
}
