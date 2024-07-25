package org.example.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DynamicTablePage extends BasePage{

    private By expectedValue = By.xpath("//p[@class='bg-warning']");
    private By columnHeaders = By.xpath("//span[@role='columnheader']");
    private By chromeRow = By.xpath("//div//span[text()='Chrome']/following-sibling::span");

    public DynamicTablePage(WebDriver driver) {
        super(driver);
    }

    public String getExpectedValue() {
        String value = driver.findElement(expectedValue).getText();
        return value.substring(12);
    }

    public int getCpuIndex() {
        List<WebElement> headers = driver.findElements(columnHeaders);
        for (int i = 0; i < headers.size(); i++) {
            if(headers.get(i).getText().equals("CPU")){
                return i;
            }
        }
        return 0;
    }

    public String getTableValue(){
        List<WebElement> rows = driver.findElements(chromeRow);
        return rows.get(getCpuIndex() - 1).getText();
    }

}
