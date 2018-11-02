package wh.Tests.PositiveTest;

import Page.EnterNewInmateInformPopUp;
import Page.ForgotPasswordPopUp;
import Page.LoginPopup;
import Page.SearchByNamePopUp;
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
@Feature("Forgot password Test")
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

    @Test(description = "2.01 Test forgot password. Valid data")
    @Description("Test Description: Send request for change password")
    @Story("Positive test. Correcte email for send email with links for change password")
    public void testWithiValidData() throws Exception {
        forgotPasswordPopUp.open();
        wait.threadsSleepWait();
        forgotPasswordPopUp.clickSignInLink();
        wait.threadsSleepWait();
        forgotPasswordPopUp.clickLink();
        forgotPasswordPopUp.checkTitle();
        forgotPasswordPopUp.fillValidDataField();
        forgotPasswordPopUp.clickBtn();
        forgotPasswordPopUp.checkOpenedPopUp();
    }
}