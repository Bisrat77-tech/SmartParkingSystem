package com.smartparking.models;

public class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String LicensePlate, String ownerName, boolean hasSidecar){
        super(LicensePlate,ownerName,"Motorcycle");
        this.hasSidecar = hasSidecar;
    }

    @Override
    public double calculateParkingFee(int hours){
        double rate  = 1.0;
        this.parkingFee = rate * hours;
        return parkingFee;
    }

    @Override
    public int getRequiredSpots() {
        return 0;
    }

    @Override
    public int getRequiredSports(){
        return hasSidecar ? 1 : 1;
    }
    public boolean hasSidecar(){
        return hasSidecar;
    }
}
