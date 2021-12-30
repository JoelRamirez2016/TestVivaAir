package vivaair;

import java.util.List;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
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
        driver.manage().window().setSize(new Dimension(1440, 900));
        driver.get("https://www.vivaair.com/#/co/es");
    }

    @Test
    public void testVivaAirFormSubmit() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement origen, days, submit;
        List<WebElement> calendars_mount, submit_buttons, passengers;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,1000)");
        /*Click input select city*/
        driver.findElement(By.name("station")).click();
        /*write a origen city in the input*/
        origen = driver.findElement(By.name("filter-station"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='station__popover__row']")));
        origen.sendKeys("cali");   
        /* write the destiny city*/
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='station__name']"))).click();        
        driver.findElement(By.name("filter-station-second")).sendKeys("bogota");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='station__name']"))).click();
        /* Select dates*/
        calendars_mount = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".calendar__date_picker__container__day--first--wed")));
        days = calendars_mount.stream().filter(calendar -> calendar.isDisplayed()).findAny().orElse(null);
        days.findElement(By.cssSelector(":nth-child(31)")).click();    
        calendars_mount = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".calendar__date_picker__container__day--first--sat")));
        days = calendars_mount.stream().filter(calendar -> calendar.isDisplayed()).findAny().orElse(null);
        days.findElement(By.cssSelector(":nth-child(20)")).click();
        /*Click input passengers*/
        driver.findElement(By.name("passenger")).click();
        passengers = driver.findElements(By.className("action__sign"));                
        passengers.get(1).click();
        passengers.get(3).click();
        passengers.get(5).click();
        submit_buttons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".ibe__inputs-button")));
        submit = submit_buttons.stream().filter(button -> button.isDisplayed()).findAny().orElse(null);
        submit.click();
    }

    @After
    public void tearDown() {
            //driver.quit();
    }

}
