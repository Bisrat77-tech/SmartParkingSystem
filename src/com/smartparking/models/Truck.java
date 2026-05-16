package com.smartparking.models;
public class Truck extends Vehicle{
    private double weight;

    public Truck(String LicensePlate, String ownerName, double weight){
        super(LicensePlate,ownerName,"Truck");
        this.weight = weight;
    }

    @Override
    public double calculateParkingFee(int hours){
        double rate = 5.0;
        double fee = rate * hours;
        if (weight > 3.5){
            fee = fee * 1.5;
        }
        this.parkingFee = fee;
        return fee;

    }
    @Override
    public int getRequiredSpots(){
        return weight > 3.5 ? 2 : 1;
    }

    @Override
    public int getRequiredSports() {
        return 0;
    }

    public double getWeight(){
        return weight;
    }

}
