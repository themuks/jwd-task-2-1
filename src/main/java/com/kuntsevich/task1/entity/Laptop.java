package com.kuntsevich.task1.entity;

public class Laptop implements Appliance {
    private float batteryCapacity;
    private Os os;
    private int memoryRom;
    private int systemMemory;
    private float cpu;
    private int displayInches;

    public Laptop(float batteryCapacity, Os os, int memoryRom, int systemMemory, float cpu, int displayInches) {
        this.batteryCapacity = batteryCapacity;
        this.os = os;
        this.memoryRom = memoryRom;
        this.systemMemory = systemMemory;
        this.cpu = cpu;
        this.displayInches = displayInches;
    }

    public float getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(float batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Os getOs() {
        return os;
    }

    public void setOs(Os os) {
        this.os = os;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(int systemMemory) {
        this.systemMemory = systemMemory;
    }

    public float getCpu() {
        return cpu;
    }

    public void setCpu(float cpu) {
        this.cpu = cpu;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(int displayInches) {
        this.displayInches = displayInches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Laptop laptop = (Laptop) o;
        return Float.compare(laptop.batteryCapacity, batteryCapacity) == 0
                && memoryRom == laptop.memoryRom
                && systemMemory == laptop.systemMemory
                && Float.compare(laptop.cpu, cpu) == 0
                && displayInches == laptop.displayInches
                && os == laptop.os;
    }

    @Override
    public int hashCode() {
        int result = (batteryCapacity != +0.0f ? Float.floatToIntBits(batteryCapacity) : 0);
        result = 31 * result + os.hashCode();
        result = 31 * result + memoryRom;
        result = 31 * result + systemMemory;
        result = 31 * result + (cpu != +0.0f ? Float.floatToIntBits(cpu) : 0);
        result = 31 * result + displayInches;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Laptop{");
        sb.append("batteryCapacity=").append(batteryCapacity);
        sb.append(", os=").append(os);
        sb.append(", memoryRom=").append(memoryRom);
        sb.append(", systemMemory=").append(systemMemory);
        sb.append(", cpu=").append(cpu);
        sb.append(", displayInches=").append(displayInches);
        sb.append('}');
        return sb.toString();
    }
}

