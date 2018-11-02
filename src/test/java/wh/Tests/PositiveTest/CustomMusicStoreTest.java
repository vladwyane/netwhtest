package wh.Tests.PositiveTest;

import Page.CustomMusicStorePage;
import Page.MainPage;
import Page.PackagePopUp;
import Utils.Wait;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import wh.Tests.TestBase.BaseTest;

@Listeners({TestListenerAdapter.class})
@Epic("Custom Music Store Tests")
@Feature("Custom Music Store Test")
public class CustomMusicStoreTest extends BaseTest {

    private CustomMusicStorePage customMusicStorePage;

    @BeforeMethod
    public void initPageObjects() {
        customMusicStorePage = new CustomMusicStorePage(app.getDriver());
    }

    @Test
    public void CustomMusicStore() throws Exception {
        customMusicStorePage.open();
        customMusicStorePage.searchSongs();
        customMusicStorePage.checkResults();
        customMusicStorePage.getElement();
        customMusicStorePage.chooseTabletTab();
        customMusicStorePage.addToCartSong();
        customMusicStorePage.checkDisableCheckbox();
    }
}