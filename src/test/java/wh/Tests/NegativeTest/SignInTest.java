package wh.Tests.NegativeTest;

import Page.LoginPopup;
import Page.SearchByNamePopUp;
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

    private LoginPopup loginPopup;
    private Wait wait;

    @BeforeMethod
    public void initPageObjects() {
        loginPopup = new LoginPopup(app.getDriver());
        wait = new Wait(app.getDriver());
    }

    @Test(description = "3.03 Test sign in with empty fields", priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Sign In test with empty fields 'Email' and 'Password'")
    @Story("Negative test. Empty field 'Email' and 'Password'")
    public void SignedInWithEmpty() throws Exception {
        loginPopup.open();
        wait.threadsSleepWait();
        loginPopup.driverWait();
        loginPopup.clickSignInLink();
        loginPopup.driverWaitElement();
        loginPopup.clickSignInBtn();
        loginPopup.checkEmailValidationError();
        loginPopup.checkPasswordValidationError();
    }

    @Test(description = "3.02 Test sign in with unregistered user", priority = 2)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Sign In test with incorrect fields 'Email' and 'Password'")
    @Story("Negative test. Empty incorrect data for fields 'Email' and 'Password'")
    public void SignedInWithUnregisteredUser() throws Exception {
        loginPopup.open();
        wait.threadsSleepWait();
        loginPopup.driverWait();
        loginPopup.clickSignInLink();
        loginPopup.driverWaitElement();
        loginPopup.fillUnregisteredUser();
        loginPopup.clickSignInBtn();
        loginPopup.checkEmailValidationMessages();
        loginPopup.checkPasswordValidationMessages();
    }
}