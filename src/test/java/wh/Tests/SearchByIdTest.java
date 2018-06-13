package wh.Tests;

import Page.*;
import Utils.Wait;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SearchByIdTest extends BaseTest {
    private LandingPage landingPage = PageFactory.initElements(initDriver(), LandingPage.class);
    private Wait wait = PageFactory.initElements(initDriver(), Wait.class);

    @Test(description = "4.01 Test search by inmate id pop-up with empty data", priority = 1)
    public void searchInmateById() throws Exception {
        landingPage.open();
        wait.threadsSleepWait();
        landingPage.driverWait();
        landingPage.clickSearchBtn();
        landingPage.checkAtribute();
    }

    @Test(description = "4.03 Test search by inmate id pop-up with valid data", priority = 2)
    public void searchInmateByIdWithEmptyData() {
        landingPage.open();
        wait.threadsSleepWait();
        landingPage.driverWait();
        landingPage.searchInmateById();
        landingPage.checkPopUp();
    }
}