package org.calculator.main;

import org.calculator.controller.Controller;
import org.calculator.core.Calculator;
import org.calculator.core.Token;
import org.calculator.operation.Operation;

import java.math.BigDecimal;
import java.util.Scanner;

public class RunStart {
    private Calculator calculator;

    public RunStart() {
        calculator=new Calculator();
    }

    private Token[] getTokens(String line){
        int positition = 0;
        String[] words=line.split(" ");
        Token[] tokens=new Token[words.length];
        for(int i=0;i<words.length;i++){
            String word=words[i];
            positition=positition+word.length()+(i==0?0:1);
            Token token=new Token();
            token.setExpression(word);
            token.setPositition(positition);
            tokens[i]=token;
        }
        return tokens;
    }

    public String getResult(String line){
        StringBuilder sb=new StringBuilder();
        Token[] tokens=getTokens(line);
        for (Token token : tokens) {
            if(token.getExpression().matches("\\d+")){
                calculator.inputNumber(new BigDecimal(token.getExpression()));
            }else{
                Operation operation = ActionFactory.createOperation(token.getExpression());
                if (null == operation) {
                    Controller controller = ActionFactory.createController(token.getExpression());
                    if (null == controller) {
                        System.err.println("unsupported expression");
                    } else {
                        calculator.Control(controller);
                    }
                } else {
                    Boolean iscorrect = calculator.Operate(operation);
                    if (!iscorrect) {
                        sb.append(String.format("operator %s (position: %d): insufficient parameters", token.getExpression(), token.getPositition()));
                        sb.append("\n");
                        break;
                    }
                }
            }


        }
        sb.append(calculator.printStack());
        return sb.toString();
    }

    public static void main(String[] args) {
        RunStart start=new RunStart();
        Scanner input=new Scanner(System.in);
        while (input.hasNext()){
            String line=input.nextLine();
            start.getResult(line);

        }
    }
}
