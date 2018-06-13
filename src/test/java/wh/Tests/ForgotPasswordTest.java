package wh.Tests;

import Page.ForgotPasswordPopUp;
import Page.LoginPopup;
import Utils.Wait;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest {

    private ForgotPasswordPopUp forgotPasswordPopUp = PageFactory.initElements(initDriver(), ForgotPasswordPopUp.class);
    private Wait wait = PageFactory.initElements(initDriver(), Wait.class);

    @Test(description = "2.04 Test Forgot password with empty field", priority = 1)
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

    @Test(description = "2.01 Test forgot password. Valid data", priority = 4)
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
