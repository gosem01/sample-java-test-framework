package tests.macys.macysHomePage;

import HomePageSteps.HomeSteps;
import io.qameta.allure.Description;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import tests.BaseTest;


public class searchProduct extends BaseTest {

    public HomeSteps homeSteps = new HomeSteps();

    @Test(description = "Search for a Product")
    @Description("Use header search to find a product")
    public void validatePageContent() throws InterruptedException {

        homeSteps.openPage();
        homeSteps.searchForProduct();

    }
}