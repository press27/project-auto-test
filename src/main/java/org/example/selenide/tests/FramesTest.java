package org.example.selenide.tests;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest{

    @Test
    public void frameTest(){
        Selenide.switchTo().newWindow(WindowType.TAB);
        Selenide.open(getFromProperties("framesUrl"));

        for (int i = 0; i <= 4; i++) {
            Selenide.switchTo().frame(i);
            framesPage.getFrameByIndex(i).sendKeys("Это фрейм " + (i + 1));
            Selenide.switchTo().defaultContent();
        }

        System.out.println("Test");
    }

}
