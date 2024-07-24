package org.example.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {

    protected static WebDriver driver;

    public static WebDriver setUp(){
        if(driver == null) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(getFromProperties("homeUrl"));
        }
        return driver;
    }

    @AfterClass
    public void tearDawn(){
        driver.quit();
    }

    public static String getFromProperties(String propertyKey){
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
