package fr.afpa;

public class ColorHelper {
    public static String hexaColor(int r, int g, int b) {

        return String.format("#%02X%02X%02X",
                r * 255,
                g * 255,
                b * 255
                );
    }
}
