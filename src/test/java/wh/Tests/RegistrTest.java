package wh.Tests;

import Page.LoginPopup;
import Page.RegistrationPopUp;
import Utils.Wait;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class RegistrTest extends BaseTest {
    private RegistrationPopUp registrationPopUp = PageFactory.initElements(initDriver(), RegistrationPopUp.class);
    private Wait wait = PageFactory.initElements(initDriver(), Wait.class);

    @Test(description = "1.03 Test registration pop-up with empty fields", priority = 1)
    public void RegisteredEmptyFields() throws Exception {
        registrationPopUp.open();
        wait.threadsSleepWait();
        registrationPopUp.driverWait();
        registrationPopUp.clickSignUpLink();
        wait.threadsSleepWait();
        registrationPopUp.clickSignUpBtn();
        registrationPopUp.checkEmptyValidMessage();
    }

    @Test(description = "1.02 Test registration pop-up with not valid data", priority = 2)
    public void RegisteredWithValidData() throws Exception {
        registrationPopUp.open();
        wait.threadsSleepWait();
        registrationPopUp.driverWait();
        registrationPopUp.clickSignUpLink();
        wait.threadsSleepWait();
        registrationPopUp.registrAsWithNotValidData();
        registrationPopUp.checkValidation();
    }

    @Test(description = "1.01 Test registration pop-up with valid data", priority = 3)
    public void RegisteredWithNotValidData() throws Exception {
        registrationPopUp.open();
        wait.threadsSleepWait();
        registrationPopUp.driverWait();
        registrationPopUp.clickSignUpLink();
        wait.threadsSleepWait();
        registrationPopUp.registrAs();
        registrationPopUp.registered();
    }
}