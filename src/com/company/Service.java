package com.company;

import java.util.Scanner;

public class Service {
    static Scanner scanner = new Scanner(System.in);
    static String truckBrand;
    static String driverName = null;
    static Driver driver = new Driver();
    static String dr = " ";


    public  void changeTruck(Truck[]trucks,int truckId,Driver[]drivers){

    for (int i = 0; i < trucks.length; i++) {
        if (trucks[i].getId() == truckId) {
            if (trucks[i].getDriver().getDriversName() == null) {
                dr = " ";
            } else {
                dr = trucks[i].getDriver().getDriversName();
            }
            truckBrand = trucks[i].getBrand();
            System.out.println("N       :     " + trucks[i].getId());
            System.out.println("Truck   :     " + trucks[i].getBrand());
            System.out.println("Driver  :     " + dr);
            System.out.println("Status  :     " + trucks[i].getStatus());
            if (trucks[i].getStatus().equals(Status.BASE)) {
                System.out.println(truckBrand);
                System.out.println("leave at the base  : press 0");
                System.out.println("let's hit the road : press 1");
                System.out.println("for repairs        : press 2");
                System.out.println("choose a driver    : press 3");
                System.out.println("------------------------------");
                int change = scanner.nextInt();
                if (change == 3) {
                    System.out.println("select driver!");
                    changeDriver(drivers,trucks[i]);
                    trucks[i].setDriver(driver);
                    System.out.println("let's go");
                    change = scanner.nextInt();
                    if (change == 1) {
                        startDriving(truckBrand, driverName);
                        trucks[i].setStatus(Status.ROUTE);
                    } else if (change == 0) {
                        System.out.println("the bus remained at the base");
                    }
                } else if (change == 1) {
                    System.out.println(" select driver!");
                    changeDriver(drivers,trucks[i]);
                    startDriving(truckBrand, driverName);
                    trucks[i].setDriver(driver);
                    trucks[i].setStatus(Status.ROUTE);
                } else if (change == 2) {
                    startRepair(truckBrand);
                    trucks[i].setStatus(Status.REPAIR);

                }
            } else if (trucks[i].getStatus().equals(Status.ROUTE)) {
                    System.out.println(truckBrand + " is on the way");

                } else if (trucks[i].getStatus().equals(Status.REPAIR)) {
                    System.out.println(truckBrand + " is on repair!");
                }
            }
            if (truckId > trucks.length) {
                throw new RuntimeException("select bus");
            }
        }
    }


        public  void changeDriver (Driver[]drivers,Truck truck){
            for (int i = 0; i < drivers.length; i++) {
                if (drivers[i].getDriversId() == truck.getId()) {
                    driverName = drivers[i].getDriversName();
                    driver = drivers[i];

                }
            }

        }

        public static void startDriving (String truckBrand, String driver){
            System.out.println("Bus " + truckBrand + " drives " + driver);

        }
        public static void startRepair (String truck){
            System.out.println("Bus " + truck + "on repair");
        }

}
