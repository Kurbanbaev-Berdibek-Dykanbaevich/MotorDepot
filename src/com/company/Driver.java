package com.company;

public class Driver {
private int driversId;
private String driversName;
private String trucksBrand;

    public Driver() {
    }

    public static Driver createDriver(int driversId, String driversName, String trucksBrand) {
        Driver driver = new Driver();
        driver.driversId = driversId;
        driver.driversName = driversName;
        driver.trucksBrand = trucksBrand;
        return driver;
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

    @Override
    public String toString() {
        return " ";
    }
    public String info(){
        return driversId +"  | "+ driversName +"  | "+trucksBrand;
    }
}

