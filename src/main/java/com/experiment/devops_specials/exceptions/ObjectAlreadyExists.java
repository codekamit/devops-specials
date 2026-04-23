package com.experiment.devops_specials.exceptions;

public class ObjectAlreadyExists extends RuntimeException {

    private static final String message = "Object already exists";

    public ObjectAlreadyExists() {
        super(message);
    }

    public ObjectAlreadyExists(String message) {
        super(message);
    }
}
