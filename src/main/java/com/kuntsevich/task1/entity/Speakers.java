package com.kuntsevich.task1.entity;

public class Speakers extends Appliance {
    private int powerConsumption;
    private int numberOfSpeakers;
    private FloatRange frequencyRange;
    private int cordLength;

    public Speakers(int powerConsumption, int numberOfSpeakers, FloatRange frequencyRange, int cordLength) {
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.frequencyRange = frequencyRange;
        this.cordLength = cordLength;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public FloatRange getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(FloatRange frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public int getCordLength() {
        return cordLength;
    }

    public void setCordLength(int cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Speakers speakers = (Speakers) o;
        return powerConsumption == speakers.powerConsumption
                && numberOfSpeakers == speakers.numberOfSpeakers
                && cordLength == speakers.cordLength
                && frequencyRange.equals(speakers.frequencyRange);
    }

    @Override
    public int hashCode() {
        int result = powerConsumption;
        result = 31 * result + numberOfSpeakers;
        result = 31 * result + frequencyRange.hashCode();
        result = 31 * result + cordLength;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Speakers{");
        sb.append("powerConsumption=").append(powerConsumption);
        sb.append(", numberOfSpeakers=").append(numberOfSpeakers);
        sb.append(", frequencyRange=").append(frequencyRange);
        sb.append(", cordLength=").append(cordLength);
        sb.append('}');
        return sb.toString();
    }
}
