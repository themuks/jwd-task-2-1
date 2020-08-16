package com.kuntsevich.task1.exception;

public class ApplianceCreatorException extends Exception {
    public ApplianceCreatorException() {
    }

    public ApplianceCreatorException(String message) {
        super(message);
    }

    public ApplianceCreatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplianceCreatorException(Throwable cause) {
        super(cause);
    }
}
