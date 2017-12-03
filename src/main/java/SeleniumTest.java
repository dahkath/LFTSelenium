import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import com.hpe.leanft.selenium.By;
import com.hpe.leanft.selenium.Utils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeleniumTest  {

    private static WebDriver driver;
    public SeleniumTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/opt/selenium/2.27/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDownAfterClass() {
        //Clean up and dispose of the driver
        //Good explanation of close, quit, dispose here http://stackoverflow.com/questions/15067107/difference-between-webdriver-dispose-close-and-quit
        driver.quit();
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void TestAdvantage() throws Exception {
        //driver.get("http://www.advantageonlineshopping.com");
        driver.get("http://dockerserver:8000");

        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //Click on Tablets
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.visibleText("TABLETS")));
        Utils.highlight(driver.findElement(By.visibleText("TABLETS")), 1000);
        driver.findElement(By.visibleText("TABLETS")).click();


        //Click on specific tablet
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.visibleText("HP Pro Tablet 608 G1")));
        Utils.highlight(driver.findElement(By.visibleText("HP Pro Tablet 608 G1")), 1000);
        driver.findElement(By.visibleText("HP Pro Tablet 608 G1")).click();

        //Added sleep here to give time to see the selection
        Thread.sleep(3000);
    }
}