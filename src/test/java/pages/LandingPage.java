package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class LandingPage {

    @FindBy(xpath = "//ul[@id='main-nav']/li[2]")
    private WebElement EnterMyAccount;

    public LandingPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnMyAccountlink() {
        WaitForElement.waitUntilElementIsClickable(EnterMyAccount);
        EnterMyAccount.click();
    }
}