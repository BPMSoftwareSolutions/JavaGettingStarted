package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import static com.company.MathEquation.*;

public class Main {

    public static void main(String[] args) {
//        dynamicInteractivity();
        iteratePassengers();
//        sortPassengers();
//        executeInteractively();
//        performMoreCalculations();
//        performCalculations();
    }

    private static void dynamicInteractivity() {
        System.out.println("Enter an operation and two numbers:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        MathProcessing[] handlers = {
                new Adder(),
                new Subtracter(),
                new Divider(),
                new Multiplier(),
                new PowerOf()
        };
        DynamicHelper helper = new DynamicHelper(handlers);
        helper.process(userInput);
    }

    private static void iteratePassengers() {
        Flight f175 = new Flight(175);

        f175.add1Passenger(new Passenger("Santiago", 1, 180));
        f175.add1Passenger(new Passenger("Julie", 1, 90));
        f175.add1Passenger(new Passenger("John", 3, 730));
        f175.add1Passenger(new Passenger("Geetha", 2, 150));

        for (Passenger passenger :
                f175.getOrderedPassengers()) {
            System.out.println("Passenger: " + passenger.getName());
        }
    }

    private static void sortPassengers() {
        Passenger[] passengers = {
                new Passenger("Luisa", 1, 180),
                new Passenger("Jack", 1, 90),
                new Passenger("Ashanti", 3, 730),
                new Passenger("Harish", 2, 150)
        };

        Arrays.sort(passengers);
        Passenger.RewordProgram platinum = new Passenger.RewordProgram(3);

        for (Passenger passenger :
                passengers) {
            if (passenger.getRewordProgram().getMemberLevel() == platinum.getMemberLevel()) {
                System.out.println("Platinum Member Passenger: " + passenger.getName());
            }
            else {
                System.out.println("Passenger: " + passenger.getName());
            }
        }
    }

    public static void executeInteractively() {
        System.out.println("Enter an operation and two numbers:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performCalculation(parts);
    }

    public static CalculateBase createCalculation(MainOperation operation, double leftVal, double rightVal) {
        CalculateBase calculation = null;

        switch (operation) {
            case ADD -> calculation = new Adder(leftVal, rightVal);
            case SUBTRACT -> calculation = new Subtracter(leftVal, rightVal);
            case MULTIPLY -> calculation = new Multiplier(leftVal, rightVal);
            case DIVIDE -> calculation = new Divider(leftVal, rightVal);
        }
        return calculation;
    }

    private static void performMoreCalculations() {
        CalculateBase[] calculations = {
                createCalculation(MainOperation.ADD,45.9, 23.5),
                new Divider(152885,52),
                new Multiplier(77.5, 80),
                new Subtracter(6123, 40)
        };

        for (CalculateBase calculation :
                calculations) {
            calculation.calculate();
            printCalculationResult(calculation);
        }
    }

    public static void performCalculation(String[] parts) {
        MainOperation operation = MainOperation.valueOf(parts[0].toUpperCase());
        double leftVal = Double.parseDouble(parts[1]);
        double rightVal = Double.parseDouble(parts[2]);
        CalculateBase calculation = createCalculation(operation, leftVal, rightVal);
        calculation.calculate();
        System.out.println("Operation performed: " + operation);
        printCalculationResult(calculation);
    }

    public static void printCalculationResult(CalculateBase calculation) {
        System.out.println(String.format("Result = %.2f", calculation.getResult()));
    }

    static void performReverseList() {
        Scanner scanner = new Scanner (System.in);
        String userInput = scanner.nextLine();

        if (userInput.length() > 0)
        {
            int[] numbers = Arrays.stream(userInput.split(",")).mapToInt(Integer::parseInt).toArray();
            reverseArray(numbers);
            outputArray(numbers);
            return;
        }

        // write your code here
        generateArrayListOutput();
        generateArrayOutput();
    }

    public static void performCalculations() {
        MathEquation[] mathEquations = new MathEquation[4];
        mathEquations[0] = create(3.54, 7.9, 'm');
        mathEquations[1] = create(27.5d, 30.0d, 'a');
        mathEquations[2] = create(859.22, 784.5, 's');
        mathEquations[3] = create(59.8, 30.0d, 'd');

        for (MathEquation equation :
                mathEquations) {
            equation.execute();
            System.out.println(String.format("result = %.2f", equation.getResult()));
        }

        MathEquation equation = new MathEquation('m');
        equation.execute(8.5d, 13.7d);
        System.out.println(String.format("result = %.2f", equation.getResult()));

        System.out.println(String.format("Average result = %.2f", getAverageResult()));
    }

    private static MathEquation create(double leftVal, double rightVal, char opCode) {
        MathEquation mathEquation = new MathEquation(opCode, leftVal, rightVal);
        return mathEquation;
    }

    public static void generateArrayOutput() {
        int[] list = {0,1,2,3,4};
        reverseArray(list);
        outputArray(list);
    }

    public static void generateArrayListOutput() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5,6,7,8,9));
        reverseList(list);
        outputArrayList(list);
    }

    public static void outputArray(int[] list) {
        for(int i=0; i<list.length; i++) {
            System.out.println("Item #" + (i+1) + " = " + list[i]);
        }
    }

    public static void outputArrayList(ArrayList<Integer> list) {
        for(int i=0; i<list.size(); i++) {
            System.out.println("Item #" + (i+1) + " = " + list.get(i));
        }
    }

    // This a reverse int array
    public static void reverseArray(int[] list) {
        int placeHolder;
        int count = list.length;

        for (int i = 0; i < count; i++) {
            if ((count - 1) - i < i) {
                break;
            }
            placeHolder = list[i];
            list[i] = list[(count - 1 - i)];
            list[(count - 1) - i] = placeHolder;

            if ((count - 1) - i == i) {
                break;
            }
        }
    }

    // This a reverse array list
    public static void reverseList(ArrayList<Integer> list) {
        int placeHolder;
        int count = list.size();

        for(int i=0; i < count; i++) {
            if ((count - 1) - i < i) {
                break;
            }
            placeHolder = list.get(i);
            list.set(i, list.get(count-1-i));
            list.set((count-1)-i, placeHolder);

            if ((count-1)-i <= i)
            {
                break;
            }
        }
    }
}
