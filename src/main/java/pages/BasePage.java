package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.LocalDriverManager.getDriver;

public class BasePage {
    public String baseURL = "https://www.macys.com";
    public int timeout = 10;

    public boolean isElementPresent(By selector) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
            wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(selector)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}