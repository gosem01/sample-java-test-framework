package entities.components;

import org.openqa.selenium.By;

import static utils.LocalDriverManager.getDriver;

public class Header {

    private By searchField = By.id("globalSearchInputField");
    private By searchButton = By.id("searchSubmit");
    private By headerLogo = By.id("mb-j-header-image");
    private By headerHamburgerMenu = By.id("mb-j-nav-button");

    public void inputSearchText(String Text) throws InterruptedException {
        getDriver().findElement(this.searchField).sendKeys(Text);
        Thread.sleep(2000);
    }

    public void clickSearchButton() throws InterruptedException {
        getDriver().findElement(this.searchButton).click();
        Thread.sleep(2000);
    }

    public void clickHomeLogoLink() throws InterruptedException {
        getDriver().findElement(this.headerLogo).click();
        Thread.sleep(2000);
    }

    public void clickHamburgerMenu() throws InterruptedException {
        getDriver().findElement(this.headerHamburgerMenu).click();
        Thread.sleep(2000);
    }

}
