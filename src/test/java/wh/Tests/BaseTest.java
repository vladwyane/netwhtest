package wh.Tests;

import Utils.ConfigProperties;
import Data.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public WebDriver initDriver() {
        if (driver == null) {
            String path = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/chromedriver.exe");

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigProperties.getProperty("imp.wait")), TimeUnit.SECONDS);
        }
        return driver;
    }

    @AfterClass
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
