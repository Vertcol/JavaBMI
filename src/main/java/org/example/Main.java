package org.example;

import java.util.HashMap;

import static org.example.BMIberekening.berekenBMI;

public class Main {


    public static void main(String[] args) {

        System.out.println("Voer uw lengte in (m): ");

        System.out.println("Voer uw gewicht in (Kg): ");

        System.out.println("Uw BMI is gelijk aan " + berekenBMI(65,1.70));
    }
}