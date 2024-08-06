package org.example.selenide.tests;

import org.example.selenide.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicTableTest extends BaseTest{

    @Test
    public void testDynamicTable() {
        homePage.getTestDirectory(HomePage.Links.DYNAMIC_TABLE);

        String expectedValue = dynamicTablePage.getExpectedValue();
        String actualValue = dynamicTablePage.getTableValue();

        Assert.assertEquals(actualValue,expectedValue);
    }

}
