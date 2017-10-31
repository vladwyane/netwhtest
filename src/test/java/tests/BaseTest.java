package tests;

import drivers.DriverManagerFactory;
import helpers.GetPropertyValues;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ru.stqa.selenium.factory.WebDriverFactory;

import java.io.IOException;

import static java.util.concurrent.TimeUnit.SECONDS;

@Listeners(value = AllureTestListener.class)
public class BaseTest {
    protected DriverManagerFactory driverManagerFactory;
    protected WebDriver driver;
    protected Dimension dimension;

    @Parameters({"browser", "version"})
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional String browserName, @Optional String browserVersion) throws IOException {
        this.driverManagerFactory = new DriverManagerFactory();
        driver = this.driverManagerFactory.getRemoteDriver(browserName, browserVersion);
        dimension = new Dimension(GetPropertyValues.getWidth(), GetPropertyValues.getHeight());
        driver.manage().window().setSize(dimension);
        driver.manage().timeouts().implicitlyWait(30L, SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        WebDriverFactory.dismissAll();
    }
}