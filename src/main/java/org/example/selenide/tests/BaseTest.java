package org.example.selenide.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.example.listener.TestListener;
import org.example.selenide.pages.*;
import org.openqa.selenium.OutputType;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


@Listeners(TestListener.class)
public abstract class BaseTest {

    protected HomePage homePage = new HomePage();
    protected TextInputPage textInputPage = new TextInputPage();
    protected DynamicTablePage dynamicTablePage = new DynamicTablePage();
    protected MouseOverPage mouseOverPage = new MouseOverPage();
    protected FramesPage framesPage = new FramesPage();
    protected AlertsPage alertsPage = new AlertsPage();
    protected FileUploadPage fileUploadPage = new FileUploadPage();
    protected ClassAttributePage classAttributePage = new ClassAttributePage();

    public static void takeScreenshot(){
        byte[] bytes = Selenide.screenshot(OutputType.BYTES);
        if(bytes != null){
            Allure.addAttachment("Screen 1", "img/png", new ByteArrayInputStream(bytes), ".img");
        } else {
            System.out.println("Не удалось сделать screenshot");
        }
    }

    @BeforeSuite
    public void init(){
        System.out.println("setUp");
        setUp();
    }

    @BeforeTest
    public void openHomePage(){
        System.out.println("Opening home page");
        Selenide.open(getFromProperties("homeUrl"));
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    private void setUp(){
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.screenshots = true;
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
