package wh.Tests.NegativeTest;

import Page.FundInmatePage;
import Page.GetACatalogPage;
import Utils.Wait;
import io.qameta.allure.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import wh.Tests.TestBase.BaseTest;

@Listeners({TestListenerAdapter.class})
@Epic("Regresion Tests")
@Feature("Get A Catalog")
public class GetACatalogTest extends BaseTest {

    private GetACatalogPage getACatalogPage;
    private Wait wait;

    @BeforeMethod
    public void initPageObjects() {
        getACatalogPage = new GetACatalogPage(app.getDriver());
        wait = new Wait(app.getDriver());
    }

    @Test(description = "8.04 Test Get A Catalog page. Fill form Get a catalog without data")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Check error messages for empty fields")
    @Story("Negative test. Empty fields")
    public void checkValidCatalog() throws Exception {
        getACatalogPage.open();
        wait.threadsSleepWait();
        getACatalogPage.driverVisibleWait();
        getACatalogPage.driverWait();
        getACatalogPage.clickGetACatalogLink();
        getACatalogPage.checkTitle();
        getACatalogPage.clickRequestBtn();
        getACatalogPage.checkFullNameMessage();
        getACatalogPage.checkAddressMessage();
        getACatalogPage.checkCityMessage();
        getACatalogPage.checkStateMessage();
        getACatalogPage.checkZipMessage();
        getACatalogPage.checkEmailMessage();
        getACatalogPage.checkCatalogTypeMessage();
        getACatalogPage.scrollDownToVisibleElement();
    }
}