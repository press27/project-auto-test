package org.example.selenide.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseTest {

    private void setUp(){
        if(!Configuration.webdriverLogsEnabled){
            WebDriverManager.chromedriver().setup();
            Configuration.browser = "chrome";
            Configuration.webdriverLogsEnabled = true;
            Configuration.browserSize = "1920x1080";
            Configuration.headless = false;
        }
    }

    @BeforeSuite
    public void init(){
        System.out.println("setUp");
        setUp();
    }

    @AfterSuite
    public void tearDown(){
        System.out.println("tearDown");
        Selenide.closeWebDriver();
    }

    @BeforeClass
    public void openHomePage(){
        System.out.println("Opening home page");
        Selenide.open(getFromProperties("homeUrl"));
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
