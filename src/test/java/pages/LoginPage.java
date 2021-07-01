package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(xpath = "//ul[@class='woocommerce-error']/li[1]")
    private WebElement messageLabel;

    public void typeIntoUserNameField(String username) {
        log().info("Trying to click username field");
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
        log().info("Username typed into password field");
    }

    public void typeIntoUserPasswordField(String password) {
        log().info("Trying to click password field");
        WaitForElement.waitUntilElementIsVisible(passwordField);
        passwordField.sendKeys(password);
        log().info("Password typed into password field");
    }

    public void clickOnLoginButton() {
        log().info("Trying to click login button");
        loginButton.click();
        log().info("Clicked on login button");
    }

    public String getWarningMessage() {
        return messageLabel.getText();
    }
}