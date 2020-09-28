package de.neuefische.exercises;

import java.util.Scanner;

public class Excercise_20200925 {


    public static void main(String[] args) {
        Scanner eingabewert = new Scanner (System.in);

        System.out.println("Bitte bestimmen Sie Ihr Passwort: ");
        String password = eingabewert.nextLine();

        boolean isValid= SecurityUtils_20200925.validatePassword(password);

        if (isValid) {
            System.out.println("Passwort ist gespeichert");
        } else {
            System.out.println("Passwort ist nicht valide");
        }

    }

}
