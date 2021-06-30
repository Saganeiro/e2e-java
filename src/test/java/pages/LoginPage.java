package pages;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(xpath = "//ul[@class='woocommerce-error']/li[1]")
    private WebElement messageLabel;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void typeIntoUserNameField(String username) {
        logger.info("Trying to click username field");
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
        logger.info("Username typed into password field");
    }

    public void typeIntoUserPasswordField(String password) {
        logger.info("Trying to click password field");
        WaitForElement.waitUntilElementIsVisible(passwordField);
        passwordField.sendKeys(password);
        logger.info("Password typed into password field");
    }

    public void clickOnLoginButton() {
        logger.info("Trying to click login button");
        loginButton.click();
        logger.info("Clicked on login button");
    }

    public String getWarningMessage() {
        return messageLabel.getText();
    }
}