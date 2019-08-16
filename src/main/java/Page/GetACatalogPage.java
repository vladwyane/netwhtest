package Page;

import Data.Header.GetACatalogData;
import Utils.ConfigProperties;
import Utils.EnvironmentProperties;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import static org.testng.Assert.assertTrue;

public class GetACatalogPage extends BasePage {

    @FindBy(xpath = "//a[@href='/catalogs']")
    private WebElement getACataloglink;

    @FindBy(tagName = "h3")
    private WebElement title;

    @FindBy(id = "nameOnCard1")
    private WebElement inputFullName;

    @FindBy(id = "Address3")
    private WebElement inputAddress;

    @FindBy(id = "nameOnCard2")
    private WebElement inputCity;

    @FindBy(xpath = "//form/div[6]/div/span/span[1]/span")
    private WebElement stateField;

    @FindBy(xpath = "//span[1]/input")
    private WebElement inputSearch;

    @FindBy(id = "Postal")
    private WebElement inputPostalZipCode;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement inputEmail;

    @FindBy(xpath = "//*[@id=\"Phone\"]")
    private WebElement inputPhone;

    @FindBy(xpath = "//span[1]/span//input")
    private WebElement catalogType;

    @FindBy(xpath = "//span/span[1]/span/ul/li/input")
    private WebElement typeCatalogValue;

    @FindBy(xpath = "//form/div[10]")
    private WebElement requetsCatalog;

    @FindBy(xpath = "//div[3]/div")
    private WebElement succesPopUp;

    @FindBy(xpath = "//div[4]/h5[contains(text(),'Request Confirmed')]")
    private WebElement popupTitle;

    @FindBy(xpath = "//p[contains(text(),'The full_name field is required.')]")
    private WebElement fullNameValidationMessage;

    @FindBy(xpath = "//p[contains(text(),'The address1 field is required.')]")
    private WebElement addressValidationMessage;

    @FindBy(xpath = "//p[contains(text(),'The city field is required.')]")
    private WebElement cityValidationMessage;

    @FindBy(xpath = "//p[contains(text(),'The state field is required.')]")
    private WebElement stateValidationMessage;

    @FindBy(xpath = "//p[contains(text(),'The zip_code field is required.')]")
    private WebElement zipValidationMessage;

    @FindBy(xpath = "//p[contains(text(),'The email field is required.')]")
    private WebElement emailValidationMessage;

    @FindBy(xpath = "//p[contains(text(),'The catalog_type field is required.')]")
    private WebElement catalogTypeValidationMessage;

    public GetACatalogPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click 'Get a Catalog' link")
    public GetACatalogPage clickGetACatalogLink() {
        getACataloglink.click();
        return new GetACatalogPage(driver);
    }

    @Step("Check 'Get A Catalog' title")
    public GetACatalogPage checkTitle() {
        checkText(title,"GET A CATALOG");
        return new GetACatalogPage(driver);
    }

    @Step("Fill field 'State'")
    public GetACatalogPage clickStateField() {
        fillDropDownField(stateField, inputSearch,"Arizona");
        return new GetACatalogPage(driver);
    }

    @Step("Fill field 'Catalog Type'")
    public GetACatalogPage chooseCatalog() {
        fillDropDownFieldWithSaveSelectedElem(catalogType,"TEST CATALOG");
        return new GetACatalogPage(driver);
    }

    @Step("Check Confirmed title for pop-up ")
    public GetACatalogPage checkPopUpTitle() {
        checkText(popupTitle,"Request Confirmed");
        return new GetACatalogPage(driver);
    }

    public GetACatalogPage scrollDownToVisibleElement() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollDownToVisibleElement", requetsCatalog);
        return new GetACatalogPage(driver);
    }

    @Step("Click 'Request' button")
    public GetACatalogPage clickRequestBtn() {
        requetsCatalog.click();
        return new GetACatalogPage(driver);
    }

    @Step("Check validation message for 'Full name' field")
    public GetACatalogPage checkFullNameMessage() {
        assertTrue(isElementPresent(fullNameValidationMessage));
        return new GetACatalogPage(driver);
    }

    @Step("Check validation message for 'Address1' field")
    public GetACatalogPage checkAddressMessage() {
        assertTrue(isElementPresent(addressValidationMessage));
        return new GetACatalogPage(driver);
    }

    @Step("Check validation message for 'City' field")
    public GetACatalogPage checkCityMessage() {
        assertTrue(isElementPresent(cityValidationMessage));
        return new GetACatalogPage(driver);
    }

    @Step("Check validation message for 'State' field")
    public GetACatalogPage checkStateMessage() {
        assertTrue(isElementPresent(stateValidationMessage));
        return new GetACatalogPage(driver);
    }

    @Step("Check validation message for 'Postal/Zip Code' field")
    public GetACatalogPage checkZipMessage() {
        assertTrue(isElementPresent(zipValidationMessage));
        return new GetACatalogPage(driver);
    }

    @Step("Check validation message for 'Email' field")
    public GetACatalogPage checkEmailMessage() {
        assertTrue(isElementPresent(emailValidationMessage));
        return new GetACatalogPage(driver);
    }

    @Step("Check validation message for 'Catalog Type' field")
    public GetACatalogPage checkCatalogTypeMessage() {
        assertTrue(isElementPresent(catalogTypeValidationMessage));
        return new GetACatalogPage(driver);
    }

    @Step("Fill all required fields")
    public GetACatalogPage fillCatalogForm() {
        type(inputFullName, GetACatalogData.VALIDDATA.getFullName());
        type(inputAddress, GetACatalogData.VALIDDATA.getAddress());
        type(inputCity, GetACatalogData.VALIDDATA.getCity());
        clickStateField();
        type(inputPostalZipCode, GetACatalogData.VALIDDATA.getPostalZipCode());
        type(inputEmail, GetACatalogData.VALIDDATA.getEmail());
        type(inputPhone, GetACatalogData.VALIDDATA.getPhoneNumber());
        scrollDownToVisibleElement();
        chooseCatalog();
        scrollDownToVisibleElement();
        requetsCatalog.click();
        return PageFactory.initElements(driver, GetACatalogPage.class);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
        //driver.get(EnvironmentProperties.getProperty("login.url"));
    }

    public void driverWaitPreloader(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//main/div[2]/div/div/div[1]")));
    }

    public void driverVisibleWait(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/catalogs']")));
    }

    public void driverWait() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/catalogs']")));
    }
}