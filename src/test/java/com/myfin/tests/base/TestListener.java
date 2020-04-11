package com.myfin.tests.base;

import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.PropertyManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info(String.format("======================================== STARTING TEST %s ========================================", iTestResult.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info(String.format("======================================== FINISHED TEST %s Duration: %ss ========================================", iTestResult.getName(),
                getExecutionTime(iTestResult)));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.error(String.format("======================================== FAILED TEST %s Duration: %ss ========================================", iTestResult.getName(),
                getExecutionTime(iTestResult)));
        takeScreenshot(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.warn(String.format("======================================== SKIPPING TEST %s ========================================", iTestResult.getName()));
        takeScreenshot(iTestResult);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    @Attachment(value = "Last screen state", type = "image/png")
    private byte[] takeScreenshot(ITestResult iTestResult) {
        try {
            try {
                log.debug("Taking screenshot using webdriver " + getWebDriver());
                File file = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);

                String path = System.getProperty("user.dir") + new PropertyManager().get("test.screenshot.path") + "/" + composeTestName(iTestResult) + ".png";
                log.debug(String.format("Saving screenshot of failure into: %s", path));
                FileUtils.copyFile(file,
                        new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (NoSuchSessionException ex) {
            return null;
        } catch (IllegalStateException ex) {
            return null;
        }
    }

    private String composeTestName(ITestResult iTestResult) {
        StringBuilder completeFileName = new StringBuilder();

        completeFileName.append(iTestResult.getTestClass().getRealClass().getSimpleName()); // simplified class name
        completeFileName.append("_");
        completeFileName.append(iTestResult.getName()); // method name

        // all the parameters information
        Object[] parameters = iTestResult.getParameters();
        for (Object parameter : parameters) {
            completeFileName.append("_");
            completeFileName.append(parameter);
        }

        // return the complete name and replace : by - (in the case the emulator have port as device name)
        return completeFileName.toString().replace(":", "-");
    }

    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }
}