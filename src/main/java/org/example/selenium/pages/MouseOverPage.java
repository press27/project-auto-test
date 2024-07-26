package org.example.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOverPage extends BasePage{

    private final Actions actions = new Actions(driver);
    private final By clickCount = By.xpath("//div//p//span[@id='clickCount']");
    private final By linkClick = By.xpath("//div//a[text()='Click me']");

    public MouseOverPage(WebDriver driver) {
        super(driver);
    }

    public String getClickCount(){
        return driver.findElement(clickCount).getText();
    }

    public void doubleClick(int countDoubleClick){
        for (int i = 0; i < countDoubleClick; i++) {
            actions.moveToElement(driver.findElement(linkClick)).doubleClick().build().perform();
        }
    }

}
