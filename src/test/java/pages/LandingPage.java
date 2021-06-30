package pages;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LandingPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//ul[@id='main-nav']/li[2]")
    private WebElement EnterMyAccount;

    public LandingPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnMyAccountlink() {
        logger.info("Trying to click Enter My Account link");
        WaitForElement.waitUntilElementIsClickable(EnterMyAccount);
        logger.info("Clicked on Enter My Account link");
        EnterMyAccount.click();
    }
}