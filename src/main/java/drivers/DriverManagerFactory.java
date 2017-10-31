package drivers;

import helpers.GetPropertyValues;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;

public class DriverManagerFactory {
    private WebDriver driver;
    private static final Logger LOG = Logger.getLogger("PrepareDrivers");

    public WebDriver getDriver(String browser) throws IOException {
        WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
        if (browser == null)
            browser = "UNKNOWN BROWSER INPUT";
        switch (browser.toUpperCase()) {
            case "FIREFOX":
                LOG.info("MyWebDriverFactory: browser FF. ");
                return driver = WebDriverFactory.getDriver(PrepareDrivers.prepareWebDriverFirefox());

            case "CHROME":
                LOG.info("MyWebDriverFactory: browser Chrome. ");
                return driver = WebDriverFactory.getDriver(PrepareDrivers.prepareWebDriverChrome());

            case "EDGE":
                LOG.info("MyWebDriverFactory: browser EDGE. ");
                return driver = WebDriverFactory.getDriver(PrepareDrivers.prepareWebDriverEDGE());

            default:
                LOG.info("MyWebDriverFactory: browser unknown. Default option - Chrome");
                return driver = WebDriverFactory.getDriver(PrepareDrivers.prepareWebDriverChrome());
        }
    }

    public WebDriver getRemoteDriver(String browserName, String browserVersion) throws IOException {
        if (browserName == null) {
            browserName = GetPropertyValues.getNodeBrowser();
        }
        if (browserVersion == null) {
            browserVersion = GetPropertyValues.getNodeBrowserVersion();
        }

        return driver = new RemoteWebDriver(URI.create(GetPropertyValues.getHub()).toURL(), PrepareDrivers.prepareRemoteDriver(browserName.toLowerCase(), browserVersion));
    }

}

