package org.example.selenium.tests;

import org.example.selenium.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseOverTest extends BaseTest{

    @Test
    public void testMouseOver(){
        homePage.getTestDirectory(HomePage.Links.MOUSE_OVER);

        int clickCount = 6;
        int expectedClickCount = clickCount * 2;

        mouseOverPage.doubleClick(clickCount);
        String actual = mouseOverPage.getClickCount();
        Assert.assertEquals(actual, Integer.toString(expectedClickCount));
    }

}
