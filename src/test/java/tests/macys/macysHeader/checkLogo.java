package tests.macys.macysHeader;

import HomePageSteps.HomeSteps;
import io.qameta.allure.Description;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import tests.BaseTest;

@Ignore
public class checkLogo extends BaseTest {

    public HomeSteps homeSteps = new HomeSteps();

    @Test(description = "Check user navigated to Home page after clicking on the Logo")
    @Description("Check user navigated to Home page after clicking on the Logo")
    public void validatePageContent() throws InterruptedException {

        homeSteps.openPage();
        homeSteps.clickingHomeLogo();
        homeSteps.checkHomePage();

    }
}