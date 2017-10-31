package tests;

import blocks.Header;
import blocks.SignInPopup;
import dataproviders.DataProviders;
import helpers.GetPropertyValues;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.DashboardPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class TestGrid extends BaseTest {


    public BasePage basePage;
    public Header header;


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        basePage = new BasePage(driver);
        header = new Header(driver);

    }


    @TestCaseId("1")
    @Features("BasePage")
    @Stories("BasePage")
    @Test(dataProvider = "test", dataProviderClass = DataProviders.class, priority = 1)
    public void openBasePage(String email, String password, String expectedName) throws Exception {
        basePage.openPage(GetPropertyValues.getEnv());
        SignInPopup signInPopup = header.openSignInPopup();
        header = signInPopup.signIn(email,password);
        DashboardPage dashboardPage = header.openMyAccount();
        Assert.assertEquals(dashboardPage.getNameIntitle(), expectedName);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
