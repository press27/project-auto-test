package org.example.listener;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.*;

import static org.example.selenide.tests.BaseTest.takeScreenshot;

public class TestListener implements ITestListener, IInvokedMethodListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failure");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        if(method.isConfigurationMethod() || method.isTestMethod()){
            int status = testResult.getStatus();
            if(status != 1 && status != 3 && WebDriverRunner.hasWebDriverStarted()){
                try {
                    takeScreenshot();
                } catch (Exception ex){
                    ex.printStackTrace();
                    System.out.println("Не удалось сделать screenshot");
                }
            }
        }
    }
}
