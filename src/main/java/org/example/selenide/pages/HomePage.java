package org.example.selenide.pages;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    String linkPattern = "//h3//a[text()='%s']";

    public void getTestDirectory(Links targetLinks){
        $x(String.format(linkPattern, targetLinks.linkValue)).click();
    }

    public enum Links{
        TEXT_INPUT("Text Input"),
        CLICK("Click"),
        DYNAMIC_TABLE("Dynamic Table"),
        MOUSE_OVER("Mouse Over"),
        ALERTS("Alerts");


        final String linkValue;

        Links(String linkValue) {
            this.linkValue = linkValue;
        }
    }

}
