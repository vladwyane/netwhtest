package Page;

import Data.CustomMusicStoreData.CustomMusicData;
import Utils.ConfigProperties;
import Utils.EnvironmentProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class CustomMusicStorePage extends BasePage {

    @FindBy(xpath = "//div[1]/div/div[2]/form/div/input[1]")
    private WebElement searchField;

    @FindBy(xpath = "//div/div[2]/form/div/input[2]")
    private WebElement searchBtn;

    @FindBy(xpath = "//div/div[3]/div[1]/h4")
    private WebElement resultsTitle;

    @FindBy(xpath = "//div[3]/div[2]/div/ul/li[1]")
    private WebElement cdTab;

    @FindBy(xpath = "//div[3]/div[2]/div/ul/li[2]")
    private WebElement MP3Tab;

    @FindBy(xpath = "//div[3]/div[2]/div/ul/li[3]")
    private WebElement tabletTab;

    @FindBy(xpath = "//a[@href][contains(text(),'ADD TO CART')]")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//div[1]/div/div[3]/div[1]/div[2]/div/button")
    private WebElement addSelectedSongs;

    @FindBys({
            @FindBy(xpath = "//*[@id=\"song79\"]"),
            @FindBy(xpath = "//*[@id=\"song78\"]"),
            @FindBy(xpath = "//*[@id=\"song83\"]")
    })
    private List<WebElement> MultipleSongItems;

    public CustomMusicStorePage(WebDriver driver) {
        super(driver);
    }

    public CustomMusicStorePage getElement() {
        WebElement elem = MultipleSongItems.get(1);
        elem.click();
        return new CustomMusicStorePage(driver);
    }

    public CustomMusicStorePage checkDisableCheckbox(){
        WebElement elem = MultipleSongItems.get(1);
        checHTMLAttribute(elem,"disabled","disabled");
        return new CustomMusicStorePage(driver);
    }

    public CustomMusicStorePage searchSongs() {
        type(searchField, CustomMusicData.SONG_NAME.getSongName());
        searchBtn.click();
        return new CustomMusicStorePage(driver);
    }

    public CustomMusicStorePage chooseCDTab() {
        cdTab.click();
        checkText(addSelectedSongs, "ADD SELECTED SONGS TO CUSTOM CD");
        return new CustomMusicStorePage(driver);
    }

    public CustomMusicStorePage chooseMP3Tab() {
        MP3Tab.click();
        checkText(addSelectedSongs, "ADD SELECTED SONGS TO MP3 PLAYER");
        return new CustomMusicStorePage(driver);
    }

    public CustomMusicStorePage chooseTabletTab() {
        tabletTab.click();
        checkText(addSelectedSongs, "ADD SELECTED SONGS TO TABLET");
        return new CustomMusicStorePage(driver);
    }

    public CustomMusicStorePage checkResults() {
        checkText(resultsTitle, "SEARCH RESULTS:");
        return new CustomMusicStorePage(driver);
    }

    public CustomMusicStorePage addToCartSong() {
        getElement();
        addSelectedSongs.click();
        return new CustomMusicStorePage(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
       // driver.get(EnvironmentProperties.getProperty("login.url"));
    }
}
