package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class LoginPage {

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
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
    }

    public void typeIntoUserPasswordField(String password) {
        WaitForElement.waitUntilElementIsVisible(passwordField);
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public String getWarningMessage() {
        return messageLabel.getText();
    }
}