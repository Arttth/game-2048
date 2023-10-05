package org.example;

public class Block {
    final static int emptyBlock = 0;
    int value;

    public void setValue(int value) {
        this.value = value;
    }

    Block(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

    void updateValue() {
        this.value *= 2;
    }
}
