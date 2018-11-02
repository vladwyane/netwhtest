package wh.Tests.PositiveTest;

import Page.ChangeInmatePopUp;
import Page.LoginPopup;
import Page.TrackOrderPage;
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
@Epic("Change Inmate Tests")
@Feature("Change Inmate Test")
public class ChangeInmateTest extends BaseTest {
    private ChangeInmatePopUp changeInmatePopUp;
    private LoginPopup loginPopup;
    private Wait wait;

    @BeforeMethod
    public void initPageObjects() {
        changeInmatePopUp = new ChangeInmatePopUp(app.getDriver());
        loginPopup = new LoginPopup(app.getDriver());
        wait = new Wait(app.getDriver());
    }

    @Test(description = "Change Inmate")
    @Description("Test Description: Change Inmate")
    @Story("Positive test. Change Inmate")
    public void changeInmate(){
        loginPopup.open();
        wait.threadsSleepWait();
        loginPopup.driverWait();
        loginPopup.clickSignInLink();
        loginPopup.driverWaitElement();
        loginPopup.loginAs();
        loginPopup.checkOpenMainPage();

       changeInmatePopUp.openInmatePopUp();
       changeInmatePopUp.clickSelectBtn();
       changeInmatePopUp.checkOpenedPopUp();
    }
}