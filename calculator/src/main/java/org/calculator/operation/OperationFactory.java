package org.calculator.operation;

import org.calculator.step.StepKeeper;

public class OperationFactory {
    public static Operation createOperation(String expression, StepKeeper stepKeeper){
        switch (expression){
            case "+":
                return new AdditionMathOperator(stepKeeper,expression);
            case "-":
                return new SubtractionMathOperator(stepKeeper,expression);
            case "*":
                return new MultiplicationMathOperator(stepKeeper,expression);
            case "/":
                return new DivisionMathOperator(stepKeeper,expression);
            case "sqrt":
                return new SqrtMathOperator(stepKeeper,expression);
            case "clear":
                return new ClearMathOperator(stepKeeper,expression);
            case "undo":
                return new UndoMathOperator(stepKeeper,expression);
            default:
                return new NumberOperation(stepKeeper,expression);
        }
    }
}
