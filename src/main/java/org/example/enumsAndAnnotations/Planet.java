package org.example.enumsAndAnnotations;

public enum Planet {
    PAMANT(3.303e+23, 2.4397e6),
    MERCUR(4.869e+24, 6.0518e6),
    VENUS(4.869e+24, 6.0518e6),
    PLUTO(4.869e+24, 6.0518e6),
    MARTE(4.869e+24, 6.0518e6),
    SATURN(4.869e+24, 6.0518e6);

    private final double mass;
    private final double radius;
    public static final double G = 6.67300E-11;
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    double surfaceGravity() { return G * mass / (radius * radius); }
    double weight(double m) { return m * surfaceGravity(); }
}
