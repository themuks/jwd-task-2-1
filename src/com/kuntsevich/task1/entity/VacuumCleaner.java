package com.kuntsevich.task1.entity;

public class VacuumCleaner implements Appliance {
    private int powerConsumption;
    private FilterType filterType;
    private String bagType;
    private String wandType;
    private int motorSpeedRegulation;
    private int cleaningWidth;

    public VacuumCleaner(int powerConsumption, FilterType filterType, String bagType, String wandType, int motorSpeedRegulation, int cleaningWidth) {
        this.powerConsumption = powerConsumption;
        this.filterType = filterType;
        this.bagType = bagType;
        this.wandType = wandType;
        this.motorSpeedRegulation = motorSpeedRegulation;
        this.cleaningWidth = cleaningWidth;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public FilterType getFilterType() {
        return filterType;
    }

    public void setFilterType(FilterType filterType) {
        this.filterType = filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    public int getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(int motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public int getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(int cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VacuumCleaner that = (VacuumCleaner) o;
        return powerConsumption == that.powerConsumption
                && motorSpeedRegulation == that.motorSpeedRegulation
                && cleaningWidth == that.cleaningWidth
                && filterType == that.filterType
                && bagType.equals(that.bagType)
                && wandType.equals(that.wandType);
    }

    @Override
    public int hashCode() {
        int result = powerConsumption;
        result = 31 * result + filterType.hashCode();
        result = 31 * result + bagType.hashCode();
        result = 31 * result + wandType.hashCode();
        result = 31 * result + motorSpeedRegulation;
        result = 31 * result + cleaningWidth;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("VacuumCleaner{");
        sb.append("powerConsumption=").append(powerConsumption);
        sb.append(", filterType=").append(filterType);
        sb.append(", bagType='").append(bagType).append('\'');
        sb.append(", wandType='").append(wandType).append('\'');
        sb.append(", motorSpeedRegulation=").append(motorSpeedRegulation);
        sb.append(", cleaningWidth=").append(cleaningWidth);
        sb.append('}');
        return sb.toString();
    }
}
