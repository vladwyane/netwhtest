package Page;

import Data.Inmate.NewInmate;
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

public class EnterNewInmateInformPopUp extends BasePage {

    @FindBy(xpath = " //form/a[contains(text(),'Enter Inmate Information')]")
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

    @FindBy(xpath = "//span[1]/input")
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

    @Step("Opened 'Enter new Inmate' pop-up")
    public EnterNewInmateInformPopUp clickEnterNewInmateLink() {
        enterNewInmateInformationLink.click();
        return new EnterNewInmateInformPopUp(driver);
    }

    @Step("Check validation for 'First name' field")
    public EnterNewInmateInformPopUp checkFirstNameValidationMessages() {
        assertTrue(isElementPresent(firstNameErrorMessage));
        return new EnterNewInmateInformPopUp(driver);
    }

    @Step("Check validation for 'Last name' field")
    public EnterNewInmateInformPopUp checkLastNameValidationMessages() {
        assertTrue(isElementPresent(lastNameErrorMessage));
        return new EnterNewInmateInformPopUp(driver);
    }

    @Step("Check validation for 'State' field")
    public EnterNewInmateInformPopUp checkStateValidationMessages() {
        assertTrue(isElementPresent(stateErrorMessage));
        return new EnterNewInmateInformPopUp(driver);
    }

    @Step("Check validation for 'Facility' field")
    public EnterNewInmateInformPopUp checkFacilityValidationMessages() {
        assertTrue(isElementPresent(facilityErrorMessage));
        return new EnterNewInmateInformPopUp(driver);
    }

    @Step("Save new inmate")
    public EnterNewInmateInformPopUp clickSaveBtn() {
        saveBtn.click();
        return new EnterNewInmateInformPopUp(driver);
    }

    @Step("Select state")
    public EnterNewInmateInformPopUp selectState() {
        fillDropDownField(stateField,inputField,"Arizona");
        return new EnterNewInmateInformPopUp(driver);
    }

    @Step("Select city")
    public EnterNewInmateInformPopUp selectCity() {
        fillDropDownField(cityField,inputField,"Phoenix");
        return new EnterNewInmateInformPopUp(driver);
    }

    @Step("Select facility")
    public EnterNewInmateInformPopUp selectFacility() {
        fillDropDownField(facilityField,inputField,"Phoeix facility 2");
        return new EnterNewInmateInformPopUp(driver);
    }

    @Step("Verify that 'Package' pop-up")
    public EnterNewInmateInformPopUp checkPackagePopUp() {
        assertTrue(isElementPresent(selectPackagePopUp));
        return new EnterNewInmateInformPopUp(driver);
    }

    @Step("Fill 'Enter new inmate' form")
    public EnterNewInmateInformPopUp fillNewInmateForm() {
        selectState();
        selectCity();
        selectFacility();
        type(firstNameField, NewInmate.NEW_INMATE.getFirstName());
        type(lastNameField, NewInmate.NEW_INMATE.getLastName());
        type(inmateIdfield, NewInmate.NEW_INMATE.getInmateID());
        type(houseUnitField, NewInmate.NEW_INMATE.getHousingUnit());
        clickSaveBtn();
        return PageFactory.initElements(driver, EnterNewInmateInformPopUp.class);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
        //driver.get(EnvironmentProperties.getProperty("login.url"));
    }

    public void driverWait() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#'][contains(text(),'Sign In')]")));
    }

    public void driverElementWait() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/a[contains(text(),'Enter Inmate Information')]")));
    }
}