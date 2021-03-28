package by.bsuir.vstudio.entity;

public enum SignificanceStatus {

    NONE(0),
    OSCAR_VALUABLE(1),
    RATING_VALUABLE(2),
    BOTH_VALUABLE(4);

    private final int value;

    SignificanceStatus(int value) {
        this.value = value;
    }

    private int getValue() {
        return value;
    }
}
