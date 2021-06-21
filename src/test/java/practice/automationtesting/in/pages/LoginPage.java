package practice.automationtesting.in.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeIntoUserNameField() {
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("NotExistingUser@test.pl");
    }

    public void typeIntoUserPasswordField() {
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("NotProperPassword");
    }

    public void clickOnLoginButton() {
        WebElement signOnButton = driver.findElement(By.name("login"));
        signOnButton.click();
    }

    public String getWarningMessage() {
        WebElement messageLabel = driver.findElement(By.xpath("//ul[@class='woocommerce-error']/li[1]"));
        return messageLabel.getText();
    }
}