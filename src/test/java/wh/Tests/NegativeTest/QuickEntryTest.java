package wh.Tests.NegativeTest;

import Page.GetACatalogPage;
import Page.LoginPopup;
import Page.QuickEntryPage;
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
@Feature("Quick Entry")
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

    @Test(description = "9.06 Test Quick entry page")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Check error messages for wrong entered SKU")
    @Story("Negative test. Wrong entered SKU")
    public void quickEntryWrongSKU() throws Exception{
        loginPopup.open();
        wait.threadsSleepWait();
        loginPopup.driverWait();
        loginPopup.clickSignInLink();
        loginPopup.driverWaitElement();
        loginPopup.loginAs();
        loginPopup.checkOpenMainPage();
        wait.threadsSleepWait();

        quickEntryPage.driverWaitBtn();
        quickEntryPage.clickShopNowBtn();
        quickEntryPage.driverWait();
        quickEntryPage.checkTitle();
        quickEntryPage.fillWrongItemNumberField();
        quickEntryPage.clickCheckButton();
        quickEntryPage.checkErrorMessage();
    }
}
