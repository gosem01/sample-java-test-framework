package tests.macys.macysHomePage;

import HomePageSteps.HomeSteps;
import io.qameta.allure.Description;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import tests.BaseTest;

@Ignore
public class checkPlusButton extends BaseTest {

    public HomeSteps homeSteps = new HomeSteps();

    @Test(description = "Testing Home")
    @Description("Macys Home Page to Category and Back to Home")
    public void validatePageContent() throws InterruptedException {

        homeSteps.openPage();
        homeSteps.clickMainMenu();
        homeSteps.clickMenuCategory();

    }
}