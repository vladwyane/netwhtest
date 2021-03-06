package wh.Tests.NegativeTest;

import Data.ContactUsData.ContactUs;
import Page.ContactUsPage;
import Page.MainPage;
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
@Epic("Contact us test")
@Feature("Check Contact us form with incorrect data and with empty fields")
public class ContactUsTest extends BaseTest {
    private ContactUsPage contactUs;
    private MainPage homePage;
    private Wait wait;


    @BeforeMethod
    public void initPageObjects() {
        contactUs = new ContactUsPage(app.getDriver());
        homePage = new MainPage(app.getDriver());
        wait = new Wait(app.getDriver());
    }

    @Test(description = "Check error messages for emtpty field")
    @Description("Test Description: Click Send btm with empty fields in contact us form")
    @Story("Negative test. Test Description: Click Send btn with empty fields in contact us form")
    public void emptyFieldsContactUs()throws Exception{
        homePage.open();
        homePage.clickNavItemFooter("Contact Us");
        contactUs.clickSendBtn();
        contactUs.checkErrorMessages();
    }

    @Test(description = "Send incorrect data from contact us form")
    @Description("Test Description: Send incorrect data from contact us form")
    @Story("Negative test. Send incorrect data from contact us form")
    public void incorrectFieldsContactUs()throws Exception{
        contactUs.open();
        contactUs.fillContactForm(ContactUs.INVALID);
        contactUs.clickSendBtn();
        contactUs.checkIncorrectEmailMessage();
    }
}