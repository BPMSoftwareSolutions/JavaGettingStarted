package com.company;

public class Subtracter extends CalculateBase implements MathProcessing {
    public Subtracter() {

    }

    public Subtracter (double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    public void calculate() {
        setResult(getLeftVal() - getRightVal());
    }

    @Override
    public String getKeyword() {
        return MainOperation.SUBTRACT.name();
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        calculate(leftVal, rightVal);
        return getResult();
    }
}
