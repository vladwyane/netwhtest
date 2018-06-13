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
import Data.ProjectData.*;

import static org.testng.Assert.assertTrue;

public class SearchByNamePopUp extends BasePage{

    @FindBy(xpath = "//form//div[2]/a")
    private WebElement searcByNameLink;

    @FindBy(xpath = "//*[@id=\"firstName\"]")
    private WebElement firstNameField;

    @FindBy(xpath = "//*[@id=\"lastName\"]")
    private WebElement lastNameField;

    @FindBy(xpath = "//div[2]/form/div[1]/div/span/span[1]/span")
    private WebElement chooseStateField;

    @FindBy(xpath = "//*[@id=\"popup-state2\"]")
    private WebElement errorMessageStateField;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement inputField;

    @FindBy(xpath = "//div[7]//form/div[4]/input")
    private WebElement searchNameBtn;

    @FindBy(xpath = "//div[7]/div[5]")
    private WebElement chooseInmatePopUp;

    public SearchByNamePopUp(WebDriver driver){
        super(driver);
    }

    public SearchByNamePopUp clickSearchByNameLink(){
        searcByNameLink.click();
        return new SearchByNamePopUp(driver);
    }

    public SearchByNamePopUp clickSearchByNameBtn(){
        searchNameBtn.click();
        return new SearchByNamePopUp(driver);
    }

    public SearchByNamePopUp checkChooseInmateIsDisplayed(){
        assertTrue(isElementPresent(chooseInmatePopUp));
        return new SearchByNamePopUp(driver);
    }

    public SearchByNamePopUp fillInmateNameForm() {
        chooseStateField.click();
        inputField.sendKeys("Arizona");
        inputField.sendKeys(Keys.ENTER);
        return new SearchByNamePopUp(driver);
    }

    public SearchByNamePopUp checkAtributeState(){
        String str = errorMessageStateField.getAttribute("aria-hidden");
        assertTrue(str.contains("true"));
        return new SearchByNamePopUp(driver);
    }

    public SearchByNamePopUp checkAtributeFirstName(){
        String str = firstNameField.getAttribute("aria-invalid");
        assertTrue(str.contains("true"));
        return new SearchByNamePopUp(driver);
    }

    public SearchByNamePopUp checkAtributeLastName(){
        String str = lastNameField.getAttribute("aria-invalid");
        assertTrue(str.contains("true"));
        return new SearchByNamePopUp(driver);
    }

    public SearchByNamePopUp searchInmateByName() {
        fillInmateNameForm();
        type(firstNameField, ProjectData.InmateFirstName);
        type(lastNameField, ProjectData.InmateLastName);
        clickSearchByNameBtn();
        return PageFactory.initElements(driver, SearchByNamePopUp.class);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
    }

    public void driverWait(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form//div[2]/a")));
    }

    public void driverWaitElement(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[7]//form/div[4]/input")));
    }
}