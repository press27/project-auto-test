package org.example.training;

import org.testng.annotations.*;

public class TestExampleAnnotations extends BaseTest {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @Test
    public void testOne(){
        System.out.println("test One");
    }

    @Test
    public void testTwo(){
        System.out.println("test Two");
    }

}
