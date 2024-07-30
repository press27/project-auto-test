package org.example.selenium.tests;

import org.example.selenium.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class AlertTest extends BaseTest{

    @Test
    public void testAlert() {
        homePage.getTestDirectory(HomePage.Links.ALERTS);
        alertsPage.clickAlertButton();
        driver.switchTo().alert().accept();

        alertsPage.clickAlertConfirm();
        int day = LocalDate.now().getDayOfWeek().getValue();
        if(day == 5){
            driver.switchTo().alert().accept();
        } else {
            driver.switchTo().alert().dismiss();
            driver.switchTo().alert().accept();
        }

        alertsPage.clickAlertPrompt();

        driver.switchTo().alert().sendKeys("test-test");
        String expectedText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        String actualText = "";
        driver.switchTo().alert().accept();

        //Assert.assertEquals("","");
        System.out.println("Test");
    }


}
