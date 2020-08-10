package org.calculator.newstep;

import java.util.Stack;

public class StepKeeper {
    private Stack<Step> steps = new Stack<>();

    public Step getStep() {
        return steps.pop();
    }

    public void addStep(Step step) {
        steps.add(step);
    }

    public void clearAllSteps() {
        steps.clear();
    }
    public int stepStackSize(){
        return steps.size();
    }
}
