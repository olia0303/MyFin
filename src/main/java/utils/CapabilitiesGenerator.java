package utils;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

@Log4j2
public class CapabilitiesGenerator {

    public static ChromeOptions getChromeOptions() {
        String driverPath = System.getProperty("user.dir") + File.separator + new PropertyManager().get("drivers.path");
        ChromeOptions options = new ChromeOptions();
        String os = System.getProperty("os.name").toLowerCase();
        log.debug("Operational system: " + os + "; Driver path: " + driverPath);
        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", driverPath + "/linux/chromedriver");
        }
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        return options;
    }
}

