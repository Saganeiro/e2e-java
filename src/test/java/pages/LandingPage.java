package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class LandingPage extends BasePage {

    @FindBy(xpath = "//ul[@id='main-nav']/li[2]")
    private WebElement EnterMyAccount;

    public void clickOnMyAccountlink() {
        log().info("Trying to click Enter My Account link");
        WaitForElement.waitUntilElementIsClickable(EnterMyAccount);
        log().info("Clicked on Enter My Account link");
        EnterMyAccount.click();
    }
}