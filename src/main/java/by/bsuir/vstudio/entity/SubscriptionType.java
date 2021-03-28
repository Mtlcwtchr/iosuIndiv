package by.bsuir.vstudio.entity;

public enum SubscriptionType {
    NONE(0),
    TRIAL(1),
    MONTHLY(2),
    YEAR(4);

    private final int value;

    SubscriptionType(int value) {
        this.value = value;
    }

    private int getValue() {
        return value;
    }
}
