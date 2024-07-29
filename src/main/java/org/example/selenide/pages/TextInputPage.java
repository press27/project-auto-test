package org.example.selenide.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TextInputPage {

    private final SelenideElement inputText = $x("//input[@id='newButtonName']");
    private final SelenideElement button = $x("//button[@id='updatingButton']");


    public String setText(String textToType){
        inputText.sendKeys(textToType);
        button.click();
        return textToType;
    }

    public String getTextFromButton(){
        return button.getText();
    }

}
