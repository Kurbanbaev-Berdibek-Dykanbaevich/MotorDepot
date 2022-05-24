package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    public static GsonBuilder GSON_BUILDER = new GsonBuilder();
    public static Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    public static Path URL = Paths.get("./trucks.json");
    public static Path URL1 = Paths.get("./driver.json");
    public static void main(String[] args) {


        Truck[] trucks = {
                Truck.createTruck(1, "Renault Magnum", new Driver(), Status.BASE),
                Truck.createTruck(2, "Volvo         ", new Driver(), Status.BASE),
                Truck.createTruck(3, "DAF XT        ", new Driver(), Status.BASE)
        };
        Driver[] drivers = {
                Driver.createDriver(1, "John", " "),
                Driver.createDriver(2, "Robert", " "),
                Driver.createDriver(3, "Stephan", " "),
        };

//        System.out.println(GSON.toJson(trucks));
//        String json = GSON.toJson(trucks);
//        writeTruck(json);
//        System.out.println(readTruck());
//        System.out.println(GSON.toJson(drivers));
//        String json1 = GSON.toJson(drivers);
//        writeDriver(json1);
//        System.out.println(readDriver());

        System.out.println("---+---------* Information about buses *-----+----------");
        System.out.println("  #|  Bus                 | Driver           |  Status ");
        System.out.println("---+----------------------+------------------+----------");

        Truck[] trucks1 = GSON.fromJson(readTruck(), Truck[].class);
        for (Truck truck : trucks1) {
            System.out.println(truck);
        }
        System.out.println();
        System.out.println("---+----------+----* drivers info *-----------+------------");
        System.out.println("  #| Driver   |  Bus  ");
        System.out.println("---+----------+-------- ");
        Driver[] drivers1 = GSON.fromJson(readDriver(), Driver[].class);
        for (Driver driver : drivers1) {
            System.out.println(driver.info());
        }
            while (true){
                try {
                    Service truckService = new Service();
                    Scanner sc = new Scanner(System.in);
                    System.out.println("select a bus");
                    int truck = sc.nextInt();


                    if(truck == 0){
                        break;
                    }truckService.changeTruck(trucks,truck,drivers);
                    for (Truck truck1 : trucks){
                        if (truck1.getId() == truck){
                            System.out.println("N       :     " + truck1.getId());
                            System.out.println("Truck   :     " + truck1.getBrand());
                            System.out.println("Driver  :     " + truck1.getDriver().getDriversName());
                            System.out.println("Status  :     " + truck1.getStatus());

                        }

                    }

                }catch (RuntimeException r){
                    System.out.println(r.getMessage());
                }
            }
        }
        public static void writeTruck (String truck){
            Path write = Paths.get(String.valueOf(URL));
            try {
                Files.writeString(write, truck, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static String readTruck () {
            String j = "";
            try {
                FileReader reader = new FileReader(String.valueOf(URL));
                int charCount;
                while ((charCount = reader.read()) > 0) {
                    j += (char) charCount;

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return j;

        }
        public static void writeDriver (String driver){
            Path write = Paths.get(String.valueOf(URL1));
            try {
                Files.writeString(write, driver, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static String readDriver () {
            String k = " ";
            try {
                FileReader reader = new FileReader(String.valueOf(URL1));
                int charCount;
                while ((charCount = reader.read()) > 0) {
                    k += (char) charCount;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return k;
        }


}
