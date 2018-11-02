package Page;

import Data.User.SignInUsersData;
import Utils.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import static org.testng.Assert.assertTrue;

public class LoginPopup extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    private WebElement signInLink;

    @FindBy(id = "sign-in-email")
    private WebElement emailField;

    @FindBy(id = "sign-in-password")
    private WebElement passwordField;

    @FindBy(xpath = "//p[@class='error-message'][contains(text(),'The email field is required.')]")
    private WebElement emailValidationMessage;

    @FindBy(xpath = "//p[@class='error-message'][contains(text(),'The password field is required.')]")
    private WebElement passwordValidationMessage;

    @FindBy(xpath = "//div[2]/form/div[3]/input[@class='btn']")
    private WebElement btn;

    @FindBy(xpath = "//a[@href='/account']")
    private WebElement text;

    @FindBy(tagName = "h5")
    private WebElement title;

    @FindBy(className = "popup-holder")
    private WebElement popUp;

    @FindBy(xpath = "//p[contains(text(),'Invalid email or password')]")
    private WebElement emailValidMessage;

    @FindBy(xpath = "//p[contains(text(),'Invalid email or password')]")
    private WebElement passwordValidMessage;

    @FindBy(xpath = "//a[@href='/account']")
    private WebElement myAccount;

    @FindBy(xpath = "//a[@href='#'][contains(text(),'Sign Out')]")
    private WebElement SignOut;

    public LoginPopup(WebDriver driver) {
        super(driver);
    }

    @Step("Check required validtaion message for field 'Email'")
    public LoginPopup checkEmailValidationError() {
        checkText(emailValidationMessage,"The email field is required.");
        return new LoginPopup(driver);
    }

    @Step("Check required validtaion message for field 'Password'")
    public LoginPopup checkPasswordValidationError() {
        checkText(passwordValidationMessage,"The password field is required.");
        return new LoginPopup(driver);
    }

    @Step("Check invalid validtaion message for field 'Email'")
    public LoginPopup checkEmailValidationMessages() {
        checkText(emailValidMessage,"Invalid email or password");
        return new LoginPopup(driver);
    }

    @Step("Check invalid validtaion message for field 'Password'")
    public LoginPopup checkPasswordValidationMessages() {
        checkText(passwordValidMessage,"Invalid email or password");
        return new LoginPopup(driver);
    }

    @Step("Click 'Sign In' link")
    public LoginPopup clickSignInLink() {
        signInLink.click();
        return new LoginPopup(driver);
    }

    @Step("Click 'Sign out' link")
    public LoginPopup signedOutClick(){
        SignOut.click();
        return new LoginPopup(driver);
    }

    @Step("Fill all fields for login")
    public LoginPopup loginAs() {
        type(emailField, SignInUsersData.VALID.getLoginEmail());
        type(passwordField, SignInUsersData.VALID.getLoginPassword());
        btn.click();
        return PageFactory.initElements(driver, LoginPopup.class);
    }

    @Step("Fill 'Password' field")
    public LoginPopup fillPasswordField() {
        type(passwordField, SignInUsersData.VALID.getLoginPassword());
        btn.click();
        return PageFactory.initElements(driver, LoginPopup.class);
    }

    @Step("Fill field as unregistered user")
    public LoginPopup fillUnregisteredUser() {
        type(emailField, SignInUsersData.UNREGISTERED.getLoginEmail());
        type(passwordField, SignInUsersData.UNREGISTERED.getLoginPassword());
        return PageFactory.initElements(driver, LoginPopup.class);
    }

    @Step("Check 'Sign In' pop-up title")
    public LoginPopup checkTitle() {
        checkText(title,"Sign In");
        return new LoginPopup(driver);
    }

    @Step("Click 'Sign In' button")
    public LoginPopup clickSignInBtn() {
        btn.click();
        return new LoginPopup(driver);
    }

    @Step("Check signed in")
    public LoginPopup checkOpenMainPage() {
        checkText(text,"My Account");
        return new LoginPopup(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
    }

    public void driverWaitPreloader(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//main/div[2]/div/div/div[1]")));
    }

    public void driverWait() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#'][contains(text(),'Sign In')]")));
    }

    public void driverWaitElement() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sign-in-email\"]")));
    }

    public void driverWaitPopup() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"inmateid\"]")));
    }

    public void driverWaitMyAccount() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/account']")));
    }

    public void driverWaitSignout() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#'][contains(text(),'Sign Out')]")));
    }
}