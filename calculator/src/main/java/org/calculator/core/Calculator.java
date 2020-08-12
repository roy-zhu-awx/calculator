package org.calculator.core;

import org.calculator.constant.SystemConstant;
import org.calculator.controller.Controller;
import org.calculator.operation.Operation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {
    private Stack<BigDecimal> stack;
    private Stack<Stack<BigDecimal>> historySteps;

    public Calculator(){
        stack=new Stack<>();
        historySteps =new Stack<>();
    }

    public Boolean Operate(Operation operation){
        if(!checkValidate(operation)){
            return false;
        }else {
            Stack<BigDecimal> numbers=new Stack<>();
            for(int i=0;i<operation.getNumberNum();i++){
                numbers.push(stack.pop());
            }
            historySteps.push((Stack<BigDecimal>) numbers.clone());
            BigDecimal result=operation.operate(numbers);
            stack.push(result);
            return true;
        }
    }

    public void Control(Controller controller){
        controller.doControl(historySteps,stack);
    }

    public void inputNumber(BigDecimal number){
        stack.push(number);
        Stack<BigDecimal> numbers=new Stack<>();
        historySteps.push(numbers);
    }

    private Boolean checkValidate(Operation operation){
        int numbernum=operation.getNumberNum();
        return stack.size() >= numbernum;
    }

    public String printStack(){
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
}
