package Page;

import Data.Order.OrderData;
import Data.Order.PaymentData;
import Utils.ConfigProperties;
import Utils.Wait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class CheckoutPage extends BasePage {

    private Wait wait = new Wait(driver);

    @FindBy(tagName = "h3")
    private WebElement checkoutTitle;

    @FindBy(xpath = "//span[@id='select2-addressBook-container']/strong")
    private WebElement addNewBillingInformField;

    @FindBy(xpath = "//*[@id=\"firstname\"]")
    private WebElement firstNameField;

    @FindBy(xpath = "//*[@id=\"lastname\"]")
    private WebElement lastNameField;

    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement cityField;

    @FindBy(xpath = "//*[@id=\"select2-country_id-container\"]")
    private WebElement countryField;

    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    private WebElement inputSearchField;

    @FindBy(xpath = "//*[@id=\"address1\"]")
    private WebElement streetAddressField;

    @FindBy(xpath = "//form//div//div[6]/div[1]/div/span/span[1]/span")
    private WebElement stateProvinceField;

    @FindBy(xpath = "//*[@id=\"zipcode\"]")
    private WebElement postalZipCode;

    @FindBy(xpath = "//a[@href='#'][contains(text(),'LOG OUT')]")
    private WebElement logOutBtn;

    @FindBy(xpath = "//form/div[2]/button")
    private WebElement continueBtn;

    @FindBy(xpath = "//ol/li[2]/div[1]/div")
    private WebElement inmateInformationTitle;

    @FindBy(xpath = "//ol/li[2]/div[2]/form/div[2]/button")
    private WebElement inmateInformContinueBtn;

    @FindBy(xpath = "//div/div[2]/ol/li[3]/div[1]/div")
    private WebElement shippingMethodTitle;

    @FindBy(xpath = "//*[contains(text(),'USPS PME')]")
    private WebElement upsGroundMethod;

    @FindBy(xpath = "//*[contains(text(),'UPS Ground (USD)')]")
    private WebElement uspsPMEMethod;

    @FindBy(xpath = "//div[2]/ol/li[3]/div[2]/form/button")
    private WebElement shippingMethodContinueBTN;

    @FindBy(xpath = "//div[2]/ol/li[4]/div[1]/div")
    private WebElement paymentInformationTitle;

    @FindBy(xpath = "//*[@id=\"payment_method_2\"]")
    private WebElement transactionExpress;

    @FindBy(xpath = "//*[@id=\"payment_method_3\"]")
    private WebElement moneyOrder;

    @FindBy(xpath = "//*[@id=\"select2-cardBook-container\"]")
    private WebElement cardField;

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

    @FindBy(xpath = "//div[2]/ol/li[4]/div[2]/div/form/button")
    private WebElement paymentMethodContinueBtn;

    @FindBy(xpath = "//ol/li[5]/div[1]/div")
    private WebElement orderReviewTitle;

    @FindBy(xpath = "//input[@id=\"terms\"]")
    private WebElement terms;

    @FindBy(xpath = "//*[@id=\"subscription\"]")
    private WebElement subscription;

    @FindBy(xpath = "//input[@value='place order']")
    private WebElement placeOrderBtn;

    @FindBy(xpath = "//h3[contains(text(),'Thank you for your purchase!')]")
    private WebElement succesTitle;

    @FindBy(xpath = "//*[@id=\"select2-addressBook-results\"]")
    private WebElement fieldNewAddress;

    @FindBy(xpath = "//strong[contains(text(),'Add new billing address')]")
    private WebElement addNewBillingInformationValue;

    @FindBy(xpath = "//strong[contains(text(),'Add new credit card')]")
    private WebElement addNewCreditCardValue;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check 'Checkout' page title")
    public CheckoutPage checkTitleCheckout() {
        checkText(checkoutTitle, "CHECKOUT");
        return new CheckoutPage(driver);
    }

    @Step("Fill 'Country' field")
    public CheckoutPage clickCountryField() {
        countryField.click();
        inputSearchField.sendKeys("United States");
        inputSearchField.sendKeys(Keys.ENTER);
        return new CheckoutPage(driver);
    }

    @Step("Fill 'State' field")
    public CheckoutPage clickStateField() {
        stateProvinceField.click();
        inputSearchField.sendKeys("Arizona");
        inputSearchField.sendKeys(Keys.ENTER);
        return new CheckoutPage(driver);
    }

    public CheckoutPage selectNewBillingInformation() {
        addNewBillingInformField.click();
        wait.threadsSleepWait();
        moveToAddNewAddress();
        wait.threadsSleepWait();
        addNewBillingInformationValue.click();
        return new CheckoutPage(driver);
    }

    @Step("Fill 'Billing information' form")
    public CheckoutPage fillBillingInformation() {
        type(firstNameField, OrderData.VALID_ORDER_DATA.getFirstName());
        type(lastNameField, OrderData.VALID_ORDER_DATA.getLastName());
        type(phoneNumberField, OrderData.VALID_ORDER_DATA.getPhoneNumber());
        type(cityField, OrderData.VALID_ORDER_DATA.getCity());
        clickCountryField();
        type(streetAddressField, OrderData.VALID_ORDER_DATA.getStreetAddress());
        clickStateField();
        type(postalZipCode, OrderData.VALID_ORDER_DATA.getPostalZip());
        return new CheckoutPage(driver);
    }

    @Step("Opened 'Inmate Information' section")
    public CheckoutPage clickContinueBtn() {
        continueBtn.click();
        return new CheckoutPage(driver);
    }

    public CheckoutPage checkInmateInformationTitle() {
        checkText(inmateInformationTitle, "INMATE INFORMATION");
        return new CheckoutPage(driver);
    }

    public CheckoutPage clickConinueBtnInmateInform() {
        inmateInformContinueBtn.click();
        return new CheckoutPage(driver);
    }

    public CheckoutPage checkShippingMethodTitle() {
        checkText(shippingMethodTitle, "SHIPPING METHOD");
        return new CheckoutPage(driver);
    }

    public CheckoutPage selectUpsShippingMethod() {
        upsGroundMethod.click();
        return new CheckoutPage(driver);
    }

    public CheckoutPage selectUspsShippingMethod() {
        uspsPMEMethod.click();
        return new CheckoutPage(driver);
    }

    public CheckoutPage clickShippingMethodContinueBtn() {
        shippingMethodContinueBTN.click();
        return new CheckoutPage(driver);
    }

    public CheckoutPage checkPaymentInformation() {
        checkText(paymentInformationTitle, "PAYMENT INFORMATION");
        return new CheckoutPage(driver);
    }

    public CheckoutPage clickMoneyOrder() {
        moneyOrder.click();
        return new CheckoutPage(driver);
    }

    public CheckoutPage clickTransactionExpress() {
        transactionExpress.click();
        return new CheckoutPage(driver);
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

    public CheckoutPage fillPaymentForm() {
        type(nameOnCardField, PaymentData.PAYMENT_DATA.getCardName());
        type(numberCardField, PaymentData.PAYMENT_DATA.getCardNumber());
        type(securityCodeField, PaymentData.PAYMENT_DATA.getSecurityCode());
        clickMonthField();
        clickYearField();
        return new CheckoutPage(driver);
    }

    public CheckoutPage clickPaymentmethodContinueBtn() {
        paymentMethodContinueBtn.click();
        return new CheckoutPage(driver);
    }

    public CheckoutPage checkOrderReviewTitle() {
        checkText(orderReviewTitle, "ORDER REVIEW");
        return new CheckoutPage(driver);
    }

    public CheckoutPage clickTermsCheckBox() {
        scrollDown();
        moveToElem(terms);
        return new CheckoutPage(driver);
    }

    public CheckoutPage clickSubscriptionCheckBox() {
        scrollDown();
        moveToElem(subscription);
        return new CheckoutPage(driver);
    }

    public CheckoutPage clickPlaceOrderBtn() {
        moveToElem(placeOrderBtn);
        return new CheckoutPage(driver);
    }

    public CheckoutPage checkSuccesTitle() {
        driverWaitThanks();
        checkText(succesTitle, "THANK YOU FOR YOUR PURCHASE!");
        return new CheckoutPage(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
    }

    public CheckoutPage moveToAddNewAddress() {
        moveToElem(addNewBillingInformField);
        moveToElem(addNewBillingInformationValue);
        return new CheckoutPage(driver);
    }

    public CheckoutPage moveToElemCard() {
        moveToElem(cardField);
        moveToElem(addNewCreditCardValue);
        return new CheckoutPage(driver);
    }

    public CheckoutPage scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollDownToVisibleElement", placeOrderBtn);
        return new CheckoutPage(driver);
    }

    public void driverElementWait() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@data-sub='Add new billing address']")));
    }

    public void driverWaitThanks() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3")));
    }
}