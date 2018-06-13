package Page;

import Data.ProjectData;
import Utils.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class LandingPage extends BasePage {

    @FindBy(xpath = "//div[2]/h3[contains(text(),'get started!')]")
    private WebElement title;

    @FindBy(xpath = "//form//div[2]/input")
    private WebElement inputInmateId;

    @FindBy(xpath = "//form//div[3]/input")
    private WebElement searchBtn;

    @FindBy(xpath = "/html/body/main/div[1]/div/div[1]/div[2]/div[1]/form/div/div[2]/input")
    private WebElement inputField;

    @FindBy(className = "popup-holder")
    private WebElement popUp;

    @FindBy(xpath = "//div[5]/ul/li/a")
    private WebElement selectBtn;


    @FindBy(xpath = "//div[7]/div[3]/input")
    private WebElement beginShoppingBtn;

    @FindBy(xpath = "//header/div")
    private WebElement header;

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public LandingPage clickSearchBtn() {
        searchBtn.click();
        return new LandingPage(driver);
    }

    public LandingPage checkTitle() {
        String str = title.getText();
        Assert.assertEquals(str, "GET STARTED!");
        return new LandingPage(driver);
    }

    public LandingPage clickSelectBtn() {
        selectBtn.click();
        return new LandingPage(driver);
    }

    public LandingPage checkHeader() {
        assertTrue(isElementPresent(header));
        return new LandingPage(driver);
    }

    public LandingPage checkPopUp() {
        assertTrue(isElementPresent(popUp));
        return new LandingPage(driver);
    }

    public LandingPage checkAtribute(){
        String str = inputInmateId.getAttribute("aria-invalid");
        assertTrue(str.contains("true"));
        return new LandingPage(driver);
    }

    public LandingPage searchInmateById() {
        type(inputInmateId, ProjectData.InmateID);
        clickSearchBtn();
        return PageFactory.initElements(driver, LandingPage.class);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
    }

    public void driverWait() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form//div[2]/input")));
    }

    public void waitElement() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"select2-package-container\"]")));
    }
}