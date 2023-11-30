package com.achrip.mktracker;

public class MechanicalSwitch extends Switches {
    public MechanicalSwitch() {
    }

    public MechanicalSwitch(String brandName, String modelName, String type, int pinCount) {
        super(brandName, modelName, type, pinCount);
    }

    public MechanicalSwitch(String brandName, String modelName, String type,
                            double preTravelDistance, double totalTravelDistance,
                            double operatingForce, int pinCount) {
        super(brandName, modelName, type, preTravelDistance, totalTravelDistance,
                operatingForce, pinCount);
    }

    @Override
    protected void getInfo() {
        System.out.println(this.getBrandName() + this.getModelName() +
                "\n This is a " + this.getType() +
                " switch by " + this.getBrandName());

        if (this.getTotalTravelDistance() > 0) {
            System.out.printf("It's a %d pin switch, " +
                    "has %.1fmm of total travel distance with %.1fmm of actuation distance" +
                    "With a total operating force of %.1fg\n", this.getPinCount(),
                    this.getTotalTravelDistance(), this.getPreTravelDistance(),
                    this.getOperatingForce());
        }
    }
}
