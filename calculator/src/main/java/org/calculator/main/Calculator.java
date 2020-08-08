package org.calculator.main;

import org.calculator.operation.Operation;
import org.calculator.operation.OperationFactory;
import org.calculator.step.StepKeeper;
import org.calculator.step.StepStage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    private Stack<BigDecimal> stack;
    private StepKeeper stepKeeper;
    private StepStage stepStage;

    public Calculator(){
        stack=new Stack<>();
        stepKeeper =new StepKeeper();
        stepStage =new StepStage(stack);
    }

    public String calculator(String expression){
        int tokenlength=0;
        int positition;
        String[] tokens=expression.split(" ");
        for(int i=0;i<tokens.length;i++){
            String token=tokens[i];
            tokenlength=tokenlength+token.length();
            positition=tokenlength+i;
            Operation operation= OperationFactory.createOperation(token, stepKeeper);
            if(!operation.checkValidate(stack)){
                System.out.println(String.format("operator %s (position: %d): insufficient parameters",token,positition));
                break;
            }else {
                operation.operate(stepStage);
            }
        }
        return "stack:"+printStack(stack);
    }

    private String printStack(Stack<BigDecimal> stack){
        List<String> printlist=new ArrayList<>();
        for(int i=0;i<stack.size();i++){
            BigDecimal printnumber=stack.elementAt(i);
            if(printnumber.scale()>=15){
                printnumber=printnumber.setScale(10, RoundingMode.DOWN);
            }
            printlist.add(printnumber.stripTrailingZeros().toPlainString());
        }
        return String.join(" ",printlist);
    }
    public static void main(String[] args) {
        Calculator calculator=new Calculator();
        Scanner input=new Scanner(System.in);
        while (input.hasNext()){
            String line=input.nextLine();
            System.out.println(calculator.calculator(line));
        }
    }
}
