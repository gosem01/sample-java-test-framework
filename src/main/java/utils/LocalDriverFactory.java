package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static utils.Utils.BROWSER;

class LocalDriverFactory {
    static WebDriver createInstance() {
        WebDriver driver = null;

        if (BROWSER.equals("iPhoneChromeEmulator")) {
            driver = runiPhoneChromeEmulator();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return driver;

    }

    static WebDriver runiPhoneChromeEmulator() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "iPhone 6/7/8");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        return new ChromeDriver(chromeOptions);

        }
    }
