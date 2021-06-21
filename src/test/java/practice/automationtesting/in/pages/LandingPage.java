package practice.automationtesting.in.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnMyAccountlink() {
        WebElement EnterMyAccount = driver.findElement(By.xpath("//ul[@id='main-nav']/li[2]"));
        EnterMyAccount.click();
    }
}