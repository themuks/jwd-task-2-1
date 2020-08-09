package com.kuntsevich.task1.entity;

public class Oven implements Appliance {
    private int ovenId;
    private int powerConsumption;
    private int weight;
    private int capacity;
    private float height;
    private float width;

    public Oven(int ovenId, int powerConsumption, int weight, int capacity, float height, float width) {
        this.ovenId = ovenId;
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.capacity = capacity;
        this.height = height;
        this.width = width;
    }

    public int getOvenId() {
        return ovenId;
    }

    public void setOvenId(int ovenId) {
        this.ovenId = ovenId;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
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
        Oven oven = (Oven) o;
        return ovenId == oven.ovenId
                && powerConsumption == oven.powerConsumption
                && weight == oven.weight
                && capacity == oven.capacity
                && Float.compare(oven.height, height) == 0
                && Float.compare(oven.width, width) == 0;
    }

    @Override
    public int hashCode() {
        int result = ovenId;
        result = 31 * result + powerConsumption;
        result = 31 * result + weight;
        result = 31 * result + capacity;
        result = 31 * result + (height != +0.0f ? Float.floatToIntBits(height) : 0);
        result = 31 * result + (width != +0.0f ? Float.floatToIntBits(width) : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Oven{");
        sb.append("ovenId=").append(ovenId);
        sb.append(", powerConsumption=").append(powerConsumption);
        sb.append(", weight=").append(weight);
        sb.append(", capacity=").append(capacity);
        sb.append(", height=").append(height);
        sb.append(", width=").append(width);
        sb.append('}');
        return sb.toString();
    }
}
