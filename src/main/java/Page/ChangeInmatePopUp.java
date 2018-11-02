package Page;

import Utils.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class ChangeInmatePopUp extends BasePage {

    @FindBy(xpath = "//a[@href='#'][contains(text(),'Change')]")
    private WebElement changeInmateLink;

    @FindBy(xpath = "//div[3]/div/div[6]")
    private WebElement changeInmatePopUp;

    @FindBy(xpath = "//a[@href='#'][contains(text(),Search by inmate ID)]")
    private WebElement searchByIDLink;

    @FindBy(xpath = "//a[@href='#'][contains(text(),Search by Inmate Name)]")
    private WebElement searchByNameLink;

    @FindBy(tagName = "h5")
    private WebElement searchByIDTitle;

    @FindBy(xpath = "//a[@href='#'][contains(text(),'Select Package')]")
    private WebElement selectPackageBTN;

    @FindBy(xpath = "//main/div[3]/div")
    private WebElement openedPopUp;

    @FindBy(xpath = "//div[6]/ul/li[33]/a")
    private WebElement selectBtn;

    public ChangeInmatePopUp(WebDriver driver){
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
    }

    public ChangeInmatePopUp openInmatePopUp(){
        changeInmateLink.click();
        assertTrue(isElementPresent(changeInmatePopUp));
        return new ChangeInmatePopUp(driver);
    }

    public ChangeInmatePopUp clickSelectPackageBtn(){
        selectPackageBTN.click();
        return new ChangeInmatePopUp(driver);
    }

    public ChangeInmatePopUp checkOpenedPopUp()
    {
        assertTrue(isElementPresent(openedPopUp));
        return new ChangeInmatePopUp(driver);
    }

    public ChangeInmatePopUp clickSearchByIDLink(){
        searchByIDLink.click();
        return new ChangeInmatePopUp(driver);
    }

    public ChangeInmatePopUp checkTitleID(){
        checkText(searchByIDTitle,"Search by Inmate ID");
        return new ChangeInmatePopUp(driver);
    }

    public ChangeInmatePopUp clickSearchByNameLink(){
        searchByNameLink.click();
        return new ChangeInmatePopUp(driver);
    }

    public ChangeInmatePopUp checkTitleName(){
        checkText(searchByNameLink,"Search by Inmate Name");
        return new ChangeInmatePopUp(driver);
    }

    public ChangeInmatePopUp clickSelectBtn()
    {
        selectBtn.click();
        return new ChangeInmatePopUp(driver);
    }
}