package drivers;

import helpers.GetPropertyValues;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

public class PrepareDrivers {
    public static DesiredCapabilities capabilities;


    public static DesiredCapabilities prepareWebDriverFirefox() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver.exe");
        capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);

        return capabilities;
    }

    public static DesiredCapabilities prepareWebDriverChrome() throws IOException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver");
        capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("no-sandbox");
        options.setBinary(GetPropertyValues.getChromeBinary());
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        return capabilities;
    }

    public static DesiredCapabilities prepareWebDriverEDGE() {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\MicrosoftWebDriver.exe");
        capabilities = DesiredCapabilities.edge();
        EdgeOptions options = new EdgeOptions();
        capabilities.setCapability(EdgeOptions.CAPABILITY, options);

        return capabilities;
    }

    public static DesiredCapabilities prepareRemoteDriver(String browserName, String browserVersion) {
        capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browserName);
        capabilities.setVersion(browserVersion);
        capabilities.setCapability("screenResolution", "1920x1080x24");
        capabilities.setCapability("enableVNC", true);

        return capabilities;
    }

}

