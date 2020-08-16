package com.kuntsevich.task1.entity;

public class FloatRange {
    private float from;
    private float to;

    public FloatRange(float from, float to) {
        this.from = from;
        this.to = to;
    }

    public float getFrom() {
        return from;
    }

    public void setFrom(float from) {
        this.from = from;
    }

    public float getTo() {
        return to;
    }

    public void setTo(float to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FloatRange that = (FloatRange) o;
        return Float.compare(that.from, from) == 0
                && Float.compare(that.to, to) == 0;
    }

    @Override
    public int hashCode() {
        int result = (from != +0.0f ? Float.floatToIntBits(from) : 0);
        result = 31 * result + (to != +0.0f ? Float.floatToIntBits(to) : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FloatRange{");
        sb.append("from=").append(from);
        sb.append(", to=").append(to);
        sb.append('}');
        return sb.toString();
    }
}
