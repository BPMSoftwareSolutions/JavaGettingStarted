package com.company;

public class Adder extends CalculateBase implements MathProcessing {
    public Adder() {

    }
    public Adder(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    public void calculate() {
        setResult(getLeftVal() + getRightVal());
    }

    @Override
    public String getKeyword() {
        return MainOperation.ADD.name();
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        calculate(leftVal, rightVal);
        return getResult();
    }
}
