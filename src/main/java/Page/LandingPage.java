package Page;

import Data.Inmate.SearchInmate;
import Utils.ConfigProperties;
import Utils.EnvironmentProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import static org.testng.Assert.assertTrue;

public class LandingPage extends BasePage {

    @FindBy(xpath = "//div[2]/h3[contains(text(),'get started!')]")
    private WebElement title;

    @FindBy(xpath = "//form//div[2]/input")
    private WebElement inputInmateId;

    @FindBy(xpath = "//form//div[3]/input")
    private WebElement searchBtn;

    @FindBy(xpath = "//div[2]/div[1]/form/div/div[2]/input")
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

    @Step("Click 'Search' button")
    public LandingPage clickSearchBtn() {
        searchBtn.click();
        return new LandingPage(driver);
    }

    @Step("Check Title 'Get Started'")
    public LandingPage checkTitle() {
        checkText(title,"GET STARTED!");
        return new LandingPage(driver);
    }

    @Step("Click 'Select' button for selected inmate")
    public LandingPage clickSelectBtn() {
        selectBtn.click();
        return new LandingPage(driver);
    }

    @Step("Check change HTML attribute 'aria-invalid= true'")
    public LandingPage checkAtribute(){
        checHTMLAttribute(inputInmateId,"aria-invalid","true");
        return new LandingPage(driver);
    }

    @Step("Fill 'Inmate ID' field")
    public LandingPage searchInmateById() {
        type(inputInmateId, SearchInmate.SEARCH_INMATE.getInmateID());
        clickSearchBtn();
        return PageFactory.initElements(driver, LandingPage.class);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
        driver.get(EnvironmentProperties.getProperty("login.url"));
    }

    public void driverWaitPreloader(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//main/div[2]/div/div/div[1]")));
    }

    public void driverWait() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form//div[2]/input")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form//div[2]/input")));
    }

    public void waitElement() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"select2-package-container\"]")));
    }
}