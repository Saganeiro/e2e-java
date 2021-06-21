package practice.automationtesting.in.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practice.automationtesting.in.pages.LandingPage;
import practice.automationtesting.in.pages.LoginPage;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class failedLoginTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://practice.automationtesting.in/");
        driver.manage().window().fullscreen();
    }

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

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}