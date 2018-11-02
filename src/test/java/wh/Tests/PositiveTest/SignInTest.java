package wh.Tests.PositiveTest;

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
@Feature("Sign In Test")
public class SignInTest extends BaseTest {

    private Wait wait;
    LoginPopup loginPopup;

    @BeforeMethod
    public void initPageObjects() {
        loginPopup = new LoginPopup(app.getDriver());
        wait = new Wait(app.getDriver());
    }

    @Test(description = "3.01 Test sign in with valid data")
    @Description("Test Description: Sign In test with correct email and password")
    @Story("Positive test. Correct email and password")
    public void SignedIn() throws Exception {
        loginPopup.open();
        loginPopup.driverWaitPreloader();
        loginPopup.driverWait();
        loginPopup.clickSignInLink();
        loginPopup.driverWaitElement();
        loginPopup.loginAs();
        loginPopup.checkOpenMainPage();
        wait.threadsSleepWait();
        loginPopup.driverWaitSignout();
        loginPopup.signedOutClick();
    }
}