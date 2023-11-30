package com.achrip.mktracker;

public abstract class Switches {
    private String brandName, modelName, type;
    private double preTravelDistance, totalTravelDistance, operatingForce;

    private int pinCount;

    public Switches() { /**/ }

    public Switches(String brandName, String modelName, String type, int pinCount) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.type = type;
        this.pinCount = pinCount;
    }

    public Switches(String brandName, String modelName, String type,
                    double preTravelDistance, double totalTravelDistance,
                    double operatingForce, int pinCount) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.type = type;
        this.preTravelDistance = preTravelDistance;
        this.totalTravelDistance = totalTravelDistance;
        this.operatingForce = operatingForce;
        this.pinCount = pinCount;
    }

    protected abstract void getInfo();

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPreTravelDistance() {
        return preTravelDistance;
    }

    public void setPreTravelDistance(double preTravelDistance) {
        this.preTravelDistance = preTravelDistance;
    }

    public double getTotalTravelDistance() {
        return totalTravelDistance;
    }

    public void setTotalTravelDistance(double totalTravelDistance) {
        this.totalTravelDistance = totalTravelDistance;
    }

    public double getOperatingForce() {
        return operatingForce;
    }

    public void setOperatingForce(double operatingForce) {
        this.operatingForce = operatingForce;
    }

    public int getPinCount() {
        return pinCount;
    }

    public void setPinCount(int pinCount) {
        this.pinCount = pinCount;
    }
}