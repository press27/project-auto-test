package org.example.selenium.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.selenium.pages.DynamicTablePage;
import org.example.selenium.pages.HomePage;
import org.example.selenium.pages.TextInputPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;

    protected HomePage homePage = new HomePage(setUp());
    protected TextInputPage textInputPage = new TextInputPage(setUp());
    protected DynamicTablePage dynamicTablePage = new DynamicTablePage(setUp());

    private WebDriver setUp() {
        WebDriverManager.chromedriver().setup();
        if (driver == null) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeClass
    public void startTest() {
        driver.get(getFromProperties("homeUrl"));
    }

    @AfterClass
    public void tearDawn() {
        driver.quit();
    }

    public String getFromProperties(String propertyKey) {
        try {
            Properties prop = new Properties();
            FileInputStream input = new FileInputStream("src/main/resources/application.properties");
            prop.load(input);
            return prop.getProperty(propertyKey);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertyKey;
    }


}
