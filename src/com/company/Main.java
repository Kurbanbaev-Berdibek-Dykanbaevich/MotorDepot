package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static GsonBuilder GSON_BUILDER = new GsonBuilder();
    public static Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    public static Path URL = Paths.get("./trucks.json");
    public static void main(String[] args) {
        Truck[]trucks = {
                Truck.createTruck(1,"Renault Magnum",new Driver(),Status.BASE),
                Truck.createTruck(2,"Volvo         ",new Driver(),Status.BASE),
                Truck.createTruck(3,"DAF XT        ",new Driver(),Status.BASE)
        };
//        System.out.println(GSON.toJson(trucks));
//        String json = GSON.toJson(trucks);
//        writeTruck(json);
//        System.out.println(readTruck());
        System.out.println("-------------------------Trucks-------------------------");
        System.out.println("  #|  Bus                 | Driver           |  Status ");
        System.out.println("---+----------------------+------------------+----------");
        Truck[]trucks1 =GSON.fromJson(readTruck(),Truck[].class);
        for (Truck truck : trucks1){
            System.out.println(truck);
        }

    }
    public static void writeTruck(String truck){
        Path write = Paths.get(String.valueOf(URL));
        try {
            Files.writeString(write,truck, StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String readTruck(){
        String  j = "";
        try {
            FileReader reader = new FileReader(String.valueOf(URL));
            int charCount;
            while ((charCount=reader.read())>0){
                j += (char)charCount;

            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return j;

    }

}
