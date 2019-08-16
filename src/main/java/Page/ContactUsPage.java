package Page;

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

    @FindBy(tagName = "h5")
    private WebElement contactUsTitle;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement fieldFullName;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement fieldPhone;

    @FindBy(xpath = "//input[@id='message']")
    private WebElement fieldMessage;

    @FindBy(xpath = "//form//button[@value='send']")
    private WebElement sendBtn;

    @FindBy(xpath = "//input[@id='name']/following::p[@class='error-message'][1]")
    private WebElement nameErrorMessage;

    @FindBy(xpath = "//p[contains(text(),'The email field is required.')]")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//p[contains(text(),'The phone field is required.')]")
    private WebElement phoneErrorMessage;

    @FindBy(xpath = "//p[contains(text(),'The message field is required.')]")
    private WebElement mesErrorMessage;

    @FindBy(xpath = "//p[contains(text(),'The email field must be a valid email.')]")
    private WebElement incorrectMessageEmail;

    @FindBy(xpath = "//button[@type = 'submit' and @value = 'send']")
    private WebElement sendButton;

    public ContactUsPage(WebDriver driver){
        super(driver);
    }

    @Override
    public void open(){
        driver.get(ConfigProperties.getProperty("login.url"));
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
        checkText(incorrectMessageEmail,"The email field must be a valid email.");
        return new ContactUsPage(driver);
    }

    public ContactUsPage fillCorrectData() {
        type(fieldFullName, Data.ContactUsData.ContactUs.VALID.getName());
        type(fieldFullName, Data.ContactUsData.ContactUs.VALID.getEmail());
        type(fieldFullName, Data.ContactUsData.ContactUs.VALID.getPhone());
        type(fieldFullName, Data.ContactUsData.ContactUs.VALID.getMessage());
        return PageFactory.initElements(driver, ContactUsPage.class);
    }

    public ContactUsPage fillIncorrectData() {
        type(fieldFullName, Data.ContactUsData.ContactUs.INVALID.getName());
        type(fieldFullName, Data.ContactUsData.ContactUs.INVALID.getEmail());
        type(fieldFullName, Data.ContactUsData.ContactUs.INVALID.getPhone());
        type(fieldFullName, Data.ContactUsData.ContactUs.INVALID.getMessage());
        return PageFactory.initElements(driver, ContactUsPage.class);
    }

    public ContactUsPage checkErrorMessages(){
        checkText(nameErrorMessage, "The name field is required. d");
        checkText(emailErrorMessage, "The email field is required.");
        checkText(phoneErrorMessage, "The phone field is required.");
        checkText(mesErrorMessage, "The message field is required.");
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