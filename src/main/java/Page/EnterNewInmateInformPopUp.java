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

import static org.testng.Assert.assertTrue;

public class EnterNewInmateInformPopUp extends BasePage {

    @FindBy(xpath = "//form/a[contains(text(),'or enter new inmate information')]")
    private WebElement enterNewInmateInformationLink;

    @FindBy(xpath = "//*[@id=\"inmate-info-first_name\"]")
    private WebElement firstNameField;

    @FindBy(xpath = "//*[@id=\"inmate-info-last_name\"]")
    private WebElement lastNameField;

    @FindBy(xpath = "//*[@id=\"inmate-info-inmate_number\"]")
    private WebElement inmateIdfield;

    @FindBy(xpath = "//*[@id=\"inmate-info-housing_unit\"]")
    private WebElement houseUnitField;

    @FindBy(xpath = "//form/div[3]/span")
    private WebElement stateField;

    @FindBy(xpath = "//form/div[4]/span")
    private WebElement cityField;

    @FindBy(xpath = "//*[@id=\"select2-inmate-info-facility_id-container\"]")
    private WebElement facilityField;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement inputField;

    @FindBy(xpath = "//div[8]/form/div[6]/input")
    private WebElement saveBtn;

    @FindBy(xpath = "//div[7]/div[7]")
    private WebElement selectPackagePopUp;

    @FindBy(xpath = "//p[contains(text(),'The first_name field is required.')]")
    private WebElement firstNameErrorMessage;

    @FindBy(xpath = "//p[contains(text(),'The last_name field is required.')]")
    private WebElement lastNameErrorMessage;

    @FindBy(xpath = "//p[contains(text(),'The state_id field is required.')]")
    private WebElement stateErrorMessage;

    @FindBy(xpath = "//p[contains(text(),'The facility_id field is required.')]")
    private WebElement facilityErrorMessage;

    public EnterNewInmateInformPopUp(WebDriver driver) {
        super(driver);
    }

    public EnterNewInmateInformPopUp clickEnterNewInmateLink() {
        enterNewInmateInformationLink.click();
        return new EnterNewInmateInformPopUp(driver);
    }

    public EnterNewInmateInformPopUp checkFirstNameValidationMessages() {
        assertTrue(isElementPresent(firstNameErrorMessage));
        return new EnterNewInmateInformPopUp(driver);
    }

    public EnterNewInmateInformPopUp checkLastNameValidationMessages() {
        assertTrue(isElementPresent(lastNameErrorMessage));
        return new EnterNewInmateInformPopUp(driver);
    }

    public EnterNewInmateInformPopUp checkStateValidationMessages() {
        assertTrue(isElementPresent(stateErrorMessage));
        return new EnterNewInmateInformPopUp(driver);
    }

    public EnterNewInmateInformPopUp checkFacilityValidationMessages() {
        assertTrue(isElementPresent(facilityErrorMessage));
        return new EnterNewInmateInformPopUp(driver);
    }

    public EnterNewInmateInformPopUp clickSaveBtn() {
        saveBtn.click();
        return new EnterNewInmateInformPopUp(driver);
    }

    public EnterNewInmateInformPopUp selectState() {
        stateField.click();
        inputField.sendKeys("Arizona");
        inputField.sendKeys(Keys.ENTER);
        return new EnterNewInmateInformPopUp(driver);
    }

    public EnterNewInmateInformPopUp selectCity() {
        cityField.click();
        inputField.sendKeys("Phoenix");
        inputField.sendKeys(Keys.ENTER);
        return new EnterNewInmateInformPopUp(driver);
    }

    public EnterNewInmateInformPopUp selectFacility() {
        facilityField.click();
        inputField.sendKeys("Phoeix facility");
        inputField.sendKeys(Keys.ENTER);
        return new EnterNewInmateInformPopUp(driver);
    }

    public EnterNewInmateInformPopUp checkPackagePopUp() {
        assertTrue(isElementPresent(selectPackagePopUp));
        return new EnterNewInmateInformPopUp(driver);
    }

    public EnterNewInmateInformPopUp fillNewInmateForm() {
        selectState();
        selectCity();
        selectFacility();
        type(firstNameField, ProjectData.NewInmateFirstName);
        type(lastNameField, ProjectData.NewInmateLastName);
        type(inmateIdfield, ProjectData.NewInmateID);
        type(houseUnitField, ProjectData.NewHousingUnit);
        clickSaveBtn();
        return PageFactory.initElements(driver, EnterNewInmateInformPopUp.class);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
    }

    public void driverWait() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#'][contains(text(),'Sign In')]")));
    }

    public void driverElementWait() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/a[contains(text(),'or enter new inmate information')]")));
    }
}
