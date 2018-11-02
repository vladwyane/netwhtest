package wh.Tests.NegativeTest;

import Page.SearchByNamePopUp;
import Page.TrackOrderPage;
import Utils.Wait;
import io.qameta.allure.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import wh.Tests.TestBase.BaseTest;

@Listeners({TestListenerAdapter.class})
@Epic("Track Order Tests")
@Feature("Track Order Test")
public class TrackOrderTest extends BaseTest {

    private TrackOrderPage trackOrderPage;
    private Wait wait;

    @BeforeMethod
    public void initPageObjects() {
        trackOrderPage = new TrackOrderPage(app.getDriver());
        wait = new Wait(app.getDriver());
    }

    @Test(description = "18. Test search order with empty fields", priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Track order test with empty fields 'Search by Order Number' and 'Search by Inmate ID'")
    @Story("Negative test. Empty field 'Search by Order Number' and 'Search by Inmate ID'")
    public void searchOrderWithEmptyFields() throws Exception {
        trackOrderPage.open();
        wait.threadsSleepWait();
        trackOrderPage.draiverWaitLink();
        trackOrderPage.openTrackOrderPage();
        trackOrderPage.clickSearchBtn();
        trackOrderPage.checkDisplayOrderNumberErrorMessage();
        trackOrderPage.checkDisplayInmateIDErrorMessage();
    }
}