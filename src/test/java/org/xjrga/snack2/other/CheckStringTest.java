package org.xjrga.snack2.other;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckStringTest {
    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
    }

    @Test
    public void testNames() {
        //Alphanumeric, space, period, comma or hyphen characters only
        CheckString checkString = new CheckString();
        checkString.addName("az .,'%()/-&_");
        Assert.assertTrue(checkString.pass());
    }

    @Test
    public void testNumbers() {
        //Numbers only
        CheckNumber checkString = new CheckNumber();
        checkString.addNumber("100");
        checkString.addNumber("100.");
        checkString.addNumber("100.0");
        checkString.addNumber(".0");
        Assert.assertTrue(checkString.pass());
    }
}