package practice.automationtesting.in.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    @FindBy(xpath = "//ul[@id='main-nav']/li[2]")
    private WebElement EnterMyAccount;

    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnMyAccountlink() {
        EnterMyAccount.click();
    }
}