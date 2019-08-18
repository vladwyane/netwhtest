package Page;

import Data.ContactUsData.ContactUs;
import Utils.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage extends BasePage {

    @FindBy(xpath = "//a[@href='/contact']")
    private WebElement contactUsLink;

    @FindBy(css = ".contact-form-holder-in h5")
    private WebElement contactUsTitle;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement fieldFullName;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement fieldPhone;

    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement fieldMessage;

    @FindBy(xpath = "//form//button[@value='send']")
    private WebElement sendBtn;

    @FindBy(xpath = "//input[@id='name']/following::p[@class='error-message'][1]")
    private WebElement nameErrorMessage;

    @FindBy(xpath = "//input[@id='email']/following::p[@class='error-message'][1]")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//input[@id='phone']/following::p[@class='error-message'][1]")
    private WebElement phoneErrorMessage;

    @FindBy(xpath = "//textarea[@id='message']/following::p[@class='error-message'][1]")
    private WebElement mesErrorMessage;

    @FindBy(xpath = "//button[@type = 'submit' and @value = 'send']")
    private WebElement sendButton;

    public ContactUsPage(WebDriver driver){
        super(driver);
    }

    @Override
    public void open(){
        driver.get(ConfigProperties.getProperty("contactUs.url"));
    }

    public ContactUsPage clickContactPage(){
        contactUsLink.click();
        return new ContactUsPage(driver);
    }

    public ContactUsPage checkTitle(){
        checkText(contactUsTitle,"SEND US YOUR FEEDBACK");
        return new ContactUsPage(driver);
    }

    public ContactUsPage clickSendBtn(){
        sendBtn.click();
        return new ContactUsPage(driver);
    }

    public ContactUsPage checkIncorrectEmailMessage(){
        softAssert.assertEquals(emailErrorMessage.getText(),"The email field must be a valid email.");
        softAssert.assertAll();
        return new ContactUsPage(driver);
    }

    public ContactUsPage fillCorrectData() {
        type(fieldFullName, Data.ContactUsData.ContactUs.VALID.getName());
        type(fieldFullName, Data.ContactUsData.ContactUs.VALID.getEmail());
        type(fieldFullName, Data.ContactUsData.ContactUs.VALID.getPhone());
        type(fieldFullName, Data.ContactUsData.ContactUs.VALID.getMessage());
        return PageFactory.initElements(driver, ContactUsPage.class);
    }

    public void fillContactForm(ContactUs contactUs) {
        type(fieldFullName, contactUs.getName());
        type(fieldEmail, contactUs.getEmail());
        type(fieldPhone, contactUs.getPhone());
        type(fieldMessage, contactUs.getMessage());
    }

    public ContactUsPage checkErrorMessages(){
        softAssert.assertEquals(contactUsTitle.getText(),"SEND US YOUR FEEDBACK");
        softAssert.assertEquals(nameErrorMessage.getText(),"The name field is required.");
        softAssert.assertEquals(emailErrorMessage.getText(),"The email field is required.");
        softAssert.assertEquals(phoneErrorMessage.getText(),"The phone field is required.");
        softAssert.assertEquals(mesErrorMessage.getText(),"The message field is required.");
        softAssert.assertAll();
        return new ContactUsPage(driver);
    }

    public void driverWaitContactUsLink() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[href='/contact']")));
    }

    public void driverWaitPreloader(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("circle-cutter")));
    }

    public GetACatalogPage scrollDownToVisibleElement() {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(scrollElementIntoMiddle, contactUsLink);
        return new GetACatalogPage(driver);
    }

}