import org.calculator.core.Calculator;
import org.calculator.main.RunStart;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SingleOperatorTestExmple {
    private RunStart runStart;
    String expect;
    String expression;

    @Parameterized.Parameters
    public static Collection<Object[]> initParameters(){
        return Arrays.asList(new Object[][]{
                {"stack:5","3 2 +"},//+
                {"stack:1","10 9 -"},//-
                {"stack:6","3 2 *"},//*
                {"stack:6","12 2 /"},///
                {"stack:1.4142135623","2 sqrt"},//sqrt
                {"stack:3","3 2 undo"},//undo
                {"stack:","1 2 3 clear"}//clear
        });
    }

    public SingleOperatorTestExmple(String expect, String expression) {
        this.expect = expect;
        this.expression = expression;
    }

    @Before
    public void createCalculator(){
        runStart=new RunStart();
    }

    @Test
    public void testSingleOperator(){
        Assert.assertEquals(expect,runStart.getResult(expression));
    }

}
