package vivaair;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.JavascriptExecutor;

public class SearchVivaairTest {
	
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.vivaair.com/#/co/es");
    }

    @Test
    public void testVivaAirForm() {
        WebDriverWait wait = new WebDriverWait(driver, 10000);

        WebElement origenButton = driver.findElement(By.name("station"));
        origenButton.click();
        WebElement origen = driver.findElement(By.name("filter-station"));
        origen.sendKeys("Cali");
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='station__name']")));
        option = option.findElement(By.tagName("div"));
        option.click();
        WebElement destino = driver.findElement(By.name("filter-station-second"));
        destino.sendKeys("Armenia");
        option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='station__name']")));
        option = option.findElement(By.tagName("div"));
        option.click();
        WebElement fecha_iniButton = driver.findElement(By.name("date"));
        fecha_iniButton.click();

    }

    @After
    public void tearDown() {
            //driver.quit();
    }

}
