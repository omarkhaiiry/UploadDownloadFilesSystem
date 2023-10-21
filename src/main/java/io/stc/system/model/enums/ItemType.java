package io.stc.system.model.enums;

public enum ItemType {
    SPACE("Space"),
    FOLDER("Folder"),
    FILE("File");

    private final String value;

    ItemType(String value) {
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