//package org.example.selenium.tests;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class TestClass {
//
//    WebDriver driver;
//
//    @BeforeMethod
//    public void setUp(){
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }
//
//    @Test
//    public void openGoogle(){
//        driver.get("https://www.google.com");
//        System.out.println("Успешно");
//    }
//
//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }
//}
