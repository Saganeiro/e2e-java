import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebElementsTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://practice.automationtesting.in/shop/");
    }

    @Test
    public void waitTest(){

        WebElement checkboxFIeld = driver.findElement(By.xpath("//input[@id='checkbox']"));
        assertTrue(checkboxFIeld.isEnabled());
        assertTrue(!checkboxFIeld.isSelected());

        WebElement button = driver.findElement(By.id("btn"));
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOf(checkboxFIeld));

        WebElement message = driver.findElement(By.xpath("//p[@id='message']"));
        assertEquals(message.getText(), "It's gone!");

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}

