package by.bsuir.vstudio.entity;

public enum OscarStatus {

    HAS_NOT(0),
    HAS(1),
    CANCELLED(2);

    private final int value;

    OscarStatus(int value) {
        this.value = value;
    }

    private int getValue() {
        return value;
    }
}
