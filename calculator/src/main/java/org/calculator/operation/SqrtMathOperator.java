package org.calculator.operation;

import org.calculator.step.StepKeeper;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SqrtMathOperator extends AbstractMathOperator {
    public SqrtMathOperator(StepKeeper stepKeeper, String expression) {
        super(stepKeeper, expression);
    }

    @Override
    public List<BigDecimal> getOperatorNumber(Stack<BigDecimal> stack) {
        List<BigDecimal> numbers=new ArrayList<>(1);
        numbers.add(stack.pop());
        return numbers;
    }

    @Override
    void _operate(List<BigDecimal> numbers, Stack<BigDecimal> stack) {
        stack.add(sqrt(numbers.get(0),15));
    }

    @Override
    public Boolean checkValidate(Stack<BigDecimal> stack){
        if (stack.size()>=1){
            return true;
        }
        return false;
    }
    public static BigDecimal sqrt(BigDecimal value, int scale){
        BigDecimal num2 = BigDecimal.valueOf(2);
        int precision = 100;
        MathContext mc = new MathContext(precision, RoundingMode.HALF_UP);
        BigDecimal deviation = value;
        int cnt = 0;
        while (cnt < precision) {
            deviation = (deviation.add(value.divide(deviation, mc))).divide(num2, mc);
            cnt++;
        }
        deviation = deviation.setScale(scale, BigDecimal.ROUND_HALF_UP);
        return deviation;
    }
}
