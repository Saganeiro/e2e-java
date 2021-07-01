package tests;

import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;

import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTest extends BaseTest {

    @Test
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