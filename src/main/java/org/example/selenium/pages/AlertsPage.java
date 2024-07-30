package org.example.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends BasePage{


    private final By alertButton = By.xpath("//button[@id='alertButton']");
    private final By alertConfirm = By.xpath("//button[@id='confirmButton']");
    private final By alertPrompt = By.xpath("//button[@id='promptButton']");

    public void clickAlertButton() {
        driver.findElement(alertButton).click();
    }

    public void clickAlertConfirm() {
        driver.findElement(alertConfirm).click();
    }

    public void clickAlertPrompt() {
        driver.findElement(alertPrompt).click();
    }

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

}
