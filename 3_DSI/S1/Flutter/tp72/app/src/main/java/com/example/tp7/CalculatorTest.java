package com.example.tp7;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.testng.annotations.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        double result = calculator.add(5, 3);
        assertEquals(8, result, 0.001);
    }

    @Test
    public void testSubtraction() {
        double result = calculator.sub(10, 4);
        assertEquals(6, result, 0.001);
    }

    @Test
    public void testDivision() {
        double result = calculator.div(15, 3);
        assertEquals(5, result, 0.001);
    }

    @Test
    public void testMultiplication() {
        double result = calculator.mul(4, 7);
        assertEquals(28, result, 0.001);
    }
}
