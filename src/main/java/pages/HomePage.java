package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static utils.LocalDriverManager.getDriver;

public class HomePage extends BasePage {

    public String url = String.format(baseURL);
    public By pageHomeTitle = By.xpath("//title[text()='Home']");
    public By categoryButton = By.id("/shop/coupons-deals");
    public By menuButton = By.xpath("//button[@aria-label='Menu']");
    public By hamburgerMenu = By.xpath("//ul[@role='menu]");
    public By hamburgerMenuOpened = By.xpath("//li[@id='root' and @aria-hidden='false']");
    public By mainMenuCategory = By.xpath("//li/div[text()='Clothing']");
    public By continueButton = By.xpath("//button[text()='Continue']");
    public By password = By.xpath("//input[@id='password']");
    public By confirmPassword = By.xpath("//input[@id='confirm-password']");
    public By cancelButton = By.xpath("//button[text()='Cancel']");

    public void goToPage() {
        getDriver().get(url);
    }

    public void browserBack() {
        getDriver().navigate().back();
    }

    public String getPageHomeTitle() {
        return getDriver().findElement(this.pageHomeTitle).getText();
    }

    public boolean isPageOpened() {
        return isElementPresent(pageHomeTitle);
    }

    public boolean isMenuOpened() {
        return isElementPresent(hamburgerMenuOpened);
    }

//    public void loadingCategory() {
//        getDriver().get(category);
//    }

    public void clickingMenuButton() throws InterruptedException {
        getDriver().findElement(this.menuButton).click();
        Thread.sleep(2000);
    }

    public void clickingMenuCategory() throws InterruptedException {
        getDriver().findElement(this.mainMenuCategory).click();
        Thread.sleep(2000);
    }

    public void switchWindow() throws InterruptedException {
        Thread.sleep(2000);
        String windowHandle = getDriver().getWindowHandle();
        getDriver().switchTo().window(windowHandle);
        Thread.sleep(2000);

    }

    public void clickCategoryButton() throws InterruptedException {

        getDriver().findElement(this.categoryButton).click();

    }

    public void clickContinueButton() throws InterruptedException {

        getDriver().findElement(this.continueButton).click();
        Thread.sleep(2000);

    }

    public void inputPassword() throws InterruptedException {

        getDriver().findElement(this.password).sendKeys("test1111");
        Thread.sleep(2000);

    }

    public void inputConfirmPassword() throws InterruptedException {

        getDriver().findElement(this.confirmPassword).sendKeys("test1111");
        Thread.sleep(2000);

    }


    public void scrollDownPage() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement textbox1 = getDriver().findElement(By.linkText("Attributions"));
        js.executeScript("arguments[0].scrollIntoView();", textbox1);

        Thread.sleep(2000);

    }

    public void switchToiFrame() throws InterruptedException {

        getDriver().switchTo().frame(0);
        Thread.sleep(2000);

    }

    public void switchToNewWindow() throws InterruptedException {

        for(String winHandle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(winHandle);
        }

    }

    public void clickCancelButton() throws InterruptedException {

        getDriver().findElement(this.cancelButton).click();
        Thread.sleep(2000);

    }

    public void switchBackToPreviousWindow() throws InterruptedException {
        String windowHandleBefore = getDriver().getWindowHandle();

        getDriver().switchTo().window(windowHandleBefore);
        getDriver().switchTo().frame(0);

        Thread.sleep(2000);

    }

}
