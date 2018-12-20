package Page;

import Utils.ConfigProperties;
import Utils.EnvironmentProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class AddCustomMusicPage extends BasePage {

    @FindBy(xpath = "//a[@href='#'][contains(text(),'ADD CUSTOM MUSIC')]")
    private WebElement addCustomMusicBtn;

    @FindBy(tagName = "h3")
    private WebElement title;

    @FindBy(xpath = "//div[1]/div/div/button")
    private WebElement addSelectedBtn;

    @FindBy(xpath = "//div[2]/div/div/footer/a")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//*[@id=\"song13\"]")
    private WebElement inputCheckBox;

    @FindBy(xpath = "//div/div/header/dl/dd[1]")
    private WebElement addedSong;

    @FindBy(xpath = "//header/div/div[2]/a")
    private WebElement miniCart;

    public AddCustomMusicPage(WebDriver driver) {
        super(driver);
    }

    public AddCustomMusicPage openAddCustomMusicPage(){
        addCustomMusicBtn.click();
        return new AddCustomMusicPage(driver);
    }

    public AddCustomMusicPage checkTitle(){
        checkText(title,"CUSTOM MUSIC STORE");
        return new AddCustomMusicPage(driver);
    }

    public AddCustomMusicPage selectSong(){
        inputCheckBox.click();
        return new AddCustomMusicPage(driver);
    }

    public AddCustomMusicPage checkCheckBoxStyle(){
        checHTMLAttribute(inputCheckBox,"disabled","disabled");
        return new AddCustomMusicPage(driver);
    }

    public AddCustomMusicPage addSelectedSongToDevice(){
        addSelectedBtn.click();
        return new AddCustomMusicPage(driver);
    }

    public AddCustomMusicPage checkAddedSong(){
        checkText(addedSong,"1");
        return new AddCustomMusicPage(driver);
    }

    public AddCustomMusicPage addDeviceToCart(){
        addToCartBtn.click();
        return new AddCustomMusicPage(driver);
    }

    public AddCustomMusicPage checkAddedDeviceToCart(){
        assertTrue(isElementPresent(miniCart));
        return new AddCustomMusicPage(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
        driver.get(EnvironmentProperties.getProperty("login.url"));
    }
}
