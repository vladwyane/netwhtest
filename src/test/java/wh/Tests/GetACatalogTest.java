package wh.Tests;

import Page.GetACatalogPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Utils.Wait;

public class GetACatalogTest extends BaseTest {

    private GetACatalogPage getACatalogPage = PageFactory.initElements(initDriver(), GetACatalogPage.class);
    private Wait wait = PageFactory.initElements(initDriver(), Wait.class);

    @Test(description = "8.03 Test Get A Catalog page. Fill form Get a catalog with data", priority = 1)
    public void sendCatalog() throws Exception {
        getACatalogPage.open();
        wait.threadsSleepWait();
        getACatalogPage.driverVisibleWait();
        getACatalogPage.driverWait();
        getACatalogPage.clickGetACatalogLink();
        getACatalogPage.checkTitle();
        getACatalogPage.fillCatalogForm();
        getACatalogPage.checkPopUpTitle();
        getACatalogPage.scrollDownToVisibleElement();
    }

    @Test(description = "8.04 Test Get A Catalog page. Fill form Get a catalog without data", priority = 2)
    public void checkValidCatalog() throws Exception {
        getACatalogPage.open();
        wait.threadsSleepWait();
        getACatalogPage.driverVisibleWait();
        getACatalogPage.driverWait();
        getACatalogPage.clickGetACatalogLink();
        getACatalogPage.checkTitle();
        getACatalogPage.clickRequestBtn();
        getACatalogPage.checkFullNameMessage();
        getACatalogPage.checkAddressMessage();
        getACatalogPage.checkCityMessage();
        getACatalogPage.checkStateMessage();
        getACatalogPage.checkZipMessage();
        getACatalogPage.checkEmailMessage();
        getACatalogPage.checkCatalogTypeMessage();
        getACatalogPage.scrollDownToVisibleElement();
    }
}