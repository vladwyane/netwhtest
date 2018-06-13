package wh.Tests;

import Page.LandingPage;
import Page.LoginPopup;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Utils.Wait;

public class SignInTest extends BaseTest {

    private LoginPopup loginPopup = PageFactory.initElements(initDriver(), LoginPopup.class);
    private Wait wait = PageFactory.initElements(initDriver(), Wait.class);

    @Test(description = "3.03 Test sign in with empty fields", priority = 1)
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

    @Test(description = "3.01 Test sign in with valid data", priority = 3)
    public void SignedIn() throws Exception {
        loginPopup.open();
        wait.threadsSleepWait();
        loginPopup.driverWait();
        loginPopup.clickSignInLink();
        loginPopup.driverWaitElement();
        loginPopup.loginAs();
        loginPopup.checkOpenMainPage();
        wait.threadsSleepWait();
        loginPopup.signedOutClick();
    }
}