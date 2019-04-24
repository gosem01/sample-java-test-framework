package HomePageSteps;

import entities.components.Header;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.HomePage;
import utils.Utils;

public class HomeSteps {

    HomePage homePage = new HomePage();
    Header headerComponent = new Header();

    @Step("Open Home Page")
    public void openPage() {

        homePage.goToPage();
        Assert.assertFalse(homePage.isPageOpened());

        Utils.takeLogs();
        Utils.takeScreenshot();
    }

    @Step("Check Home Page")
    public void checkHomePage() {
        Assert.assertFalse(homePage.isPageOpened());

        Utils.takeLogs();
        Utils.takeScreenshot();
    }

    @Step("Check Category Button")
    public void checkCategoryButton() throws InterruptedException {

        headerComponent.clickHamburgerMenu();
        homePage.clickCategoryButton();

        Utils.takeLogs();
        Utils.takeScreenshot();
    }

    @Step("Browser Back Button")
    public void backButton() {

        homePage.browserBack();

        Utils.takeLogs();
        Utils.takeScreenshot();
    }

    @Step("Click Menu")
    public void clickMainMenu() throws InterruptedException {

        homePage.clickingMenuButton();

        Utils.takeLogs();
        Utils.takeScreenshot();
    }

    @Step("Click Menu Category")
    public void clickMenuCategory() throws InterruptedException {

        homePage.clickingMenuCategory();

        Utils.takeLogs();
        Utils.takeScreenshot();
    }

    @Step("Search Product")
    public void searchForProduct() throws InterruptedException {

        headerComponent.inputSearchText("shirt");
        headerComponent.clickSearchButton();

        Utils.takeLogs();
        Utils.takeScreenshot();

    }

    @Step("Click Home Logo")
    public void clickingHomeLogo() throws InterruptedException {

        headerComponent.clickHomeLogoLink();
        homePage.isPageOpened();

        Utils.takeLogs();
        Utils.takeScreenshot();
    }

    @Step("Click Hamburger Menu")
    public void clickingHamburgerMenu() throws InterruptedException {

        headerComponent.clickHamburgerMenu();
        homePage.isMenuOpened();

        Utils.takeLogs();
        Utils.takeScreenshot();
    }

}
