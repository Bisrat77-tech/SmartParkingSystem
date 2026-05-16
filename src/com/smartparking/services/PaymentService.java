package com.smartparking.services;
import com.smartparking.models.Vehicle;

import java.util.Scanner;

public class PaymentService {
    public void processPayment(double amount){
        System.out.println("\n=====PAYMENT DETAILS =====");
        System.out.println("Vehicle:" + Vehicle.getLicensePlate());
        System.out.println("Amount due: $" + amount);

        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Enter payment amount: $");
            double payment = scanner.nextDouble();

            if(payment >= amount){
                double change = payment - amount;
                System.out.println("Payment Successful!");
                if(change>0){
                 System.out.println("Change: $" + change);

                }
                System.out.println("Receipt printed. Thank you!");
            }else{
                System.out.println("Insufficient payment. Please pay full amount.");
                processPayment(amount);
            }
        }catch (Exception e){
            System.out.println("Error processing payment:" + e.getMessage());
        }
    }
}
