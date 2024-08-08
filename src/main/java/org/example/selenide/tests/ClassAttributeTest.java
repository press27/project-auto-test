package org.example.selenide.tests;

import org.example.selenide.pages.HomePage;
import org.testng.annotations.Test;

public class ClassAttributeTest extends BaseTest{

    @Test
    public void clickBlueButtonTest(){
        homePage.getTestDirectory(HomePage.Links.CLASS_ATTRIBUTE);
        classAttributePage.clickBlueButton(10);
    }

}
