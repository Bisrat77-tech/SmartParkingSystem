package com.smartparking.models;

public class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;
    private Vehicle parkedVehicle;
    private String spotType;

    public ParkingSpot(int spotNumber, String spotType){
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.isOccupied = false;
        this.parkedVehicle = null;
    }

    public boolean parkVehicle(Vehicle vehicle){
        if (!isOccupied){
            this.parkedVehicle = vehicle;
            this.isOccupied = true;
            return true;
        }
        return false;
    }
    public Vehicle removeVehicle(){
        Vehicle removed = this.parkedVehicle;
        this.parkedVehicle = null;
        this.isOccupied = false;
        return removed;
    }
    public int getSpotNumber(){return spotNumber;}
    public boolean isOccupied(){return isOccupied;}
    public Vehicle getParkedVehicle(){return parkedVehicle;}
    public String getSpotType(){return spotType;}

    @Override
    public String toString(){
        return "Spot #" + spotNumber + "(" + spotType + ") - " + (isOccupied ? "Occupied by:" +
                parkedVehicle.getLicensePlate() : "Available");
    }
}
