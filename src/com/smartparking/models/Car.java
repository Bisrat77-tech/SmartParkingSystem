package com.smartparking.models;

public class Car extends Vehicle {
   private boolean isElectric;

   public Car(String LicensePlate, String ownerName, boolean isElectric){
       super(LicensePlate, ownerName, "Car");
       this.isElectric = isElectric;
   }
   @Override
    public double calculateParkingFee(int hours){
       double rate = 2.0;
       double fee = rate * hours;
       if (isElectric){
           fee = fee * 0.8;
       }
       this.parkingFee = fee;
       return fee;
   }
   @Override
    public int getRequiredSpots(){
       return 1;
   }

    @Override
    public int getRequiredSports() {
        return 0;
    }

    public boolean isElectric(){
       return isElectric;
   }
}
