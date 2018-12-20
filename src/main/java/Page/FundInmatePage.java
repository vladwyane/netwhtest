package Page;

import Data.Header.FundInmateUnregistered;
import Data.Order.OrderData;
import Data.Order.PaymentData;
import Utils.ConfigProperties;
import Utils.EnvironmentProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import static org.testng.Assert.assertTrue;

public class FundInmatePage extends BasePage {
    @FindBy(className = "dollar")
    private WebElement fundInmateLink;

    @FindBy(tagName = "h3")
    private WebElement signInTitle;

    @FindBy(xpath = "//form/label[1]")
    private WebElement amount50;

    @FindBy(xpath = "//form/label[2]")
    private WebElement amount100;

    @FindBy(xpath = "//form/label[3]")
    private WebElement amount150;

    @FindBy(xpath = "//form/label[4]")
    private WebElement amount200;

    @FindBy(xpath = "//form/label[5]")
    private WebElement amount300;

    @FindBy(xpath = "//form/label[6]")
    private WebElement amount500;

    @FindBy(xpath = "//div[3]/div/div[6]")
    private WebElement changeInmatePopUp;

    @FindBy(xpath = "//*[@id=\"other\"]")
    private WebElement amountOther;

    @FindBy(xpath = "//div[2]/div[2]/p")
    private WebElement otherErrorMessage;

    //BILLING INFORMATION SECTION
    @FindBy(xpath = "//div/div[2]/ol/li[1]/div[1]")
    private WebElement billingTitle;

    @FindBy(id = "firstname")
    private WebElement firstNameField;

    @FindBy(id = "lastname")
    private WebElement lastNameField;

    @FindBy(id = "phone")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//*[@id=\"select2-country_id-container\"]")
    private WebElement countryField;

    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    private WebElement inputSearchField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(xpath = "//form/div[1]/div[7]/div[1]/div/span/span[1]/span")
    private WebElement stateProvinceField;

    @FindBy(id = "address1")
    private WebElement addressField;

    @FindBy(xpath = "//*[@id=\"zipcode\"]")
    private WebElement postalZipCode;

    @FindBy(xpath = "//form/div[2]/button")
    private WebElement continueBillingBtn;

    //CREATE AN ACCOUNT
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "password_confirmation")
    private WebElement confirmPasswordField;

    //INMATE INFORMATION SECTION
    @FindBy(xpath = "//div[2]/ol/li[2]")
    private WebElement activeInmateInformationSection;

    @FindBy(xpath = "//form/div[2]/a")
    private WebElement changeBtn;

    @FindBy(xpath = "//div[2]/form/div[2]/a")
    private WebElement selectButton;

    @FindBy(xpath = "//div[3]/div/div[7]/div[3]")
    private WebElement searchByIDPopUp;

    @FindBy(xpath = "//div[7]/div[3]/h5")
    private WebElement searchByInmateIDTitle;

    @FindBy(id = "inmateid")
    private WebElement inmateIDField;

    @FindBy(xpath = "//div[3]/form/div[3]/input")
    private WebElement searchButton;

    @FindBy(xpath = "//div[7]/div[5]/ul/li/a")
    private WebElement selectBtn;

    @FindBy(xpath = "//li[2]/div[2]/form/div[2]/button")
    private WebElement continueInmateBtn;

    //PAYMENT INFORMATION SECTION
    @FindBy(xpath = "//div[2]/ol/li[3]")
    private WebElement activePaymentInformationSection;

    @FindBy(xpath = "//li[3]/div[2]/div/form/div[1]/div[1]/label")
    private WebElement inputStoreCredit;

    @FindBy(xpath = "//div[2]/div/span/span[1]/span")
    private WebElement selectField;

    @FindBy(id = "payment_method_3")
    private WebElement inputMoneyOrder;

    @FindBy(className = "secure-info")
    private WebElement secureInfo;

    @FindBy(xpath = "//*[@id=\"name_on_card\"]")
    private WebElement nameOnCardField;

    @FindBy(xpath = "//*[@id=\"card_number\"]")
    private WebElement numberCardField;

    @FindBy(xpath = "//*[@id=\"cvv\"]")
    private WebElement securityCodeField;

    @FindBy(xpath = "//*[@id=\"select2-expiration_month-container\"]")
    private WebElement month;

    @FindBy(xpath = "//*[@id=\"select2-expiration_year-container\"]")
    private WebElement year;

    @FindBy(xpath = "//div/form/button")
    private WebElement paymentMethodContinueBtn;

    //ORDER REVIEW SECTION
    @FindBy(xpath = "//div[2]/ol/li[4]")
    private WebElement activeOrderReviewSection;

    @FindBy(xpath = "//li[4]/div[2]/form/input")
    private WebElement placeOrderBtn;

    @FindBy(xpath = "//div[1]/div/div/h3")
    private WebElement successPageTitle;

    //VALID MESSAGE

    /*BILLING INFORMATION SECTION*/
    @FindBy(xpath = "//p[contains(text(),'The First Name field is required.')]")
    private WebElement firstNameMessgae;

    @FindBy(xpath = "//p[contains(text(),'The Last Name field is required.')]")
    private WebElement lastNameMessgae;

    @FindBy(xpath = "//p[contains(text(),'The email field is required.')]")
    private WebElement emailMessgae;

    @FindBy(xpath = "//p[contains(text(),'The phone field is required.')]")
    private WebElement phoneNumberMessgae;

    @FindBy(xpath = "//p[contains(text(),'The city field is required.')]")
    private WebElement cityMessgae;

    @FindBy(xpath = "//p[contains(text(),'The Street Address field is required.')]")
    private WebElement streetAddressMessgae;

    @FindBy(xpath = "//p[contains(text(),'The state field is required.')]")
    private WebElement stateProvinceMessgae;

    @FindBy(xpath = "//p[contains(text(),'The Zip Code field is required.')]")
    private WebElement postalZipCodeMessgae;

    @FindBy(xpath = "//p[contains(text(),'The password field is required.')]")
    private WebElement passwordMessgae;

    @FindBy(xpath = "//p[contains(text(),'The password_confirmation field is required.')]")
    private WebElement confirmPasswordMessgae;

    /*PAYMENT INFORMATION SECTION*/

    @FindBy(xpath = "//p[contains(text(),'The name_on_card field is required.')]")
    private WebElement cardNameMessgae;

    @FindBy(xpath = "//p[contains(text(),'The Card Number field is required.')]")
    private WebElement cardNumberMessage;

    @FindBy(xpath = "//p[contains(text(),'The cvv field is required.')]")
    private WebElement cvvCodeMessage;

    @FindBy(xpath = "//p[contains(text(),'The expiration_month field is required.')]")
    private WebElement monthDate;

    @FindBy(xpath = "//p[contains(text(),'The expiration_year field is required.')]")
    private WebElement yearDate;

    public FundInmatePage(WebDriver driver) {
        super(driver);
    }

    public FundInmatePage openFundInmatePage() {
        fundInmateLink.click();
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkTitle() {
        checkText(signInTitle, "INMATE'S WALKENHORST'S PREPAID ACCOUNT");
        return new FundInmatePage(driver);
    }

    public FundInmatePage chooseAmount50() {
        amount50.click();
        return new FundInmatePage(driver);
    }

    public FundInmatePage chooseAmount100() {
        amount100.click();
        return new FundInmatePage(driver);
    }

    public FundInmatePage chooseAmount150() {
        amount150.click();
        return new FundInmatePage(driver);
    }

    public FundInmatePage chooseAmount200() {
        amount200.click();
        return new FundInmatePage(driver);
    }

    public FundInmatePage chooseAmount300() {
        amount300.click();
        return new FundInmatePage(driver);
    }

    public FundInmatePage chooseAmount500() {
        amountOther.click();
        return new FundInmatePage(driver);
    }

    public FundInmatePage chooseAmountOther() {
        amountOther.click();
        return new FundInmatePage(driver);
    }

    public FundInmatePage enter1To0therField() {
        amountOther.sendKeys("1");
        return new FundInmatePage(driver);
    }

    public FundInmatePage enter1000To0therField() {
        amountOther.sendKeys("1000");
        return new FundInmatePage(driver);
    }

    @Step("Fill 'Country' field")
    public FundInmatePage clickCountryField() {
        countryField.click();
        inputSearchField.sendKeys("United States");
        inputSearchField.sendKeys(Keys.ENTER);
        return new FundInmatePage(driver);
    }

    @Step("Fill 'State' field")
    public FundInmatePage clickStateField() {
        stateProvinceField.click();
        inputSearchField.sendKeys("Arizona");
        inputSearchField.sendKeys(Keys.ENTER);
        return new FundInmatePage(driver);
    }

    public FundInmatePage fillBillingInformationUnregisterUser() {
        type(firstNameField, FundInmateUnregistered.VALID_ORDER_DATA.getFirstName());
        type(lastNameField, FundInmateUnregistered.VALID_ORDER_DATA.getLastName());
        type(emailField,FundInmateUnregistered.VALID_ORDER_DATA.getEmail());
        type(phoneNumberField, FundInmateUnregistered.VALID_ORDER_DATA.getPhoneNumber());
        type(cityField, FundInmateUnregistered.VALID_ORDER_DATA.getCity());
        clickCountryField();
        type(addressField, FundInmateUnregistered.VALID_ORDER_DATA.getStreetAddress());
        clickStateField();
        type(postalZipCode, FundInmateUnregistered.VALID_ORDER_DATA.getPostalZip());
        type(passwordField, FundInmateUnregistered.VALID_ORDER_DATA.getPassword());
        type(confirmPasswordField, FundInmateUnregistered.VALID_ORDER_DATA.getConfirmPassword());
        return new FundInmatePage(driver);
    }

    @Step("Opened 'Inmate Information' section")
    public FundInmatePage clickContinueBtn() {
        continueBillingBtn.click();
        return new FundInmatePage(driver);
    }

    @Step("Check HTML attribute is active")
    public FundInmatePage checkOpenedInmateInformSection() {
        checHTMLAttribute(activeInmateInformationSection, "class", "active");
        return new FundInmatePage(driver);
    }

    public FundInmatePage clickSelectButton(){
        selectButton.click();
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkDisplaySearchByIDPopUp(){
        assertTrue(isElementPresent(searchByIDPopUp));
        return new FundInmatePage(driver);
    }

    public FundInmatePage chekSearchByInmateIDTitle(){
        checkText(searchByInmateIDTitle,"Search by Inmate ID");
        return new FundInmatePage(driver);
    }

    public FundInmatePage fillInmateIDField(){
        type(inmateIDField,"AllowCodeInmate4");
        return new FundInmatePage(driver);
    }

    public FundInmatePage clickSearchButton(){
        searchButton.click();
        return new FundInmatePage(driver);
    }

    public FundInmatePage clickSelectBtn(){
        selectBtn.click();
        return new FundInmatePage(driver);
    }

    public FundInmatePage clickChangeBtn() {
        changeBtn.click();
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkDisplayedChangeInmatePopUp() {
        assertTrue(isElementPresent(changeInmatePopUp));
        return new FundInmatePage(driver);
    }

    public FundInmatePage clickInmateContinueBtn() {
        continueInmateBtn.click();
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkOpenedPaymentInformSection() {
        checHTMLAttribute(activePaymentInformationSection, "class", "active");
        return new FundInmatePage(driver);
    }

    public FundInmatePage clickMoneyOrderBtn() {
        inputMoneyOrder.click();
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkSelectField() {
        assertTrue(isElementPresent(selectField));
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkSecureInfo() {
        checkText(secureInfo, "Check Payment");
        return new FundInmatePage(driver);
    }

    public FundInmatePage clickStoreCreditBtn() {
        inputStoreCredit.click();
        return new FundInmatePage(driver);
    }

    public CheckoutPage clickMonthField() {
        month.click();
        inputSearchField.sendKeys("July");
        inputSearchField.sendKeys(Keys.ENTER);
        return new CheckoutPage(driver);
    }

    public CheckoutPage clickYearField() {
        year.click();
        inputSearchField.sendKeys("2022");
        inputSearchField.sendKeys(Keys.ENTER);
        return new CheckoutPage(driver);
    }

    public FundInmatePage fillPaymentForm() {
        type(nameOnCardField, PaymentData.PAYMENT_DATA.getCardName());
        type(numberCardField, PaymentData.PAYMENT_DATA.getCardNumber());
        type(securityCodeField, PaymentData.PAYMENT_DATA.getSecurityCode());
        clickMonthField();
        clickYearField();
        return new FundInmatePage(driver);
    }

    public FundInmatePage clickPaymentContinueBtn() {
        paymentMethodContinueBtn.click();
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkOpenedOrderReviewSection() {
        checHTMLAttribute(activeOrderReviewSection, "class", "active");
        return new FundInmatePage(driver);
    }

    public FundInmatePage clickPlaceOrderBtn() {
        placeOrderBtn.click();
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkSuccesPage() {
        checkText(successPageTitle, "THANK YOU FOR YOUR PURCHASE!");
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkFirstNameMessage() {
        checkText(firstNameMessgae, "The First Name field is required.");
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkLastNameMessage() {
        checkText(lastNameMessgae, "The Last Name field is required.");
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkEmailMessage() {
        checkText(emailMessgae, "The email field is required.");
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkPhoneNumberMessage() {
        checkText(phoneNumberMessgae, "The phone field is required.");
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkCityMessage() {
        checkText(cityMessgae, "The city field is required.");
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkStreetAddressMessage() {
        checkText(streetAddressMessgae, "The Street Address field is required.");
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkStateProvinceMessage() {
        checkText(stateProvinceMessgae, "The state field is required.");
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkPostalZipCodeMessage() {
        checkText(postalZipCodeMessgae, "The Zip Code field is required.");
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkPasswordMessage() {
        checkText(passwordMessgae, "The password field is required.");
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkConfirmPasswordMessage() {
        checkText(confirmPasswordMessgae, "The password_confirmation field is required.");
        return new FundInmatePage(driver);
    }

    /*PAYMENT INFORMATION SECTION*/
    public FundInmatePage checkCardNameMessage() {
        checkText(cardNameMessgae, "The name_on_card field is required.");
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkCardNumberMessage() {
        checkText(cardNumberMessage, "The Card Number field is required.");
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkCVVMessage() {
        checkText(cvvCodeMessage, "The cvv field is required.");
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkMonthMessage() {
        checkText(monthDate, "The expiration_month field is required.");
        return new FundInmatePage(driver);
    }

    public FundInmatePage checkYearMessage() {
        checkText(yearDate, "The expiration_year field is required.");
        return new FundInmatePage(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
        driver.get(EnvironmentProperties.getProperty("login.url"));
    }

    public void draiverWaitLink(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("dollar")));
    }

    public void driverWaitPreloader(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//main/div[2]/div/div/div[1]")));
    }

    public void draiverWaitAmount(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/label[2]")));
    }

    public void draiverWaitTitle(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
    }

    public void openSectionWait(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/form/div[2]/a")));
    }

    public void displayPopUpWait(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div/div[7]/div[3]")));
    }

    public void waitClickableContBtn(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//main/div[3]/div")));
    }

    public void openPaymentSectionWait(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[3]/div[2]/div/form/div[1]/div[1]/label")));
    }

    public void openOrderReviewSectionWait(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[4]/div[2]/form/input")));
    }

    public void openSuccesPageWait(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div/div/h4")));
    }
}