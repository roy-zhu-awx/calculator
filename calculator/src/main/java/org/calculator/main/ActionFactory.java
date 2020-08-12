package org.calculator.main;


import org.calculator.controller.ClearController;
import org.calculator.controller.Controller;
import org.calculator.controller.UndoController;
import org.calculator.operation.*;

public class ActionFactory {
    public static Operation createOperation(String expression){
        switch (expression){
            case "+":
                return new AdditionMathOperator();
            case "-":
                return new SubtractionMathOperator();
            case "*":
                return new MultiplicationMathOperator();
            case "/":
                return new DivisionMathOperator();
            case "sqrt":
                return new SqrtMathOperator();
            default:
                return null;
        }
    }

    public static Controller createController(String expression){
        switch (expression){
            case "clear":
                return new ClearController();
            case "undo":
                return new UndoController();
            default:
                return null;
        }
    }
}
