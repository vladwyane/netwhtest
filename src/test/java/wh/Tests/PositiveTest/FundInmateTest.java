package wh.Tests.PositiveTest;

import Page.FundInmatePage;
import Utils.Wait;
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
@Epic("Fund Inmate Tests")
@Feature("Test 'Fund An Inmate Prepaid Account' page")
public class FundInmateTest extends BaseTest {

    private FundInmatePage fundInmatePage;
    private Wait wait;

    @BeforeMethod
    public void initPageObjects() {

        fundInmatePage = new FundInmatePage(app.getDriver());
        wait = new Wait(app.getDriver());
    }

    @Test(description = "19.01 Test sign in with valid data")
    @Description("Test Description: Sign In test with correct email and password")
    @Story("Positive test. Correct email and password")
    public void notLoggedInUserChooseAmount50() throws Exception{
        //Create New Account
        fundInmatePage.open();
        fundInmatePage.driverWaitPreloader();
        fundInmatePage.draiverWaitTitle();
        fundInmatePage.draiverWaitLink();
        fundInmatePage.openFundInmatePage();
        //Billing Information section
        fundInmatePage.checkTitle();
        fundInmatePage.draiverWaitAmount();
        fundInmatePage.chooseAmount100();
        fundInmatePage.fillBillingInformationUnregisterUser();
        fundInmatePage.clickContinueBtn();
        //Inmate Information section
        fundInmatePage.openSectionWait();
        fundInmatePage.checkOpenedInmateInformSection();
        fundInmatePage.clickSelectButton();
        fundInmatePage.displayPopUpWait();
        fundInmatePage.checkDisplaySearchByIDPopUp();
        fundInmatePage.chekSearchByInmateIDTitle();
        fundInmatePage.fillInmateIDField();
        fundInmatePage.clickSearchButton();
        fundInmatePage.clickSelectBtn();
        fundInmatePage.waitClickableContBtn();
        fundInmatePage.clickInmateContinueBtn();
        //Payment Information section
        fundInmatePage.openPaymentSectionWait();
        fundInmatePage.checkOpenedPaymentInformSection();
        fundInmatePage.fillPaymentForm();
        fundInmatePage.clickPaymentContinueBtn();
        //Order Review
        fundInmatePage.openOrderReviewSectionWait();
        fundInmatePage.checkOpenedOrderReviewSection();
        fundInmatePage.clickPlaceOrderBtn();
        fundInmatePage.openSuccesPageWait();
        fundInmatePage.checkSuccesPage();
    }
}
