package com.pluralsight;

import java.math.BigDecimal;

public class Vehicle extends Asset{

    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public BigDecimal getValue() {
        int age = 2026 - year;

        double depreciationRate = 0;

        if (age <= 3) {
            depreciationRate = 0.03;
        } else if (age <= 6) {
            depreciationRate = 0.06;

        } else if (age <= 10) {
            depreciationRate = 0.08;

        }

        if (age > 10) {
            return BigDecimal.valueOf(1000);
        }
        BigDecimal depreciation = getOriginalCost().multiply(BigDecimal.valueOf(depreciationRate * age));
        BigDecimal value = getOriginalCost().subtract(depreciation);

        if (odometer > 100000 && !makeModel.contains("Honda") && !makeModel.contains("Toyota")) {
            value = value.multiply(BigDecimal.valueOf(0.75));
        }
        return value;

    }
}
