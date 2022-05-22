package com.company;

public class Driver {
private int driversId;
private String driversName;
private String trucksBrand;

    public Driver() {
    }

    public Driver(int driversId, String driversName, String trucksBrand) {
        this.driversId = driversId;
        this.driversName = driversName;
        this.trucksBrand = trucksBrand;
    }

    public int getDriversId() {
        return driversId;
    }

    public void setDriversId(int driversId) {
        this.driversId = driversId;
    }

    public String getDriversName() {
        return driversName;
    }

    public void setDriversName(String driversName) {
        this.driversName = driversName;
    }

    public String getTrucksBrand() {
        return trucksBrand;
    }

    public void setTrucksBrand(String trucksBrand) {
        this.trucksBrand = trucksBrand;
    }

//    @Override
//    public String toString() {
//        return "Driver{" +
//                "driversId=" + driversId +
//                ", driversName='" + driversName + '\'' +
//                ", trucksBrand='" + trucksBrand + '\'' +
//                '}';
//    }
}
