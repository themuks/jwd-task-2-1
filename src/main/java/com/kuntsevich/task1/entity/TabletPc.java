package com.kuntsevich.task1.entity;

public class TabletPc extends Appliance {
    private int batteryCapacity;
    private int displayInches;
    private int memoryRom;
    private int flashMemoryCapacity;
    private CustomColor color;

    public TabletPc(int batteryCapacity, int displayInches, int memoryRom, int flashMemoryCapacity, CustomColor color) {
        this.batteryCapacity = batteryCapacity;
        this.displayInches = displayInches;
        this.memoryRom = memoryRom;
        this.flashMemoryCapacity = flashMemoryCapacity;
        this.color = color;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(int displayInches) {
        this.displayInches = displayInches;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }

    public int getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(int flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public CustomColor getColor() {
        return color;
    }

    public void setColor(CustomColor color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TabletPc tabletPc = (TabletPc) o;
        return batteryCapacity == tabletPc.batteryCapacity
                && displayInches == tabletPc.displayInches
                && memoryRom == tabletPc.memoryRom
                && flashMemoryCapacity == tabletPc.flashMemoryCapacity
                && color == tabletPc.color;
    }

    @Override
    public int hashCode() {
        int result = batteryCapacity;
        result = 31 * result + displayInches;
        result = 31 * result + memoryRom;
        result = 31 * result + flashMemoryCapacity;
        result = 31 * result + color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TabletPc{");
        sb.append("batteryCapacity=").append(batteryCapacity);
        sb.append(", displayInches=").append(displayInches);
        sb.append(", memoryRom=").append(memoryRom);
        sb.append(", flashMemoryCapacity=").append(flashMemoryCapacity);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}
