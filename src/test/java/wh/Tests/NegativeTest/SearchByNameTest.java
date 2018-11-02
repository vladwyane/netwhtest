package wh.Tests.NegativeTest;

import Page.LandingPage;
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
@Feature("Search by Inmate Name")
public class SearchByNameTest extends BaseTest {
    private SearchByNamePopUp searchByNamePopUp;
    private Wait wait;

    @BeforeMethod
    public void initPageObjects() {
        searchByNamePopUp = new SearchByNamePopUp(app.getDriver());
        wait = new Wait(app.getDriver());
    }

    @Test(description = "4.04 Test Search by name pop-up with empty data")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: 'Search by Inmate Name' pop-up test with empty fields 'Choose state','First Name','Last Name'")
    @Story("Negative test. Empty fields 'Choose state','First Name','Last Name'")
    public void searchInmateByNameWithEmptyData() throws Exception {
        searchByNamePopUp.open();
        wait.threadsSleepWait();
        searchByNamePopUp.driverWait();
        searchByNamePopUp.clickSearchByNameLink();
        searchByNamePopUp.driverWaitElement();
        searchByNamePopUp.clickSearchByNameBtn();
        wait.threadsSleepWait();
        searchByNamePopUp.checkAtributeState();
        searchByNamePopUp.checkAtributeFirstName();
        searchByNamePopUp.checkAtributeLastName();
    }
}