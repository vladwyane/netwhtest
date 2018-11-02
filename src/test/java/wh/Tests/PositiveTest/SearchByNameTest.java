package wh.Tests.PositiveTest;

import Page.LoginPopup;
import Page.RegistrationPopUp;
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
@Feature("Search By Inmate Name Test")
public class SearchByNameTest extends BaseTest {

    private SearchByNamePopUp searchByNamePopUp;
    private Wait wait;

    @BeforeMethod
    public void initPageObjects() {
        searchByNamePopUp = new SearchByNamePopUp(app.getDriver());
        wait = new Wait(app.getDriver());
    }

    @Test(description = "4.02 Test Search by name pop-up with valid data")
    @Description("Test Description: Search By Inmate Name with right data")
    @Story("Positive test. Correct data for fields: 'Choose State', 'First Name','Last Name'")
    public void searchInmateByName() throws Exception {
        searchByNamePopUp.open();
        searchByNamePopUp.driverWaitPreloader();
        searchByNamePopUp.clickSearchByNameLink();
        searchByNamePopUp.driverWaitElement();
        searchByNamePopUp.searchInmateByName();
        searchByNamePopUp.checkChooseInmateIsDisplayed();
    }
}