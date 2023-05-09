package org.example;

public class BMIgrens {
    // Grenzen
    private double ondergewicht;
    private double gezond;
    private double overgewicht;

    public BMIgrens(double ondergewicht, double gezond, double overgewicht) {
        this.ondergewicht = ondergewicht;
        this.gezond = gezond;
        this.overgewicht = overgewicht;
    }

    // Bepaald of de BMI gezond is op basis van een stel grenzen
    public boolean gezond(double bmi) {
        if (bmi < ondergewicht) {
            System.out.println("Ondergewicht");
            return false;
        } else if (bmi < gezond) {
            System.out.println("Gezond gewicht");
            return true;
        } else if (bmi < overgewicht) {
            System.out.println("Overgewicht");
            return false;
        } else {
            System.out.println("Ernstig overgewicht");
            return false;
        }
    }
}
