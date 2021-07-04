package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;

import static org.testng.AssertJUnit.assertEquals;

public class SuccessfulLoginTest extends BaseTest {

    @Test
    @Description("Failed login test")
    public void loginWithInCorrectCredentials() {

        LandingPage landingPage = new LandingPage();
        landingPage.clickOnMyAccountlink();

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUserNameField("NotExistingLogin");
        loginPage.typeIntoUserPasswordField("NotProperPassword");
        loginPage.clickOnLoginButton();
        String warningMessage = loginPage.getWarningMessage();
        assertEquals(warningMessage, "ERROR: The password you entered for the username NotExistingLogin is incorrect. Lost your password?");
    }
}