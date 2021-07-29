package myjdbc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JUnitTest {


    @Before
    public void m0(){
        System.out.println("m0");
    }
    @After
    public void m3(){
        System.out.println("m3");
    }

    @Test
    public void m1(){
        System.out.println("dddddddddddd");
        Assert.assertEquals(6, Calc.Add(5,1));
        Assert.assertEquals(3, Calc.Div(6,2));
    }
}
