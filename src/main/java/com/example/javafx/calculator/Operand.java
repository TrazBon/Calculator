package com.example.javafx.calculator;

/**
 * Created by sdv on 11.12.2016.
 */
public class Operand {
    private float operand;
    private char operation;

    public Operand(float operand, char operation) {
        this.operand = operand;
        this.operation = operation;
    }

    public float getOperand() {
        return operand;
    }

    public char getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return operation + " " + operand + " ";
    }
}
