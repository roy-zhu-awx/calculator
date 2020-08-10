import org.calculator.core.Calculator;
import org.calculator.main.RunStart;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MixOperatorTestExmple6 {
    private static RunStart runStart;
    String expect;
    String expression;
    @Parameterized.Parameters
    public static Collection<Object[]> initParameters(){
        return Arrays.asList(new Object[][]{
                {"stack:1 2 3 4 5","1 2 3 4 5"},
                {"stack:1 2 3 20","*"},
                {"stack:-1","clear 3 4 -"}
        });
    }

    public MixOperatorTestExmple6(String expect, String expression) {
        this.expect = expect;
        this.expression = expression;
    }
    @BeforeClass
    public static void createCalculator(){
        runStart=new RunStart();
    }

    @Test
    public void testSingleOperator(){
        Assert.assertEquals(expect,runStart.getResult(expression));
    }




}
