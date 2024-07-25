package org.example.selenium.pages;

import com.google.common.collect.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    String linkPattern = "//h3//a[text()='%s']";

    public void getTestDirectory(Links targetLinks){
        driver.findElement(By.xpath(String.format(linkPattern, targetLinks.linkValue))).click();
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public enum Links{
        TEXT_INPUT("Text Input"),
        CLICK("Click"),
        DYNAMIC_TABLE("Dynamic Table");


        final String linkValue;

        Links(String linkValue) {
            this.linkValue = linkValue;
        }
    }
}
