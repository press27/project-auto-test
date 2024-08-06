package org.example.selenide.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class FileUploadPage {

    private final SelenideElement inputFile = $x("//input[@type='file']");
    private final ElementsCollection uploadedFiles = $$x("//div[@class='file-info']/p");

    /**
     * Метод через классический selenium (загружается в input)
     */
    public void uploadByClassic(){
        WebDriver driver = WebDriverRunner.getWebDriver();
        Selenide.switchTo().frame(0);
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\PetrykA\\IdeaProjects\\project-auto-test\\src\\main\\resources\\toUpload\\upload.txt");
        Selenide.switchTo().defaultContent();
    }

    /**
     * Проверить для себя загрузку нескольких файлов
     */
    public void uploadSelenide(){
        File file = new File("src/main/resources/toUpload/upload.txt");
        Selenide.switchTo().frame(0);
        inputFile.uploadFile(file);
        Selenide.switchTo().defaultContent();
    }

    public boolean isFieldUploaded(List<String> fileNames){
        Selenide.switchTo().frame(0);
        if(uploadedFiles.isEmpty()){
            Selenide.switchTo().defaultContent();
            return false;
        } else {
            List<String> actualFileNames = new ArrayList<>();
            uploadedFiles.forEach(file-> actualFileNames.add(file.getText()));
            Selenide.switchTo().defaultContent();
            return actualFileNames.containsAll(fileNames);
        }
    }

}
