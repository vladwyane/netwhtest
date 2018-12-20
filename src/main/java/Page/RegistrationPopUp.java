package Page;

import Data.User.RegistrationData;
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

public class RegistrationPopUp extends BasePage {

    @FindBy(xpath = "//a[@href='#'][contains(text(),'Create an Account')]")
    private WebElement registrLink;

    @FindBy(tagName = "h5")
    private WebElement title;

    @FindBy(id = "sign-up-first_name")
    private WebElement firstNameField;

    @FindBy(id = "sign-up-last_name")
    private WebElement lastNameField;

    @FindBy(id = "sign-up-email")
    private WebElement email;

    @FindBy(id = "sign-up-password")
    private WebElement password;

    @FindBy(id = "sign-up-password_confirmation")
    private WebElement confirmPassword;

    @FindBy(xpath = "//div[5]/input")
    private WebElement signUpBtn;

    @FindBy(xpath = "//div[7]/div[3]")
    private WebElement searchInmate;

    @FindBy(xpath = "//a[@href='/account']")
    private WebElement myAccount;

    @FindBy(tagName = "h5")
    private WebElement searchByInmateIDTitle;

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

    @Step("Check 'Sign up' pop-up title")
    public RegistrationPopUp checkTitle() {
        checkText(title,"Register");
        return new RegistrationPopUp(driver);
    }

    public RegistrationPopUp clickSignupBtn(){
        signUpBtn.click();
        return new RegistrationPopUp(driver);
    }

    @Step("Click 'Create an Account' link")
    public RegistrationPopUp clickSignUpLink() {
        registrLink.click();
        return new RegistrationPopUp(driver);
    }

    @Step("Check 'Search by Inmate ID' pop-up is displayed")
    public RegistrationPopUp registered(){
        assertTrue(isElementPresent(searchByInmateIDTitle));
        return new RegistrationPopUp(driver);
}

    @Step("Check validation messages for fields 'Email','Password','Confirm Password' is displayed")
    public RegistrationPopUp checkValidation(){
        assertTrue(isElementPresent(emailVaidMessage));
        assertTrue(isElementPresent(passwordValidMessage));
        assertTrue(isElementPresent(confirmPasswordValidMessage));
        return new RegistrationPopUp(driver);
    }

    @Step("Check empty validation messages for fields 'First Name','Last Name''Email','Password','Confirm Password' is displayed")
    public RegistrationPopUp checkEmptyValidMessage(){
        assertTrue(isElementPresent(checkEmptyFirstName));
        assertTrue(isElementPresent(checkEmptyLastName));
        assertTrue(isElementPresent(checkEmptyEmail));
        assertTrue(isElementPresent(checkEmptyPassword));
        assertTrue(isElementPresent(checkEmptyConfirmPassword));
        return new RegistrationPopUp(driver);
    }

    @Step("Check registration with valid data")
    public RegistrationPopUp registrAs() {
        type(firstNameField, RegistrationData.VALID.getFirstName());
        type(lastNameField, RegistrationData.VALID.getLastName());
        type(email, RegistrationData.VALID.getEmail());
        type(password, RegistrationData.VALID.getPassword());
        type(confirmPassword, RegistrationData.VALID.getConfirmPassword());
        signUpBtn.click();
        return PageFactory.initElements(driver, RegistrationPopUp.class);
    }

    @Step("Check registration with Not valid data")
    public RegistrationPopUp registrAsWithNotValidData() {
        type(firstNameField, RegistrationData.INVALID.getEmail());
        type(lastNameField, RegistrationData.INVALID.getLastName());
        type(email, RegistrationData.INVALID.getEmail());
        type(password, RegistrationData.INVALID.getPassword());
        type(confirmPassword, RegistrationData.INVALID.getConfirmPassword());
        signUpBtn.click();
        return PageFactory.initElements(driver, RegistrationPopUp.class);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
        driver.get(EnvironmentProperties.getProperty("login.url"));
    }

    public void driverWaitPreloader(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//main/div[2]/div/div/div[1]")));
    }

    public void driverWait() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#'][contains(text(),'Create an Account')]")));
    }

    public void driverLinkWait() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[5]/input")));
    }

    public void driverWaitMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'The First Name field is required.')]")));
    }

    public void driverWaitValidMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'The First Name field is required.')]")));
    }

    public void driverWaitBtn(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[5]/input")));
    }

    public void driverWaitPopUp(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-up-first_name")));
    }
}