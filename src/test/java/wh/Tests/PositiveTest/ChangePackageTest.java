package wh.Tests.PositiveTest;

import Page.ChangeInmatePopUp;
import Page.LoginPopup;
import Page.MainPage;
import Page.PackagePopUp;
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
@Epic("Change Package Tests")
@Feature("Change Package Test")
public class ChangePackageTest extends BaseTest {

    private MainPage mainPage;
    private PackagePopUp packagePopUp;
    private Wait wait;

    @BeforeMethod
    public void initPageObjects() {
        mainPage = new MainPage(app.getDriver());
        packagePopUp = new PackagePopUp(app.getDriver());
        wait = new Wait(app.getDriver());
    }

    @Test(description = "Change Package")
    @Description("Test Description: Change package")
    @Story("Positive test. Change package")
    public void ChangePackage() throws Exception {
        mainPage.clickChangePackage();
        packagePopUp.driverWaitPopUp();
        packagePopUp.selectPackage();
        packagePopUp.driverWaitDivInfo();
        packagePopUp.checkDivInfo();
    }
}