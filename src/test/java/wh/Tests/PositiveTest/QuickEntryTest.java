package wh.Tests.PositiveTest;

import Page.CheckoutPage;
import Page.LoginPopup;
import Page.MainPage;
import Page.QuickEntryPage;
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
@Feature("Quick Entry Test")
public class QuickEntryTest extends BaseTest {

    private QuickEntryPage quickEntryPage;
    private LoginPopup loginPopup;
    private Wait wait;

    @BeforeMethod
    public void initPageObjects() {
        quickEntryPage = new QuickEntryPage(app.getDriver());
        loginPopup = new LoginPopup(app.getDriver());
        wait = new Wait(app.getDriver());
    }

    @Test(description = "9.05 Test Quick entry page", priority = 1)
    @Description("Test Description: Quick entry with correct SKU for field: 'Item Number'")
    @Story("Positive test. Correct SKU for fields: 'Item Number'")
    public void quickEntry() throws Exception{
        loginPopup.open();
        loginPopup.driverWaitPreloader();
        loginPopup.driverWait();
        loginPopup.clickSignInLink();
        loginPopup.driverWaitElement();
        loginPopup.loginAs();
        loginPopup.checkOpenMainPage();

        quickEntryPage.clickShopNowBtn();
        quickEntryPage.driverWait();
        quickEntryPage.checkTitle();
        quickEntryPage.fillItemNumberField();
        quickEntryPage.clickCheckButton();
        quickEntryPage.driverWaitproducts();
        quickEntryPage.checkProduct();
        quickEntryPage.clickRemoveLink();
    }
}