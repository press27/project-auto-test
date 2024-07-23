package org.example.training;

import org.testng.annotations.Test;

public class TestExample extends BaseTest{

    @Test
    public void testExample() {
        System.out.println("TEST EXAMPLE SECOND CLASS");
    }

    @Test(description = "test disable", enabled = false)
    public void testDisable() {
        System.out.println("Test disable");
    }

//    @Test(timeOut = 1)
//    public void testTimeout() {
//        System.out.println("Test timeout");
//    }
}
