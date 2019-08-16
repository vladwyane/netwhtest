package wh.Tests.PositiveTest;

import Page.TrackOrderPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import wh.Tests.TestBase.BaseTest;

@Listeners({TestListenerAdapter.class})
@Epic("Change Package Tests")
@Feature("Change Package Test")
public class TrackOrderTest extends BaseTest {

    private TrackOrderPage trackOrderPage;

    @BeforeMethod
    public void initPageObjects() {
        trackOrderPage = new TrackOrderPage(app.getDriver());
    }

    @Test(description = "18.01 Test track order with UPS shipping method")
    @Description("Test Description: Check Track order with UPS Shipping method")
    @Story("Positive test. Correct order number and Inmate ID")
    public void TrackOrderUPS() throws Exception {
        trackOrderPage.open();
        trackOrderPage.driverWaitPreloader();
        trackOrderPage.openTrackOrderPage();
        trackOrderPage.fillFieldsUPS();
        trackOrderPage.clickSearchBtn();
        trackOrderPage.clickTrackorderPopUpLink();
        trackOrderPage.driverWaitTrackPopUp();
        trackOrderPage.checkUPSPopUp();
    }

    @Test(description = "18.02 Test track order with GSO shipping method")
    @Description("Test Description: Check Track order with GSO Shipping method")
    @Story("Positive test. Correct order number and Inmate ID")
    public void TrackOrderGSO() throws Exception {
        trackOrderPage.open();
        trackOrderPage.driverWaitPreloader();
        trackOrderPage.openTrackOrderPage();
        trackOrderPage.fillFieldsGSO();
        trackOrderPage.clickSearchBtn();
        trackOrderPage.clickTrackorderPopUpLink();
        trackOrderPage.driverWaitTrackPopUp();
        trackOrderPage.checkGSOPopUp();
    }
}