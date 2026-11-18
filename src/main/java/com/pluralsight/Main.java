package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        ArrayList<Asset> assets = new ArrayList<>();

        House house1 = new House("Family Home", "2020-05-15", new BigDecimal("350000"), "123 Main Street", 1, 2000, 5000);
        assets.add(house1);

        House house2 = new House("Vacation Home", "2019-08-10", new BigDecimal("250000"), "456 Oak Street", 3, 1500, 4000);
        assets.add(house2);

        Vehicle vehicle1 = new Vehicle("Family Car", "2022-03-10", new BigDecimal("30000"), "Honda Accord", 2022, 45000);
        assets.add(vehicle1);

        Vehicle vehicle2 = new Vehicle("Work Truck", "2021-06-20", new BigDecimal("40000"), "Ford F-150", 2021, 120000);
        assets.add(vehicle2);

        for (Asset asset : assets) {

            System.out.println("Description: " + asset.getDescription());
            System.out.println("Date Acquired: " + asset.getDateAcquired());
            System.out.println("Original Cost: " + asset.getOriginalCost());
            System.out.println("Current Value: " + asset.getValue());

            System.out.println("----------------------------");

            if (asset instanceof House) {
                House house = (House) asset;
                System.out.println("Address: " + house.getAddress());
            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                System.out.println("Year: " + vehicle.getYear());
                System.out.println("Make/Model: " + vehicle.getMakeModel());

            }
        }

    }

}
