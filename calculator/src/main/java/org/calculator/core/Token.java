package org.calculator.core;

public class Token {
    private int positition;
    private String expression;

    public int getPositition() {
        return positition;
    }

    public void setPositition(int positition) {
        this.positition = positition;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
