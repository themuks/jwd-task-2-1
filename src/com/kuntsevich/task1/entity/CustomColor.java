package com.kuntsevich.task1.entity;

public enum CustomColor {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue");

    String colorName;

    CustomColor(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }
}
