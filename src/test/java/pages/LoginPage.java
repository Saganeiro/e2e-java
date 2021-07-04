package pages;

import io.qameta.allure.Step;
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

    @Step("Type into User Name Field {username}")
    public void typeIntoUserNameField(String username) {
        log().info("Trying to click username field");
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
        log().info("Username typed into password field");
    }

    @Step("Type into Password Field {password}")
    public void typeIntoUserPasswordField(String password) {
        log().info("Trying to click password field");
        WaitForElement.waitUntilElementIsVisible(passwordField);
        passwordField.sendKeys(password);
        log().info("Password typed into password field");
    }

    @Step("Click on Login Button")
    public void clickOnLoginButton() {
        log().info("Trying to click login button");
        loginButton.click();
        log().info("Clicked on login button");
    }

    @Step("Getting warning message from Login Page")
    public String getWarningMessage() {
        return messageLabel.getText();
    }
}