package wh.Tests.PositiveTest;

import Page.EnterNewInmateInformPopUp;
import Page.MainPage;
import Page.PackagePopUp;
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
public class EnterNewInmateTest extends BaseTest {
    private EnterNewInmateInformPopUp enterNewInmateInformPopUp;
    private SearchByNamePopUp searchByNamePopUp;
    private Wait wait;

    @BeforeMethod
    public void initPageObjects() {
        enterNewInmateInformPopUp = new EnterNewInmateInformPopUp(app.getDriver());
        searchByNamePopUp = new SearchByNamePopUp(app.getDriver());
        wait = new Wait(app.getDriver());
    }

    @Test(description = "4.05 Test Create new Inmate pop-up")
    @Description("Test Description: Create new Inmate with valid data")
    @Story("Positive test. Correcte email for send email with links for change password")
    public void EnterNewInmate() throws Exception {
        enterNewInmateInformPopUp.open();
        wait.threadsSleepWait();
        searchByNamePopUp.driverWait();
        searchByNamePopUp.clickSearchByNameLink();
        enterNewInmateInformPopUp.driverElementWait();
        enterNewInmateInformPopUp.clickEnterNewInmateLink();
        enterNewInmateInformPopUp.fillNewInmateForm();
        enterNewInmateInformPopUp.checkPackagePopUp();
    }
}