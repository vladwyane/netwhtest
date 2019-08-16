package wh.Tests.PositiveTest;

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
import Page.ContactUsPage;

@Listeners({TestListenerAdapter.class})
@Epic("Regresion Tests")
@Feature("Sign In Test")
public class ContactUsTest extends BaseTest {
    private ContactUsPage contactUs;
    private Wait wait;

    @BeforeMethod
    public void initPageObjects() {
        contactUs = new ContactUsPage(app.getDriver());
        wait = new Wait(app.getDriver());
    }

    @Test(description = "Send correct data from contact us form")
    @Description("Test Description: Send correct data from contact us form")
    @Story("Positive test. Send correct data from contact us form")
    public void correctDataContactUs()throws Exception{
        contactUs.open();
        contactUs.clickContactPage();
        contactUs.checkTitle();
        contactUs.fillCorrectData();
    }
}