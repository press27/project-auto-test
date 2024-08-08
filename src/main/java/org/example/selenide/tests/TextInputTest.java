package org.example.selenide.tests;

import org.example.selenide.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextInputTest extends BaseTest {

    @Test(description = "Тестирование поля ввода")
    public void testTextInput(){
        homePage.getTestDirectory(HomePage.Links.TEXT_INPUT);
        String startButtonValue = textInputPage.getTextFromButton();

        String expectedText = textInputPage.setText("HelloWorld");
        String actualText = textInputPage.getTextFromButton();

        //Assert.assertEquals(actualText, expectedText);
        Assert.assertEquals(actualText, "FAIL");
        Assert.assertNotEquals(actualText, startButtonValue);
    }

}
