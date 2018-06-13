package wh.Tests;

import Page.EnterNewInmateInformPopUp;
import Page.SearchByNamePopUp;
import Utils.Wait;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class EnterNewInmateTest extends BaseTest {
    private EnterNewInmateInformPopUp enterNewInmateInformPopUp = PageFactory.initElements(initDriver(), EnterNewInmateInformPopUp.class);
    private SearchByNamePopUp searchByNamePopUp = PageFactory.initElements(initDriver(), SearchByNamePopUp.class);
    private Wait wait = PageFactory.initElements(initDriver(), Wait.class);

    @Test(description = "4.06 Test Create new Inmate pop-up with empty fields", priority = 1)
    public void EnterNewInmateEmptyFields() throws Exception {
        enterNewInmateInformPopUp.open();
        wait.threadsSleepWait();
        searchByNamePopUp.driverWait();
        searchByNamePopUp.clickSearchByNameLink();
        enterNewInmateInformPopUp.driverElementWait();
        enterNewInmateInformPopUp.clickEnterNewInmateLink();
        enterNewInmateInformPopUp.clickSaveBtn();
        enterNewInmateInformPopUp.checkFirstNameValidationMessages();
        enterNewInmateInformPopUp.checkLastNameValidationMessages();
        enterNewInmateInformPopUp.checkStateValidationMessages();
        enterNewInmateInformPopUp.checkFacilityValidationMessages();
    }

    @Test(description = "4.05 Test Create new Inmate pop-up", priority = 2)
    public void EnterNewInmate() throws Exception {
        enterNewInmateInformPopUp.open();
        wait.threadsSleepWait();
        searchByNamePopUp.driverWait();
        searchByNamePopUp.clickSearchByNameLink();
        enterNewInmateInformPopUp.driverElementWait();
        enterNewInmateInformPopUp.clickEnterNewInmateLink();
        enterNewInmateInformPopUp.fillNewInmateForm();
        enterNewInmateInformPopUp.checkPackagePopUp();
    }
}
