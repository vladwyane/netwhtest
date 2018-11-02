package wh.Tests.NegativeTest;

import Page.EnterNewInmateInformPopUp;
import Page.ForgotPasswordPopUp;
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
@Feature("Forgot Password")
public class ForgotPasswordTest extends BaseTest {

    private ForgotPasswordPopUp forgotPasswordPopUp;
    private LoginPopup loginPopup;
    private Wait wait;

    @BeforeMethod
    public void initPageObjects() {
        forgotPasswordPopUp = new ForgotPasswordPopUp(app.getDriver());
        loginPopup = new LoginPopup(app.getDriver());
        wait = new Wait(app.getDriver());
    }

    @Test(description = "2.04 Test Forgot password with empty field", priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Check error messages for empty field")
    @Story("Negative test. Empty field")
    public void testWithEmptyField() throws Exception {
        forgotPasswordPopUp.open();
        wait.threadsSleepWait();
        forgotPasswordPopUp.clickSignInLink();
        wait.threadsSleepWait();
        forgotPasswordPopUp.clickLink();
        forgotPasswordPopUp.checkTitle();
        forgotPasswordPopUp.clickBtn();
        forgotPasswordPopUp.checkNotExistMessage();
    }

    @Test(description = "2.03 Test Forgot password with not valid data", priority = 2)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Check error messages for not valid data for field")
    @Story("Negative test. Not Valid Data")
    public void testWithNotValidData() throws Exception {
        forgotPasswordPopUp.open();
        wait.threadsSleepWait();
        forgotPasswordPopUp.clickSignInLink();
        wait.threadsSleepWait();
        forgotPasswordPopUp.clickLink();
        forgotPasswordPopUp.checkTitle();
        forgotPasswordPopUp.fillNotValidDataField();
        forgotPasswordPopUp.clickBtn();
        forgotPasswordPopUp.checkNotFoundMessage();
    }

    @Test(description = "2.02 Test forgot password. Email isn't exist", priority = 3)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Check error messages for not exist user")
    @Story("Negative test. Not exist user")
    public void testWithIsNotExistEmail() throws Exception {
        forgotPasswordPopUp.open();
        wait.threadsSleepWait();
        forgotPasswordPopUp.clickSignInLink();
        wait.threadsSleepWait();
        forgotPasswordPopUp.clickLink();
        forgotPasswordPopUp.checkTitle();
        forgotPasswordPopUp.fillNotExistDataField();
        forgotPasswordPopUp.clickBtn();
        forgotPasswordPopUp.checkNotFoundMessage();
    }
}