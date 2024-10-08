package org.example.selenium.tests;

import org.example.selenium.pages.HomePage;
import org.example.selenium.pages.TextInputPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextInputTest extends BaseTest{

    @Test
    public void testTextInput(){
        homePage.getTestDirectory(HomePage.Links.TEXT_INPUT);
        String startButtonValue = textInputPage.getTextFromButton();

        String expectedText = textInputPage.setText("HelloWorld");
        String actualText = textInputPage.getTextFromButton();

        Assert.assertEquals(actualText, expectedText);
        Assert.assertNotEquals(actualText, startButtonValue);
    }
}
