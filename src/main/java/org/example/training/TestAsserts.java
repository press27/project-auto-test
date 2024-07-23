package org.example.training;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAsserts {

    @Test
    public void testOne() {
        int a = 5;
        int b = 5;

        int result = a+b;

        Assert.assertEquals(result, 10);
    }

    @Test
    public void testTwo() {
        int a = 5;
        int b = 5;

        int result = a+b;

        Assert.assertEquals(result, 4, "Текст проверки");
    }

    @Test
    public void testThree() {
        int a = 5;
        int b = 5;

        int result = a+b;

        Assert.assertTrue(a==b);
    }

    @Test
    public void testFour() {
        int a = 1;
        int b = 5;

        int result = a+b;

        Assert.assertFalse(a==b);
    }

}
