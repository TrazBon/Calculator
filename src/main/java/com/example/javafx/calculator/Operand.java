package com.example.javafx.calculator;

/**
 * Created by sdv on 11.12.2016.
 */
public class Operand {
    private long operand;
    private char operation;

    public Operand(long operand, char operation) {
        this.operand = operand;
        this.operation = operation;
    }

    public long getOperand() {
        return operand;
    }

    public char getOperation() {
        return operation;
    }
}
