package vivaair;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
        Actions actions = new Actions(driver);
        WebElement origenButton, origen, option, destino, fechas_ida;
        
        origenButton = driver.findElement(By.name("station"));
        origenButton.click();
        origen = driver.findElement(By.name("filter-station"));
        origen.sendKeys("cali");
        actions.keyDown(origen, Keys.CONTROL).keyUp(origen, Keys.CONTROL).perform();
        option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='station__name']")));
        option.click();
        destino = driver.findElement(By.name("filter-station-second"));
        destino.sendKeys("bogota");
        option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='station__name']")));
        option.click();  
        /*
        driver.findElement(By.id("station")).click();
        driver.findElement(By.id("filter-station")).sendKeys("cali");
        driver.findElement(By.cssSelector(".station__name > div")).click();
        driver.findElement(By.cssSelector(".station__name:nth-child(8) > div")).click();
        driver.findElement(By.cssSelector(".calendar__date_picker__container__day--first--wed > .high:nth-child(23)")).click();
        driver.findElement(By.cssSelector(".calendar__date_picker__container__day--first--sat > .high:nth-child(23)")).click();
        driver.findElement(By.id("passenger")).click();
        driver.findElement(By.cssSelector(".passenger__wrapper:nth-child(2) .passenger__wrapper__row-action:nth-child(2) > .action__sign")).click();
        driver.findElement(By.cssSelector(".passenger__wrapper:nth-child(3) .passenger__wrapper__row-action:nth-child(2) > .action__sign")).click();
        driver.findElement(By.cssSelector(".passenger__wrapper:nth-child(1) .passenger__wrapper__row-action:nth-child(2) > .action__sign")).click();
        driver.findElement(By.cssSelector(".ibe__button__desktop > .ibe__inputs-button")).click();
        driver.findElement(By.cssSelector(".fare__price--selected")).click();
        driver.findElement(By.cssSelector(".booking__continue-btn__icon")).click();
        driver.findElement(By.cssSelector("#flight-Vkh_NTU1OH4gfn5MRVR_MDEvMjMvMjAyMiAxMjo0NH5CT0d_MDEvMjMvMjAyMiAxNDo0N35_XlZIfjU4MDV_IH5_Qk9HfjAxLzIzLzIwMjIgMjE6MjB_Q0xPfjAxLzIzLzIwMjIgMjI6MjJ_fg-- .lowest-fare__from")).click();
        */
    }

    @After
    public void tearDown() {
            //driver.quit();
    }

}
