package net.tracen.umapyoi.utils;

public class MathUtils {
    public static boolean equalsFloat(double a, double b) {
        return Math.abs(a - b) < 1e-9;
    }
}
