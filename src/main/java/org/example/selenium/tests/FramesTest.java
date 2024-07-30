package org.example.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

public class FramesTest extends BaseTest{

//    @Test
//    public void frameTest(){
//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.get(getFromProperties("framesUrl"));
//        Set<String> windowHandles = driver.getWindowHandles();
//        //String uiVisionHandle = driver.getWindowHandle();
//        //driver.switchTo().window(uiVisionHandle);
//        driver.switchTo().window(windowHandles.toArray()[0].toString());
//        driver.switchTo().window(windowHandles.toArray()[1].toString());
//        System.out.println("Test");
//    }

    @Test
    public void frameTest(){
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(getFromProperties("framesUrl"));
        Set<String> windowHandles = driver.getWindowHandles();
        //String uiVisionHandle = driver.getWindowHandle();
        //driver.switchTo().window(uiVisionHandle);
        driver.switchTo().window(windowHandles.toArray()[0].toString());
        driver.switchTo().window(windowHandles.toArray()[1].toString());

        driver.switchTo().frame(0).findElement(framesPage.frame1Input).sendKeys("Это фрейм 1");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1).findElement(framesPage.frame2Input).sendKeys("Это фрейм 2");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_3.html']"))).findElement(framesPage.frame3Input).sendKeys("Это фрейм 3");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(3).findElement(framesPage.frame4Input).sendKeys("Это фрейм 4");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(4).findElement(framesPage.frame5Input).sendKeys("Это фрейм 5");

        System.out.println("Test");
    }

}
