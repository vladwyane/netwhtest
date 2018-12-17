package wh.Tests.TestBase;

import Utils.ConfigProperties;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by bigdrop on 10/25/2018.
 */
public class ApplicationManager {

    private String browser;
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private WebDriver driver;


    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver unit() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("70.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        driver = new RemoteWebDriver(
                URI.create("http://10.0.1.200:4444/wd/hub/").toURL(),
                capabilities);
        driver.manage().deleteAllCookies();
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigProperties.getProperty("imp.wait")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        return driver;
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void delleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

//    public byte[] takeScreenshot() {
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    }
}