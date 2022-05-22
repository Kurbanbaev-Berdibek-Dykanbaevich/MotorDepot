package com.company;

public class Truck {
    private int id;
    private String brand;
    private Driver driver;
    private Status status;

    public int getId() {
        return id;
    }

    public Truck() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public  static  Truck createTruck(int id,String brand,Driver driver,Status status){
        Truck truck = new Truck();
        truck.id = id;
        truck.brand = brand;
        truck.driver = driver;
        truck.status = status;
        return truck;
    }


    public String toString() {
        return " " +
                " " + id + "|" +
                "" + brand + "        |"+
                "                " + driver +"  |"+
                "  " + status ;
    }
}


