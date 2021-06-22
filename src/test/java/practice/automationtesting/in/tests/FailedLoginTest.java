package practice.automationtesting.in.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practice.automationtesting.in.pages.LandingPage;
import practice.automationtesting.in.pages.LoginPage;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTest extends TestBase {

    @Test
    public void loginWithInCorrectCredentials() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnMyAccountlink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUserNameField();
        loginPage.typeIntoUserPasswordField();
        loginPage.clickOnLoginButton();
        String warningMessage = loginPage.getWarningMessage();
        assertEquals(warningMessage, "Error: A user could not be found with this email address.");
    }
}