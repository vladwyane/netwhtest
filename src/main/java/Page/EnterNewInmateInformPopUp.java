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

    @FindBy(xpath = "//form/a[contains(text(),'Enter Inmate Information')]")
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

    @FindBy(xpath = "//button[@value='Save']")
    private WebElement saveBtn;

    @FindBy(xpath = "//div[7]/div[7]")
    private WebElement selectPackagePopUp;

    @FindBy(xpath = "//input[@id='inmate-info-first_name']/following::p[@class='error-message'][1]")
    private WebElement firstNameErrorMessage;

    @FindBy(xpath = "//input[@id='inmate-info-last_name']/following::p[@class='error-message'][1]")
    private WebElement lastNameErrorMessage;

    @FindBy(xpath = "//input[@id='inmate-info-inmate_number']/following::p[@class='error-message'][1]")
    private WebElement inmateIDErrorMessage;

    @FindBy(xpath = "//select[@id='inmate-info-state_id']/following::p[@class='error-message'][1]")
    private WebElement stateErrorMessage;

    @FindBy(xpath = "//select[@id='inmate-info-facility_id']/following::p[@class='error-message'][1]")
    private WebElement facilityErrorMessage;

    public EnterNewInmateInformPopUp(WebDriver driver) {
        super(driver);
    }

    @Step("Opened 'Enter new Inmate' pop-up")
    public EnterNewInmateInformPopUp clickEnterNewInmateLink() {
        waitUntilElementWillBeClickable(enterNewInmateInformationLink);
        enterNewInmateInformationLink.click();
        return new EnterNewInmateInformPopUp(driver);
    }

    @Step("Check Error Messages")
    public EnterNewInmateInformPopUp checkErrorMessages(){
        softAssert.assertEquals(firstNameErrorMessage.getText(),"The first name field is required.");
        softAssert.assertEquals(lastNameErrorMessage.getText(),"The last name field is required.");
        softAssert.assertEquals(inmateIDErrorMessage.getText(),"The inmate ID field is required.");
        softAssert.assertEquals(stateErrorMessage.getText(),"The state field is required.");
        softAssert.assertEquals(facilityErrorMessage.getText(),"The facility field is required.");
        softAssert.assertAll();
        return new EnterNewInmateInformPopUp(driver);
    }

    @Step("Save new inmate")
    public EnterNewInmateInformPopUp clickSaveBtn() {
        waitUntilElementWillBeClickable(saveBtn);
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