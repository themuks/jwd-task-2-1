package com.kuntsevich.task1.entity;

public enum Os {
    WINDOWS("Windows"),
    LINUX("Linux"),
    MAC_OS("Mac OS");

    String os;

    Os(String os) {
        this.os = os;
    }

    public String getOs() {
        return os;
    }
}
