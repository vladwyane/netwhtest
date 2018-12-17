package wh.Tests.TestBase;

import Utils.ConfigProperties;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Listeners(MyTestListener.class)
public class BaseTest {

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeMethod
    public void setupTest(ITestContext context) throws Exception{
        app.unit();
        context.setAttribute("app", app);
    }

    @AfterMethod
    public void teardown() {
        app.stop();
    }


}