package Page;

import Utils.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MusicStorePage extends BasePage {

    @FindBy(tagName = "h3")
    private WebElement musicStoreTitle;

    @FindBy(className = "style-music-list")
    private WebElement sortBy;

    @FindBy(xpath = "//a[contains(text(),'Rock')]")
    private WebElement rockLink;

    @FindBy(tagName = "h4")
    private WebElement title;

    @FindBy(xpath = "//div[1]/form/div/input[1]")
    private WebElement musicStoreSearchField;

    @FindBy(xpath = "//div[1]/form/div/input[2]")
    private WebElement musicStoreSearchBtn;

    @FindBy(xpath = "//a[@href='#'][contains(text(),'add to cart')]")
    private WebElement addToCartBtn;

    public MusicStorePage(WebDriver driver){
        super(driver);
    }

    public MusicStorePage checkMusicStoreTitle(){
        String str = musicStoreTitle.getText();
        Assert.assertEquals(str, "MUSIC STORE");
        return new MusicStorePage(driver);
    }

    public MusicStorePage clickRockLink(){
        rockLink.click();
        return new MusicStorePage(driver);
    }

    public MusicStorePage checkTitle(){
        String str = title.getText();
        Assert.assertEquals(str, "ROCK ALBUMS");
        return new MusicStorePage(driver);
    }

    public MusicStorePage sendSearchQuery(){
        musicStoreSearchField.sendKeys("Lube");
        return new MusicStorePage(driver);
    }

    public MusicStorePage clickSearchBtn(){
        musicStoreSearchBtn.click();
        return new MusicStorePage(driver);
    }

    public MusicStorePage clickAddToCartBtn(){
        addToCartBtn.click();
        return new MusicStorePage(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
    }
}
