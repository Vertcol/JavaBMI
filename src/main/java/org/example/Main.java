package org.example;

import java.util.HashMap;
import java.util.Scanner;

import static org.example.BMIberekening.berekenBMI;
import static org.example.BMIberekening.gezondBMI;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voer uw leeftijd in: ");
        int leeftijd = Integer.valueOf(scanner.nextLine());
        String geslacht = null;

        if (leeftijd <= 18) {
            System.out.println("Voer uw geslacht in (man/vrouw): ");
            geslacht = scanner.nextLine();
        }

        System.out.println("Voer uw lengte in (m): ");
        double lengte = Double.valueOf(scanner.nextLine());

        System.out.println("Voer uw gewicht in (Kg): ");
        double gewicht = Double.valueOf(scanner.nextLine());

        double bmi = BMIberekening.berekenBMI(gewicht, lengte);
        System.out.println("Uw BMI is gelijk aan " + bmi);

        boolean gezonde_bmi = gezondBMI(bmi,leeftijd,geslacht);
        if (gezonde_bmi) {
            System.out.println("Dit is voor uw leeftijd een gezonde BMI");
        } else {
            System.out.println("Dit is voor uw leeftijd geen gezonde BMI");
        }
    }
}