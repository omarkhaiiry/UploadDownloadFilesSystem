package io.stc.system.model.enums;


public enum PermissionLevel {
    VIEW("VIEW"),
    EDIT("EDIT");

    private final String value;

    PermissionLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}