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

        System.out.println("Voer uw geslacht in (man/vrouw): ");
        String geslacht = scanner.nextLine();

        System.out.println("Voer uw afkomst in (Westen/Aziatisch): ");
        String afkomst = scanner.nextLine();

        System.out.println("Voer uw middelomtrek (cm): ");
        int middelomtrek = Integer.valueOf(scanner.nextLine());

        System.out.println("Voer uw lengte in (m): ");
        double lengte = Double.valueOf(scanner.nextLine());

        System.out.println("Voer uw gewicht in (Kg): ");
        double gewicht = Double.valueOf(scanner.nextLine());

        BMIberekening berekening = new BMIberekening(leeftijd,gewicht,lengte,geslacht,middelomtrek,afkomst);

        double bmi = berekening.berekenBMI();
        System.out.println("Uw BMI is gelijk aan " + bmi);

        boolean gezonde_bmi = berekening.gezondBMI();
        if (gezonde_bmi) {
            System.out.println("Dit is voor uw leeftijd een gezonde BMI");
        } else {
            System.out.println("Dit is voor uw leeftijd geen gezonde BMI");
        }
    }
}