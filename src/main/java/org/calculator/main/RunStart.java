package org.calculator.main;

import org.calculator.constant.SystemConstant;
import org.calculator.core.Calculator;
import org.calculator.core.Token;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

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
        for(int i=0;i<tokens.length;i++){
            Token token=tokens[i];
            Boolean iscorrect=calculator.calculator(token);
            if(!iscorrect){
                sb.append(String.format("operator %s (position: %d): insufficient parameters",token.getExpression(),token.getPositition()));
                sb.append("\n");
                break;
            }
        }
        Stack<BigDecimal> stack=calculator.getStack();
        sb.append(printStack(stack));
        return sb.toString();
    }

    private String printStack(Stack<BigDecimal> stack){
        List<String> printlist=new ArrayList<>();
        for(int i=0;i<stack.size();i++){
            BigDecimal printnumber=stack.elementAt(i);
            if(printnumber.scale()>= SystemConstant.storedScale){
                printnumber=printnumber.setScale(SystemConstant.displayScale, RoundingMode.DOWN);
            }
            printlist.add(printnumber.stripTrailingZeros().toPlainString());
        }
        return "stack:"+String.join(" ",printlist);
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
