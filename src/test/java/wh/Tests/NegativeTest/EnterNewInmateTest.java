package wh.Tests.NegativeTest;

import Page.EnterNewInmateInformPopUp;
import Page.MainPage;
import Page.SearchByNamePopUp;
import Utils.Wait;
import io.qameta.allure.*;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import wh.Tests.TestBase.BaseTest;

@Listeners({TestListenerAdapter.class})
@Epic("Regresion Tests")
@Feature("Enter new inmate")
public class EnterNewInmateTest extends BaseTest {
    private EnterNewInmateInformPopUp enterNewInmateInformPopUp;
    private SearchByNamePopUp searchByNamePopUp;
    private MainPage homePage;
    private Wait wait;

    @BeforeMethod
    public void initPageObjects() {
        enterNewInmateInformPopUp = new EnterNewInmateInformPopUp(app.getDriver());
        searchByNamePopUp = new SearchByNamePopUp(app.getDriver());
        homePage = new MainPage(app.getDriver());
        wait = new Wait(app.getDriver());
    }

    @Test(description = "4.06 Test Create new Inmate pop-up with empty fields")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Check error messages for empty fields")
    @Story("Negative test. Empty fields")
    public void EnterNewInmateEmptyFields() throws Exception {
        homePage.open();
        searchByNamePopUp.clickSearchByNameLink();
        enterNewInmateInformPopUp.clickEnterNewInmateLink();
        enterNewInmateInformPopUp.clickSaveBtn();
        enterNewInmateInformPopUp.checkErrorMessages();
    }
}