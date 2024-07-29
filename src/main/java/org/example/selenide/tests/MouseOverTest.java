package org.example.selenide.tests;

import org.example.selenide.pages.HomePage;
import org.example.selenide.pages.MouseOverPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseOverTest extends BaseTest{

    HomePage homePage = new HomePage();
    MouseOverPage mouseOverPage = new MouseOverPage();

    @Test
    public void testMouseOver() {
        homePage.getTestDirectory(HomePage.Links.MOUSE_OVER);

        int clickCount = 6;
        int expectedClickCount = clickCount * 2;

        mouseOverPage.doubleClick(clickCount);
        String actual = mouseOverPage.getClickCount();
        Assert.assertEquals(actual, Integer.toString(expectedClickCount));
    }

}
