package com.smartparking.services;

import com.smartparking.models.*;
import com.smartparking.models.ParkingSpot;

import java.util.ArrayList;

public class ParkingLot {
    private ArrayList<com.smartparking.models.ParkingSpot> parkingSpots;
    private ArrayList<com.smartparking.models.Vehicle> parkedVehicles;
    private String lotName;
    private int totalRevenue;

    public ParkingLot(String lotName, int totalSpots){
        this.lotName = lotName;
        this.parkingSpots = new ArrayList<>();
        this.parkedVehicles = new ArrayList<>();
        this.totalRevenue = 0;

        for (int i = 1; i<= totalSpots; i++){
            String spotType = "Standard";
            if (i % 5 == 0) spotType = "Electric vehicle";
            if (i % 7 == 0) spotType = "Handicap";
            parkingSpots.add(new ParkingSpot(i, spotType));

        }
    }
    public boolean parkVehicle(Vehicle vehicle, int hours){
        for (ParkingSpot spot : parkingSpots){
            if (!spot.isOccupied()){
                if (spot.parkVehicle(vehicle)){
                    parkedVehicles.add(vehicle);
                    double fee = vehicle.calculateParkingFee(hours);
                    totalRevenue+= fee;
                    System.out.println("Checked"+ vehicle.getVehicleType()+"parked at spot #"+
                            spot.getSpotNumber()+"| Fee: $"+fee);
                    return true;
                }
            }
        }
        System.out.println("No available spots for" + vehicle.getLicensePlate());
        return false;
    }
    public boolean removeVehicle(String LicensePlate){
        for (ParkingSpot spot : parkingSpots){
            if (spot.isOccupied()&& spot.getParkedVehicle().getLicensePlate().equals(LicensePlate)){
                Vehicle removed = spot.removeVehicle();
                parkedVehicles.remove(removed);
                System.out.println("Vehicle"+LicensePlate + "removed from spot #" + spot.getSpotNumber());
                return true;
            }
        }
        System.out.println("Vehicle" + LicensePlate + "not found");
        return false;
    }
    public void displayAllVehicles(){
        System.out.println("\n==== PARKED VEHICLES ====");
        if (parkedVehicles.isEmpty()){
            System.out.println("No vehicles currently parked");
        }else{
            for (Vehicle v : parkedVehicles){
                System.out.println(v);
            }
        }
    }
    public void displayAvailableSpots(){
        System.out.println("\n==== AVAILABLE SPOTS ====");
        int availableCount = 0;
        for (ParkingSpot spot : parkingSpots){
            if (!spot.isOccupied()){
                System.out.println(spot);
                availableCount++;
            }
        }
        System.out.println("total available:" + availableCount +
                "/" + parkingSpots.size());
    }
    public int getTotalRevenue(){return totalRevenue;}
    public String getLotName(){return lotName;}
}
