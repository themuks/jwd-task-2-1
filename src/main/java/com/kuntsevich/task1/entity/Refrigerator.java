package com.kuntsevich.task1.entity;

public class Refrigerator extends Appliance {
    private int powerConsumption;
    private int weight;
    private int freezerCapacity;
    private float overallCapacity;
    private int height;
    private int width;

    public Refrigerator(int powerConsumption, int weight, int freezerCapacity, float overallCapacity, int height, int width) {
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.freezerCapacity = freezerCapacity;
        this.overallCapacity = overallCapacity;
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Refrigerator that = (Refrigerator) o;
        return powerConsumption == that.powerConsumption
                && weight == that.weight
                && freezerCapacity == that.freezerCapacity
                && Float.compare(that.overallCapacity, overallCapacity) == 0
                && height == that.height
                && width == that.width;
    }

    @Override
    public int hashCode() {
        int result = powerConsumption;
        result = 31 * result + weight;
        result = 31 * result + freezerCapacity;
        result = 31 * result + (overallCapacity != +0.0f ? Float.floatToIntBits(overallCapacity) : 0);
        result = 31 * result + height;
        result = 31 * result + width;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Refrigerator{");
        sb.append("powerConsumption=").append(powerConsumption);
        sb.append(", weight=").append(weight);
        sb.append(", freezerCapacity=").append(freezerCapacity);
        sb.append(", overallCapacity=").append(overallCapacity);
        sb.append(", height=").append(height);
        sb.append(", width=").append(width);
        sb.append('}');
        return sb.toString();
    }
}
