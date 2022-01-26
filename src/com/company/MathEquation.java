package com.company;

public class MathEquation {
    private double leftVal;
    private double rightVal;
    private char opCode;
    private double result;

    private static int numberOfCalculations;
    private static double sumOfResults;

    public MathEquation(char opCode) {
        this.opCode = opCode;
    }

    public MathEquation(char opCode, double leftVal, double rightVal) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    void execute(double leftVal, double rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
    }

    void execute() {
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = (rightVal == 0) ? 0.0d : leftVal / rightVal;
                break;
            default:
                System.out.println("Invalid opCode: " + opCode);
                result = 0.0d;
                return;
        }
        numberOfCalculations++;
        sumOfResults += result;
    }

    public static double getAverageResult() {
        return (numberOfCalculations != 0) ? sumOfResults / numberOfCalculations : 0.0d;
    }

    public double getResult() {
        return this.result;
    }

    public static double getSumOfResults() {
        return sumOfResults;
    }

    public static int getNumberOfCalculations() {
        return numberOfCalculations;
    }

    public static void setNumberOfCalculations(int numberOfCalculations) {
        MathEquation.numberOfCalculations = numberOfCalculations;
    }

    public static void setSumOfResults(double sumOfResults) {
        MathEquation.sumOfResults = sumOfResults;
    }
}
