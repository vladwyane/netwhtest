package Page;

import Data.ProjectData;
import Utils.ConfigProperties;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class GetACatalogPage extends BasePage {

    @FindBy(xpath = "//a[@href='/catalogs']")
    private WebElement getACatalogLink;

    @FindBy(tagName = "h3")
    private WebElement title;

    @FindBy(id = "nameOnCard1")
    private WebElement inputFullName;

    @FindBy(id = "Address3")
    private WebElement inputAddress;

    @FindBy(id = "nameOnCard2")
    private WebElement inputCity;

    @FindBy(xpath = "//*[@id=\"select2-PersonalMessage2-container\"]")
    private WebElement stateField;

    @FindBy(xpath = "//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']")
    private WebElement inputSearch;

    @FindBy(id = "Postal")
    private WebElement inputPostalZipCode;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement inputEmail;

    @FindBy(xpath = "//*[@id=\"Phone\"]")
    private WebElement inputPhone;

    @FindBy(xpath = "//span[1]/span//input")
    private WebElement catalogType;

    @FindBy(xpath = "//*[@id=\"PersonalMessage\"]/option[1]")
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

    public GetACatalogPage clickGetACatalogLink() {
        getACatalogLink.click();
        return new GetACatalogPage(driver);
    }

    public GetACatalogPage checkTitle() {
        String str = title.getText();
        Assert.assertEquals(str, "GET A CATALOG");
        return new GetACatalogPage(driver);
    }

    public GetACatalogPage clickStateField() {
        stateField.click();
        inputSearch.sendKeys("Arizona");
        inputSearch.sendKeys(Keys.ENTER);
        return new GetACatalogPage(driver);
    }

    public GetACatalogPage chooseCatalog() {
        catalogType.click();
        catalogType.sendKeys("Test Catalog");
        catalogType.sendKeys(Keys.ENTER);
        return new GetACatalogPage(driver);
    }

    public GetACatalogPage checkPopUpTitle() {
        String str = popupTitle.getText();
        Assert.assertEquals(str, "Request Confirmed");
        return new GetACatalogPage(driver);
    }

    public GetACatalogPage scrollDownToVisibleElement() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollDownToVisibleElement", requetsCatalog);
        return new GetACatalogPage(driver);
    }

    public GetACatalogPage clickRequestBtn() {
        requetsCatalog.click();
        return new GetACatalogPage(driver);
    }

    public GetACatalogPage checkFullNameMessage() {
        assertTrue(isElementPresent(fullNameValidationMessage));
        return new GetACatalogPage(driver);
    }

    public GetACatalogPage checkAddressMessage() {
        assertTrue(isElementPresent(addressValidationMessage));
        return new GetACatalogPage(driver);
    }

    public GetACatalogPage checkCityMessage() {
        assertTrue(isElementPresent(cityValidationMessage));
        return new GetACatalogPage(driver);
    }

    public GetACatalogPage checkStateMessage() {
        assertTrue(isElementPresent(stateValidationMessage));
        return new GetACatalogPage(driver);
    }

    public GetACatalogPage checkZipMessage() {
        assertTrue(isElementPresent(zipValidationMessage));
        return new GetACatalogPage(driver);
    }

    public GetACatalogPage checkEmailMessage() {
        assertTrue(isElementPresent(emailValidationMessage));
        return new GetACatalogPage(driver);
    }

    public GetACatalogPage checkCatalogTypeMessage() {
        assertTrue(isElementPresent(catalogTypeValidationMessage));
        return new GetACatalogPage(driver);
    }

    public GetACatalogPage fillCatalogForm() {
        type(inputFullName, ProjectData.FullName);
        type(inputAddress, ProjectData.Address);
        type(inputCity, ProjectData.City);
        clickStateField();
        type(inputPostalZipCode, ProjectData.PostalZipCode);
        type(inputEmail, ProjectData.Email);
        type(inputPhone, ProjectData.PhoneNumber);
        scrollDownToVisibleElement();
        chooseCatalog();
        scrollDownToVisibleElement();
        requetsCatalog.click();
        return PageFactory.initElements(driver, GetACatalogPage.class);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
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