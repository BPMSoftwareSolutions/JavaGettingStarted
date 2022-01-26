package com.company;

public class PowerOf implements MathProcessing {
    String formattedOutput;

    @Override
    public String getKeyword() {
        return "power";
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        double product = Math.pow(leftVal, rightVal);
        formattedOutput = String.format("%s to the power of %s is %.2f", leftVal, rightVal, product);
        return  product;
    }

    @Override
    public String getFormattedOutput() {
        return formattedOutput;
    }
}
