package wh.Tests.PositiveTest;

import Page.ForgotPasswordPopUp;
import Page.GetACatalogPage;
import Page.LoginPopup;
import Utils.Wait;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import wh.Tests.TestBase.BaseTest;

@Listeners({TestListenerAdapter.class})
@Epic("Regresion Tests")
@Feature("Test 'Get A Catalog' page")
public class GetACatalogTest extends BaseTest {

    private GetACatalogPage getACatalogPage;
    private Wait wait;

    @BeforeMethod
    public void initPageObjects() {
        getACatalogPage = new GetACatalogPage(app.getDriver());
        wait = new Wait(app.getDriver());
    }

    @Test(description = "8.03 Test Get A Catalog page. Fill form Get a catalog with data")
    @Description("Test Description: Send 'Test Catalog' with valid data on email")
    @Story("Positive test. Correct data for required fields")
    public void sendCatalog() throws Exception {
        getACatalogPage.open();
        getACatalogPage.driverWaitPreloader();
        getACatalogPage.driverVisibleWait();
        getACatalogPage.driverWait();
        getACatalogPage.clickGetACatalogLink();
        getACatalogPage.checkTitle();
        getACatalogPage.fillCatalogForm();
        wait.threadsSleepWait();
        getACatalogPage.checkPopUpTitle();
        getACatalogPage.scrollDownToVisibleElement();
    }
}