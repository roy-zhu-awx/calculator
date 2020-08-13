package org.calculator.main;

import org.calculator.core.Calculator;

import java.util.Scanner;

public class RunStart {
    private Calculator calculator;

    public RunStart() {
        calculator = new Calculator();
    }

    public String getResult(String expression) {
        return calculator.calculatorResult(expression);
    }

    public static void main(String[] args) {
        RunStart start = new RunStart();
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String line = input.nextLine();
            start.getResult(line);
        }
    }
}
