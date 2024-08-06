package org.example.selenide.tests;

import org.example.selenide.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FileUploadTest extends BaseTest{

    @Test
    public void uploadTestClassic(){
        homePage.getTestDirectory(HomePage.Links.FILE_UPLOAD);
        fileUploadPage.uploadByClassic();
        System.out.println("test");
    }

    @Test
    public void uploadSelenideTest(){
        List<String> expected = List.of( "upload.txt");
        homePage.getTestDirectory(HomePage.Links.FILE_UPLOAD);
        fileUploadPage.uploadSelenide();
        Assert.assertTrue(fileUploadPage.isFieldUploaded(expected));
    }

}
