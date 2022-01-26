package com.company;

public class Multiplier extends CalculateBase implements MathProcessing {
    public Multiplier() {

    }

    public Multiplier (double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    public void calculate() {
        setResult(getLeftVal() * getRightVal());
    }

    @Override
    public String getKeyword() {
        return MainOperation.MULTIPLY.name();
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        calculate(leftVal, rightVal);
        return getResult();
    }
}
