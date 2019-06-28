package com.ttpsc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CalculatorTest {

    int a;
    int b;
    int expectedResult;

    public CalculatorTest(int a, int b){
        this.a = a;
        this.b = b;
        expectedResult = a + b;
    }

    @Parameterized.Parameters
    public static Object[][] prepareValues(){
        return new Object[][]{
                {1,2},
                {3,4},
                {8,10},
                {-8,24}
        };
    }

    @Test
    public void shouldReturnSumWhenAdding(){
        Calculator sut = new Calculator();
        int sum = sut.add(a,b);
        Assert.assertEquals(expectedResult,sum);

    }

    @Test
    public void shouldReturnNegativeIfFirstParameterSmallerThanSecond(){
        Calculator sut = new Calculator();
        int actual = sut.minus(a,b);
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void shouldReturnZeroWhenEqualParameters(){
        Calculator sut = new Calculator();
        int actual = sut.minus(8,8);
        Assert.assertTrue(actual == 0);
    }

    @Test
    public void shouldReturnZeroWhenMultiplyByZero(){
        Calculator sut = new Calculator();
        double result = sut.multiply(5,0);
        Assert.assertTrue(result == 0);
    }

    @Test
    public void shouldReturnProductWhenMultiplying(){
        Calculator sut = new Calculator();
        double result = sut.multiply(5,5);
        Assert.assertTrue(result == 25);
    }

    @Test
    public void shouldReturnPositiveWhenMultiplyingTwoNegatives(){
        Calculator sut = new Calculator();
        double result = sut.multiply(-5, -5);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void shouldReturnNegativeWhenMultiplyingOneNegatives() {
        Calculator sut = new Calculator();
        double result = sut.multiply(5, -5);
        Assert.assertTrue(result < 0);
    }


    @Test(expected = ArithmeticException.class)
    public void shouldThrowExceptionWhenDividingByZero() {
        Calculator sut = new Calculator();
        sut.divide(10,0);
    }

}
