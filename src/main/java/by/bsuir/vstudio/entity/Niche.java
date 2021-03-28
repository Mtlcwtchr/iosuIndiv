package by.bsuir.vstudio.entity;

public enum Niche {

    NONE(0),
    ACTOR(1),
    DIRECTOR(2),
    PRODUCER(4);

    private final int value;

    Niche(int value) {
        this.value = value;
    }

    private int getValue() {
        return value;
    }
}
