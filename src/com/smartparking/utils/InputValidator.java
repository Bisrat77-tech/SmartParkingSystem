package com.smartparking.utils;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern LICENSE_PATTERN = Pattern.compile("^[A-Z0-9]{3,10}$");

    public static String getValidLicensePlate(Scanner scanner){
        while(true){
            System.out.println("Enter license plate (3-10 chars, uppercase letters/numbers):");
            String input = scanner.nextLine().toUpperCase();

            if (LICENSE_PATTERN.matcher(input).matches()){
                return input;
            }
            System.out.println("Invalid license plate format! Please try again.");
        }
    }
    public static int getPositiveInt(Scanner scanner, String prompt){
        while (true){
            try{
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                if (value > 0){
                    return value;
                }
                System.out.println("Please enter a psitive number!");
            } catch (NumberFormatException e){
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }
}
