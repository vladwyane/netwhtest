package wh.Tests.NegativeTest;

import Page.LoginPopup;
import Page.QuickEntryPage;
import Page.RegistrationPopUp;
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
@Feature("Registration")
public class RegistrTest extends BaseTest {
    private RegistrationPopUp registrationPopUp;
    private LoginPopup loginPopup;
    private Wait wait;

    @BeforeMethod
    public void initPageObjects() {
        registrationPopUp = new RegistrationPopUp(app.getDriver());
        loginPopup = new LoginPopup(app.getDriver());
        wait = new Wait(app.getDriver());
    }

    @Test(description = "1.03 Test registration pop-up with empty fields", priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Check empty error messages for Registration pop-up")
    @Story("Negative test. Empty fields 'First Name', 'Last Name', 'Email','Password', 'Confirm Password'")
    public void RegisteredEmptyFields() throws Exception {
        registrationPopUp.open();
        wait.threadsSleepWait();
        registrationPopUp.driverWait();
        registrationPopUp.clickSignUpLink();
        registrationPopUp.driverWaitBtn();
        registrationPopUp.clickSignupBtn();
        registrationPopUp.driverWaitMessage();
        registrationPopUp.checkEmptyValidMessage();
    }

    @Test(description = "1.02 Test registration pop-up with not valid data", priority = 2)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Checked validation messages for Registration pop-up")
    @Story("Negative test. Not Valid Data for fields 'First Name', 'Last Name', 'Email','Password', 'Confirm Password'")
    public void RegisteredWithValidData() throws Exception {
        registrationPopUp.open();
        wait.threadsSleepWait();
        registrationPopUp.driverWait();
        registrationPopUp.clickSignUpLink();
        registrationPopUp.driverWaitPopUp();
        registrationPopUp.registrAsWithNotValidData();
        registrationPopUp.checkValidation();
    }
}