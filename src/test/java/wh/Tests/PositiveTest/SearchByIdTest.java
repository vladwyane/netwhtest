package wh.Tests.PositiveTest;

import Page.LandingPage;
import Page.LoginPopup;
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
@Feature("Search By Inmate ID Test")
public class SearchByIdTest extends BaseTest {

    private LandingPage landingPage;
    private Wait wait;

    @BeforeMethod
    public void initPageObjects() {
        landingPage = new LandingPage(app.getDriver());
        wait = new Wait(app.getDriver());
    }

    @Test(description = "4.01 Test search by inmate id pop-up with empty data")
    @Description("Test Description: Search By Inmate ID with right data")
    @Story("Positive test. Correct data for field: 'Inmate ID'")
    public void searchInmateById() throws Exception {
        landingPage.open();
        landingPage.driverWaitPreloader();
        landingPage.driverWait();
        landingPage.clickSearchBtn();
        landingPage.checkAtribute();
    }
}