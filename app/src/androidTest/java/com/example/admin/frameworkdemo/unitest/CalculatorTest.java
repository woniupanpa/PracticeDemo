package com.example.admin.frameworkdemo.unitest;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yanjim
 * @Date 2021/5/6 19:06
 */
public class CalculatorTest {

    Calculator calculatorTest = new Calculator();
    int a;
    int b;

    @Before
    public void setUp() throws Exception {
        a = 10;
        b = 20;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void summation() {
        TestCase.assertEquals(30.0, calculatorTest.summation(a, b));
    }
}