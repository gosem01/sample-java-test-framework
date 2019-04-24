package tests.macys.macysHeader;

import HomePageSteps.HomeSteps;
import io.qameta.allure.Description;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import tests.BaseTest;

@Ignore
public class checkHamburgerMenu extends BaseTest {

    public HomeSteps homeSteps = new HomeSteps();

    @Test(description = "Check user navigated to sidebar after clicking on the Hamburger menu")
    @Description("Check user navigated to sidebar after clicking on the Hamburger menu")
    public void validatePageContent() throws InterruptedException {

        homeSteps.openPage();
        homeSteps.clickingHamburgerMenu();

    }
}