package com.myfin.tests.base;

import com.myfin.steps.FinSteps;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    public FinSteps finSteps;
    
    @BeforeMethod(description = "Opening browser")
    public void startBrowser() {
        finSteps = new FinSteps();
    }

    @AfterMethod(description = "Closing browser", alwaysRun = true)
    public void stopBrowser() {
        log.info("Closing browser after method");
        finSteps.closeBrowser();
    }
}