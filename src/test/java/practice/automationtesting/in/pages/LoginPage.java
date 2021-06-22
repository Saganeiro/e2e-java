package practice.automationtesting.in.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(xpath = "//ul[@class='woocommerce-error']/li[1]")
    private WebElement messageLabel;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeIntoUserNameField() {
        usernameField.clear();
        usernameField.sendKeys("NotExistingUser@test.pl");
    }

    public void typeIntoUserPasswordField() {
        passwordField.clear();
        passwordField.sendKeys("NotProperPassword");
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public String getWarningMessage() {
        return messageLabel.getText();
    }
}