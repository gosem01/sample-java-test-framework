package utils;

import io.qameta.allure.Attachment;
import org.apache.tika.io.IOUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.Random;

import static utils.LocalDriverManager.getDriver;

public class Utils {
    public static String BROWSER;
    public final static String DEFAULT_BROWSER = "iPhoneChromeEmulator";
    public static boolean DO_NOT_CREATE_SCREENSHOTS;
    public static boolean HEADLESS;

    static {

        BROWSER = System.getProperty("iPhoneChromeEmulator");
        if (BROWSER == null) {
            BROWSER = DEFAULT_BROWSER;
        }

        DO_NOT_CREATE_SCREENSHOTS = Boolean.parseBoolean(System.getProperty("doNotCreateScreenshots"));
        HEADLESS = Boolean.parseBoolean(System.getProperty("headless"));

        System.out.println("\nBuild information: ");
        System.out.println("Browser: " + BROWSER);
        System.out.println("Do Not Create Screenshots: " + DO_NOT_CREATE_SCREENSHOTS);
    }

    public static void takeScreenshot() {
        if (!DO_NOT_CREATE_SCREENSHOTS) {

            int driverHashCode = getDriver().hashCode();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            if (getDriver() instanceof TakesScreenshot) {
                TakesScreenshot screenshotTakingDriver = (TakesScreenshot) getDriver();

                try {
                    File localScreenshots = new File(new File("target"), "screenshots-" + driverHashCode);
                    if (!localScreenshots.exists() || !localScreenshots.isDirectory()) {
                        localScreenshots.mkdirs();
                    }

                    byte[] fileContent = Files.readAllBytes(screenshotTakingDriver.getScreenshotAs(OutputType.FILE).toPath());

                    saveScreenshot(fileContent);
                } catch (Exception e1) {
                    System.out.println("Unable to take screenshot " + e1);

                }
            } else {
                System.out.printf("Driver '%s' can't take screenshots so skipping it.", getDriver().getClass());
            }
        }
    }

    public static void createEnvironmentFile(String browser, String browserVersion, String osPlatform) {
        String filePath = "target/allure-results/";
        String fileName = "environment.properties";

        FileOutputStream fileOutputStream = null;
        Properties props = new Properties();
        File file = new File(filePath);

        try {
            file.mkdir();
            file = new File(filePath + fileName);
            boolean fileCreated = file.createNewFile();

            System.out.println("Environment file " + fileName + " created: " + fileCreated);

            fileOutputStream = new FileOutputStream(file);

            props.setProperty("Browser", browser);
            props.setProperty("Browser version", browserVersion);
            props.setProperty("Platform", osPlatform);

            props.setProperty("DO_NOT_CREATE_SCREENSHOTS", String.valueOf(DO_NOT_CREATE_SCREENSHOTS));
            props.setProperty("HEADLESS", String.valueOf(HEADLESS));


            props.store(fileOutputStream, null);
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println("IO problem when writing allure properties file: " + e);
        } finally {
            IOUtils.closeQuietly(fileOutputStream);
        }

        System.out.println("Environment file " + fileName + " updated with build data.");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Attachment(value = "Browser logs", type = "text/html")
    public static String saveLogs(String log) {
        return log;
    }

    public static void takeLogs() {
        if (Utils.returnBrowser().equals("iPhoneChromeEmulator")) {

            int index = 0;
            String logs = "";

            LogEntries logEntries = getDriver().manage().logs().get(LogType.BROWSER);

            for (LogEntry entry : logEntries) {
                index++;
                System.out.println("LOG: " + entry.getMessage());
                logs = new StringBuilder().append(logs).append("\n" + index + " - " + entry.getMessage()).toString();
            }

            saveLogs(String.format("%s", logs));
        }
    }

    public static int getRandomNum() {
        int num = new Random().nextInt(100000000);
        System.out.println("Generated random number: " + num);
        return num;
    }

    static String returnBrowser() {
        Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();
        return cap.getBrowserName().toLowerCase();
    }

    static String returnBrowserVer() {
        Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();
        return cap.getVersion().toLowerCase();
    }

    static String returnPlatform() {
        Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();
        return String.valueOf(cap.getPlatform());
    }
}
