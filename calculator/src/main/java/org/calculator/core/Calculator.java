package org.calculator.core;

import org.calculator.constant.SystemConstant;
import org.calculator.executor.Executor;
import org.calculator.operator.Operator;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Calculator {
    private Stack<BigDecimal> stack;
    private Stack<Stack<BigDecimal>> historySteps;
    private static Map<String,Operator> operatorMap=new HashMap<>();
    private static Map<String,Executor> executorMap=new HashMap<>();

    static {
        Properties properties=new Properties();
        try {
            properties.load(Calculator.class.getClassLoader().getResourceAsStream("expressionmapping.properties"));
            for(String key:properties.stringPropertyNames()){
                String[] keysplits=key.split("\\.");
                if(keysplits[0].equals("executor")){
                    String classname=properties.getProperty(key);
                    try {
                        Executor executor= (Executor) Class.forName(classname).newInstance();
                        executorMap.put(keysplits[1],executor);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }

                }else if(keysplits[0].equals("operator")){
                    String classname=properties.getProperty(key);
                    try {
                        Operator operator= (Operator) Class.forName(classname).newInstance();
                        operatorMap.put(keysplits[1],operator);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Calculator(){
        stack=new Stack<>();
        historySteps =new Stack<>();
    }

    public String calculatorResult(String expression){
        StringBuilder sb=new StringBuilder();
        Token[] tokens=getTokens(expression);
        for (Token token : tokens) {
            if (operatorMap.containsKey(token.getName())) {
                Operator operator = operatorMap.get(token.getName());
                Boolean incomplete = Operate(operator);
                if (!incomplete) {
                    sb.append(String.format("operator %s (position: %d): insufficient parameters", token.getName(), token.getPositition()));
                    sb.append("\n");
                    break;
                }
            } else if (executorMap.containsKey(token.getName())) {
                Executor executor=executorMap.get(token.getName());
                Execute(executor);
            } else if(token.getName().matches("\\d+")){
                inputNumber(new BigDecimal(token.getName()));
            } else {
                System.err.println(String.format("unknown token %s in expression",token.getName()));
                break;
            }
        }
        sb.append(printStack());
        return sb.toString();
    }

    private Boolean Operate(Operator operator){
        if(!checkOperatorValidate(operator)){
            return false;
        }else {
            Stack<BigDecimal> numbers=new Stack<>();
            for(int i = 0; i< operator.getNumberNum(); i++){
                numbers.push(stack.pop());
            }
            historySteps.push((Stack<BigDecimal>) numbers.clone());
            BigDecimal result= operator.operate(numbers);
            stack.push(result);
            return true;
        }
    }

    private void Execute(Executor executor){
        executor.execute(historySteps,stack);
    }

    private void inputNumber(BigDecimal number){
        stack.push(number);
        Stack<BigDecimal> numbers=new Stack<>();
        historySteps.push(numbers);
    }

    private Boolean checkOperatorValidate(Operator operator){
        int numbernum= operator.getNumberNum();
        return stack.size() >= numbernum;
    }

    private String printStack(){
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

    private Token[] getTokens(String expression){
        int positition = 0;
        String[] words=expression.split(" ");
        Token[] tokens=new Token[words.length];
        for(int i=0;i<words.length;i++){
            String word=words[i];
            positition=positition+word.length()+(i==0?0:1);
            Token token=new Token();
            token.setName(word);
            token.setPositition(positition);
            tokens[i]=token;
        }
        return tokens;
    }
}
