package wh.Tests.NegativeTest;

import Page.LandingPage;
import Page.LoginPopup;
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
@Feature("Search by Inmate ID")
public class SearchByIdTest extends BaseTest {
    private LandingPage landingPage;
    private Wait wait;

    @BeforeMethod
    public void initPageObjects() {
        landingPage = new LandingPage(app.getDriver());
        wait = new Wait(app.getDriver());
    }

    @Test(description = "4.01 Test search by inmate id pop-up with empty data")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: 'Search by Inmate ID' pop-up test with empty field 'Inmate ID'")
    @Story("Negative test. Empty field 'Inmate ID'")
    public void searchInmateById() throws Exception {
        landingPage.open();
        wait.threadsSleepWait();
        landingPage.driverWait();
        landingPage.clickSearchBtn();
        landingPage.checkAtribute();
    }
}