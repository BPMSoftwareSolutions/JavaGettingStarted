package com.company;

public class Divider extends CalculateBase implements MathProcessing {
    public Divider() {

    }

    public Divider (double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        setResult((getRightVal() != 0) ? getLeftVal() / getRightVal() : 0.0d);
    }

    @Override
    public String getKeyword() {
        return MainOperation.DIVIDE.name();
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        calculate(leftVal, rightVal);
        return getResult();
    }
}
