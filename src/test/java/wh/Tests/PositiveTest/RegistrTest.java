package wh.Tests.PositiveTest;

import Page.LoginPopup;
import Page.QuickEntryPage;
import Page.RegistrationPopUp;
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
@Feature("Sign Up Test")
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

    @Test(description = "1.01 Test registration pop-up with valid data")
    @Description("Test Description: Sign Up with correct data for fields: 'First Name','Last Name','Email','Password',Password Confirmation'")
    @Story("Positive test. Correct data for fields: 'First Name','Last Name','Email','Password',Password Confirmation'")
    public void RegisteredWithNotValidData() throws Exception {
        registrationPopUp.open();
        registrationPopUp.driverWaitPreloader();
        registrationPopUp.driverWait();
        registrationPopUp.clickSignUpLink();
        registrationPopUp.driverLinkWait();
        registrationPopUp.registrAs();
        registrationPopUp.registered();
        loginPopup.driverWaitPopup();
    }
}