package org.example;

import java.util.HashMap;

public class BMIberekening {
    public static double berekenBMI(double gewicht, double lengte) {
        if (gewicht <= 0 || lengte <= 0) { return 0.0; }
        return gewicht / (lengte * lengte);
    }

    // Bronnen van data:
    // https://www.voedingscentrum.nl/bmi
    public static boolean gezondBMI(double bmi, int leeftijd, String geslacht) {
        if (leeftijd < 2 || bmi <= 0) {
            System.out.println("Ongeldige gegevens");
            return false;
        }
        if (leeftijd <= 18) {
            return kinderBMI(leeftijd,geslacht).gezond(bmi);
        } else if (leeftijd <= 69) {
            BMIgrens grens = new BMIgrens(18.5, 25.0, 30.0);
            return grens.gezond(bmi);
        } else {
            BMIgrens grens = new BMIgrens(22.0, 28.0, 30.0);
            return grens.gezond(bmi);
        }
    }


    // Bronnen van data:
    // https://www.voedingscentrum.nl/bmi
    // https://venturing-mag.blogspot.com/2022/06/body-mass-index-voor-kinderen.html
    // De BMI is bij kinderen gedetaileerder en afhankelijk van het geslacht
    public static BMIgrens kinderBMI(int leeftijd, String geslacht) {
        if (geslacht.equals("jongen")) {
            HashMap<Integer,BMIgrens> grenzen = new HashMap<Integer, BMIgrens>();
            grenzen.put(2, new BMIgrens(14.95,18.41,20.09));
            grenzen.put(3, new BMIgrens(14.54,17.89,19.57));
            grenzen.put(4, new BMIgrens(14.30,17.55,19.29));
            grenzen.put(5, new BMIgrens(14.12,17.42,19.30));
            grenzen.put(6, new BMIgrens(14.03,17.55,19.78));
            grenzen.put(7, new BMIgrens(14.06,17.92,20.63));
            grenzen.put(8, new BMIgrens(14.20,18.44,21.60));
            grenzen.put(9, new BMIgrens(14.41,19.10,22.77));
            grenzen.put(10, new BMIgrens(14.69,19.84,24.00));
            grenzen.put(11, new BMIgrens(15.03,20.55,25.10));
            grenzen.put(12, new BMIgrens(15.47,21.22,26.02));
            grenzen.put(13, new BMIgrens(15.98,21.91,26.84));
            grenzen.put(14, new BMIgrens(16.54,22.62,27.63));
            grenzen.put(15, new BMIgrens(17.13,23.29,28.30));
            grenzen.put(16, new BMIgrens(17.70,23.90,28.88));
            grenzen.put(17, new BMIgrens(18.24,24.46,29.41));
            grenzen.put(18, new BMIgrens(18.50,25.00,30.00));

            return grenzen.get(leeftijd);
        } else if (geslacht.equals("meisje")) {
            HashMap<Integer,BMIgrens> grenzen = new HashMap<Integer, BMIgrens>();
            grenzen.put(2, new BMIgrens(14.74,18.02,19.81));
            grenzen.put(3, new BMIgrens(14.38,17.56,19.36));
            grenzen.put(4, new BMIgrens(14.15,17.28,19.15));
            grenzen.put(5, new BMIgrens(13.97,17.15,19.17));
            grenzen.put(6, new BMIgrens(13.92,17.34,19.65));
            grenzen.put(7, new BMIgrens(14.00,17.75,20.51));
            grenzen.put(8, new BMIgrens(14.16,18.35,21.57));
            grenzen.put(9, new BMIgrens(14.42,19.07,22.81));
            grenzen.put(10, new BMIgrens(14.78,19.86,24.11));
            grenzen.put(11, new BMIgrens(15.25,20.74,25.42));
            grenzen.put(12, new BMIgrens(15.83,21.68,26.67));
            grenzen.put(13, new BMIgrens(16.43,21.58,26.76));
            grenzen.put(14, new BMIgrens(17.01,22.34,28.57));
            grenzen.put(15, new BMIgrens(17.52,23.94,29.11));
            grenzen.put(16, new BMIgrens(17.95,23.37,29.43));
            grenzen.put(17, new BMIgrens(18.33,24.70,29.69));
            grenzen.put(18, new BMIgrens(18.50,25.00,30.00));

            return grenzen.get(leeftijd);
        }
        return null;
    }
}
