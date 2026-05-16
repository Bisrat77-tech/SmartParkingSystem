package com.smartparking;

import com.smartparking.models.*;
import com.smartparking.services.*;
import com.smartparking.services.ParkingLot;
import com.smartparking.services.PaymentService;
import com.smartparking.utils.InputValidator;

import java.io.InputStream;
import java.util.Scanner;

public class Main{
    private static ParkingLot parkingLot;
    private static PaymentService paymentService;
    private static Scanner scanner;

    void main(){
        initializeSystem();
        boolean running = true;
        while (running){
            displayMenu();

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch(choice){
                    case 1 :
                            parkVehicleMenu();
                            break;

                    case 2 :
                            removeVehicleMenu();
                            break;

                    case 3 :
                           parkingLot.displayAllVehicles();
                            break;

                    case 4 :
                           parkingLot.displayAvailableSpots();
                            break;
                    case 5 :
                           displayRevenue();
                            break;
                    case 6 :
                        System.out.println("Thank you for using Smart Parking System!");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid Choice! Please try again.");

                }
            } catch (NumberFormatException e){
                System.out.println("Please enter a valid number!");
            } catch (Exception e){
                System.out.println("An error occurred:" + e.getMessage());
            }
        }
        scanner.close();

    }
    private static void initializeSystem(){
        scanner = new Scanner(System.in);
        System.out.println("Enter parking lot name:");
        String lotName = scanner.nextLine();
        System.out.println("Enter total number of spots:");
        int totalSpots = InputValidator.getPositiveInt(scanner,"");

        parkingLot = new ParkingLot(lotName, totalSpots);
        paymentService = new PaymentService();

        System.out.println("\n" + lotName + "initialized with" + totalSpots + "spots\n");
    }
    private static void displayMenu(){
        System.out.println("\n==== SMART PARKING SYSTEM ====");
        System.out.println("1. Park a vehicle");
        System.out.println("2. Remove a vehicle ");
        System.out.println("3. View all parked vehicles");
        System.out.println("4. View available spots");
        System.out.println("5. View total revenue");
        System.out.println("6. Exit");
        System.out.println("Choose option: ");
    }

    private static void parkVehicleMenu(){
        System.out.println("\n ==== PARK VEHICLE ===");
        System.out.println(" 1. Car");
        System.out.println(" 2. Motorcycle");
        System.out.println(" 3. Truck");
        System.out.println("Select vehicle type: ");

        try{
            int type =  Integer.parseInt(scanner.nextLine());
            String LicensePlate = InputValidator.getValidLicensePlate(scanner);
            System.out.println("Enter Owner Name: ");
            String ownerName = scanner.nextLine();
            System.out.println("Enter parking hours: ");
            int hours = Integer.parseInt(scanner.nextLine());

            Vehicle vehicle = null;

            switch (type) {
                case 1:
                    System.out.println("Is electric? (yes/no)");
                    boolean isElectric = scanner.nextLine().equalsIgnoreCase("Yes");
                    vehicle = new Car(LicensePlate, ownerName, isElectric);
                    break;
                case 2:
                    System.out.println("Has sidecar?(yes/no)");
                    boolean hasSidecar = scanner.nextLine().equalsIgnoreCase("Yes");
                    vehicle = new Motorcycle(LicensePlate, ownerName, hasSidecar);
                    break;
                case 3:
                    System.out.println("Enter Weight in tons: ");
                    double weight = Double.parseDouble(scanner.nextLine());
                    vehicle = new Truck(LicensePlate, ownerName, weight);
                    break;
                default:
                    System.out.println("Invalid vehicle type!");
                    return;


            }
            if (parkingLot.parkVehicle(vehicle, hours)){
                paymentService.processPayment(vehicle.getParkingFee());
            }
        }catch (NumberFormatException e){
            System.out.println("Invalid input!");
        }
    }
    private static void removeVehicleMenu(){
        System.out.print("Enter license plate to remove: ");
        String LicensePlate = scanner.nextLine().toUpperCase();
        parkingLot.removeVehicle(LicensePlate);
    }
    private static void displayRevenue(){
        System.out.println("\n==== TOTAL REVENUE ====");
        System.out.println("Total collected: $" + parkingLot.getTotalRevenue());

    }
}