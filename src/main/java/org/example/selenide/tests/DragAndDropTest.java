package org.example.selenide.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

public class DragAndDropTest extends BaseTest{

    @Test
    public void testDragAndDrop() {
        Selenide.switchTo().newWindow(WindowType.TAB);
        Selenide.open(getFromProperties("draganddrop"));

        SelenideElement a = $x("//div[@id='column-a']");
        SelenideElement b = $x("//div[@id='column-b']");

        SelenideElement aHeader = $x("//div[@id='column-a']/header");
        SelenideElement bHeader = $x("//div[@id='column-b']/header");

        //a.dragAndDrop(DragAndDropOptions.to(b));
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.clickAndHold(a).moveByOffset(100,0).release().build().perform();

        System.out.println("test");
    }

}
