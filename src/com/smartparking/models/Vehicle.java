package com.smartparking.models;

public abstract class Vehicle {
    private static String LicensePlate;
    private String ownerName;
    private String vehicleType;
    protected double parkingFee;

    public Vehicle(String licensePlate, String ownerName, String vehicleType){
        this.LicensePlate = licensePlate;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.parkingFee = 0.0d;
    }

    public static String getLicensePlate(){
        return LicensePlate;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public String getVehicleType(){
        return vehicleType;
    }

    public double getParkingFee(){
        return parkingFee;
    }

    public abstract double calculateParkingFee(int hours);
    public abstract int getRequiredSpots();

    @Override
    public String toString(){
        return "License:" + LicensePlate + "| Owner:" + ownerName + "Type:" + vehicleType;
    }

    public abstract int getRequiredSports();
}
