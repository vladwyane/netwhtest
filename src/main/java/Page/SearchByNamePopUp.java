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
import org.openqa.selenium.Keys;

import static org.testng.Assert.assertTrue;

public class SearchByNamePopUp extends BasePage {

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

    public SearchByNamePopUp(WebDriver driver) {

        super(driver);
    }

    @Step("Click 'Search by name' link")
    public void clickSearchByNameLink() {
        searcByNameLink.click();
    }

    @Step("Click 'Search' button")
    public SearchByNamePopUp clickSearchByNameBtn() {
        searchNameBtn.click();
        return new SearchByNamePopUp(driver);
    }

    @Step("Check 'Search by Inmate Name' pop-up is displayed")
    public SearchByNamePopUp checkChooseInmateIsDisplayed() {
        assertTrue(isElementPresent(chooseInmatePopUp));
        return new SearchByNamePopUp(driver);
    }

    @Step("Fill 'Choose state' field")
    public SearchByNamePopUp fillInmateNameForm() {
        chooseStateField.click();
        inputField.sendKeys("Arizona");
        inputField.sendKeys(Keys.ENTER);
        return new SearchByNamePopUp(driver);
    }

    @Step("Check changed HTML attribute 'aria-hidden = true' for field 'Choose state'")
    public SearchByNamePopUp checkAtributeState() {
        checHTMLAttribute(errorMessageStateField, "aria-invalid", "true");
        return new SearchByNamePopUp(driver);
    }

    @Step("Check changed HTML attribute 'aria-hidden = true' for field 'First name' field")
    public SearchByNamePopUp checkAtributeFirstName() {
        checHTMLAttribute(firstNameField, "aria-invalid", "true");
        return new SearchByNamePopUp(driver);
    }

    @Step("Check changed HTML attribute 'aria-hidden = true' for field 'Last name' field")
    public SearchByNamePopUp checkAtributeLastName() {
        checHTMLAttribute(lastNameField, "aria-invalid", "true");
        return new SearchByNamePopUp(driver);
    }

    @Step("Fill all required fields")
    public SearchByNamePopUp searchInmateByName() {
        fillInmateNameForm();
        type(firstNameField, SearchInmate.SEARCH_INMATE.getFirstName());
        type(lastNameField, SearchInmate.SEARCH_INMATE.getLastName());
        clickSearchByNameBtn();
        return PageFactory.initElements(driver, SearchByNamePopUp.class);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
        // driver.get(EnvironmentProperties.getProperty("login.url"));
    }

    public void driverWaitPreloader() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//main/div[2]/div/div/div[1]")));
    }

    public void driverWait() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form//div[2]/a")));
    }

    public void driverWaitElement() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[7]//form/div[4]/input")));
    }

    public void draiverWaitButton() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[7]//form/div[4]/input")));
    }
}