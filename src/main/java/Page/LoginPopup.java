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

public class LoginPopup extends BasePage {

    @FindBy(xpath = "//a[@href='#'][contains(text(),'Sign In')]")
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

    public LoginPopup checkEmailValidationError() {
        String str = emailValidationMessage.getText();
        Assert.assertEquals(str, "The Email Field Is Required.");
        return new LoginPopup(driver);
    }

    public LoginPopup checkPasswordValidationError() {
        String str = passwordValidationMessage.getText();
        Assert.assertEquals(str, "The Password Field Is Required.");
        return new LoginPopup(driver);
    }

    public LoginPopup checkEmailValidationMessages() {
        String str = emailValidMessage.getText();
        Assert.assertEquals(str, "Invalid Email Or Password");
        return new LoginPopup(driver);
    }

    public LoginPopup checkPasswordValidationMessages() {
        String str = passwordValidMessage.getText();
        Assert.assertEquals(str, "Invalid Email Or Password");
        return new LoginPopup(driver);
    }

    public LoginPopup clickSignInLink() {
        signInLink.click();
        return new LoginPopup(driver);
    }

    public LoginPopup signedOutClick(){
        SignOut.click();
        return new LoginPopup(driver);
    }

    public LoginPopup loginAs() {
        type(emailField, ProjectData.LoginUserEmail);
        type(passwordField, ProjectData.LoginUserPassword);
        btn.click();
        return PageFactory.initElements(driver, LoginPopup.class);
    }

    public LoginPopup fillPasswordField() {
        type(passwordField, ProjectData.LoginUserPassword);
        btn.click();
        return PageFactory.initElements(driver, LoginPopup.class);
    }

    public LoginPopup fillUnregisteredUser() {
        type(emailField, ProjectData.unregisteredLoginUserEmail);
        type(passwordField, ProjectData.unregisteredLoginUserPassword);
        return PageFactory.initElements(driver, LoginPopup.class);
    }

    public LoginPopup checkTitle() {
        String str = title.getText();
        Assert.assertEquals(str, "Sign In");
        return new LoginPopup(driver);
    }

    public LoginPopup clickSignInBtn() {
        btn.click();
        return new LoginPopup(driver);
    }

    public LoginPopup checkOpenMainPage() {
        String str = text.getText();
        Assert.assertEquals(str, "My Account");
        return new LoginPopup(driver);
    }

    public boolean isSignedOut() {
        if (isElementPresent(myAccount)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
    }

    public void driverWait() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#'][contains(text(),'Sign In')]")));
    }

    public void driverWaitElement() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sign-in-email\"]")));
    }
}
