package Page;

import Data.ProjectData;
import Utils.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class RegistrationPopUp extends BasePage {

    @FindBy(xpath = "//a[@href='#'][contains(text(),'Create an Account')]")
    private WebElement registrLink;

    @FindBy(tagName = "h5")
    private WebElement title;

    @FindBy(xpath = "//*[@id=\"sign-up-first_name\"]")
    private WebElement firstNameField;

    @FindBy(xpath = "//*[@id=\"sign-up-last_name\"]")
    private WebElement lastNameField;

    @FindBy(xpath = "//*[@id=\"sign-up-email\"]")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"sign-up-password\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"sign-up-password_confirmation\"]")
    private WebElement confirmPassword;

    @FindBy(xpath = "//form/div[5]/input")
    private WebElement signUpBtn;

    @FindBy(xpath = "//div[7]/div[3]")
    private WebElement searchInmate;

    @FindBy(xpath = "//a[@href='/account']")
    private WebElement myAccount;

    @FindBy(xpath = "//p[contains(text(),'The email field must be a valid email.')]")
    private WebElement emailVaidMessage;

    @FindBy(xpath = "//p[contains(text(),'The password field must be at least 8 characters.')]")
    private WebElement passwordValidMessage;

    @FindBy(xpath = "//p[contains(text(),'The password field must be at least 8 characters.')]")
    private WebElement confirmPasswordValidMessage;

    @FindBy(xpath = "//p[contains(text(),'The First Name field is required.')]")
    private WebElement checkEmptyFirstName;

    @FindBy(xpath = "//p[contains(text(),'The Last Name field is required.')]")
    private WebElement checkEmptyLastName;

    @FindBy(xpath = "//p[contains(text(),'The email field is required.')]")
    private WebElement checkEmptyEmail;

    @FindBy(xpath = "//p[contains(text(),'The password field is required.')]")
    private WebElement checkEmptyPassword;

    @FindBy(xpath = "//p[contains(text(),'The password field is required.')]")
    private WebElement checkEmptyConfirmPassword;

    public RegistrationPopUp(WebDriver driver) {
        super(driver);
    }


    public RegistrationPopUp checkTitle() {
        String str = title.getText();
        Assert.assertEquals(str, "Register");
        return new RegistrationPopUp(driver);
    }

    public RegistrationPopUp clickSignUpLink() {
        registrLink.click();
        return new RegistrationPopUp(driver);
    }

    public RegistrationPopUp registered(){
        assertTrue(isElementPresent(myAccount));
        return new RegistrationPopUp(driver);
    }

    public RegistrationPopUp checkValidation(){
        assertTrue(isElementPresent(emailVaidMessage));
        assertTrue(isElementPresent(passwordValidMessage));
        assertTrue(isElementPresent(confirmPasswordValidMessage));
        return new RegistrationPopUp(driver);
    }

    public RegistrationPopUp checkEmptyValidMessage(){
        assertTrue(isElementPresent(checkEmptyFirstName));
        assertTrue(isElementPresent(checkEmptyLastName));
        assertTrue(isElementPresent(checkEmptyEmail));
        assertTrue(isElementPresent(checkEmptyPassword));
        assertTrue(isElementPresent(checkEmptyConfirmPassword));
        return new RegistrationPopUp(driver);
    }

    public RegistrationPopUp registrAs() {
        type(firstNameField, ProjectData.ValidRegisterFirstName);
        type(lastNameField, ProjectData.ValidRegisterLastName);
        type(email, ProjectData.ValidRegisterEmail);
        type(password, ProjectData.ValidRegisterPassword);
        type(confirmPassword, ProjectData.ValidRegisterConfirmPassword);
        clickSignUpBtn();
        return PageFactory.initElements(driver, RegistrationPopUp.class);
    }

    public RegistrationPopUp registrAsWithNotValidData() {
        type(firstNameField, ProjectData.NotValidRegisterFirstName);
        type(lastNameField, ProjectData.NotValidRegisterLastName);
        type(email, ProjectData.NotValidRegisterEmail);
        type(password, ProjectData.NotValidRegisterPassword);
        type(confirmPassword, ProjectData.NotValidRegisterConfirmPassword);
        clickSignUpBtn();
        return PageFactory.initElements(driver, RegistrationPopUp.class);
    }

    public RegistrationPopUp clickSignUpBtn(){
        signUpBtn.click();
        return PageFactory.initElements(driver, RegistrationPopUp.class);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
    }

    public void driverWait() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#'][contains(text(),'Create an Account')]")));
    }
}