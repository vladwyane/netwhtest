package wh.Tests;

import Page.SearchByNamePopUp;
import Utils.Wait;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SearchByNameTest extends BaseTest {
    private SearchByNamePopUp searchByNamePopUp = PageFactory.initElements(initDriver(), SearchByNamePopUp.class);
    private Wait wait = PageFactory.initElements(initDriver(), Wait.class);

    @Test(description = "4.04 Test Search by name pop-up with empty data", priority = 1)
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

    @Test(description = "4.02 Test Search by name pop-up with valid data", priority = 2)
    public void searchInmateByName() throws Exception {
        searchByNamePopUp.open();
        wait.threadsSleepWait();
        searchByNamePopUp.driverWait();
        searchByNamePopUp.clickSearchByNameLink();
        searchByNamePopUp.driverWaitElement();
        searchByNamePopUp.searchInmateByName();
        searchByNamePopUp.checkChooseInmateIsDisplayed();
    }
}