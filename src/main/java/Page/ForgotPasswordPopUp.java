package Page;

import Data.User.ForgotPasswordData;
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

public class ForgotPasswordPopUp extends BasePage {

    @FindBy(xpath = "//a[@href='#'][contains(text(),'Sign In')]")
    private WebElement signInLink;

    @FindBy(xpath = "//a[@href='#'][contains(text(),'Forgot Your Password?')]")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//h5[contains(text(),'Forgot Password')]")
    private WebElement title;

    @FindBy(id = "forgot-password-email")
    private WebElement emailField;

    @FindBy(xpath = "//div[3]/div/form/div/div[2]/input")
    private WebElement btn;

    @FindBy(xpath = "//form/div[1]//p[contains(text(),'not found')]")
    private WebElement notFoundMessage;

    @FindBy(xpath = "//div[1]//p[contains(text(),'The email field is required.')]")
    private WebElement notRequiredMessage;

    @FindBy(xpath = "//h5[contains(text(),'Email sent')]")
    private WebElement infoPopUpTitle;

    public ForgotPasswordPopUp(WebDriver driver) {
        super(driver);
    }

    @Step("Open 'Sign in' pop-up")
    public ForgotPasswordPopUp clickSignInLink() {
        signInLink.click();
        return new ForgotPasswordPopUp(driver);
    }

    @Step("Open 'Forgot password' pop-up")
    public ForgotPasswordPopUp clickLink() {
        forgotPasswordLink.click();
        return new ForgotPasswordPopUp(driver);
    }

    @Step("Check 'Forgot password' pop-up title")
    public ForgotPasswordPopUp checkTitle() {
        checkText(title,"Forgot Password");
        return new ForgotPasswordPopUp(driver);
    }

    @Step("Submit request")
    public ForgotPasswordPopUp clickBtn() {
        btn.click();
        return new ForgotPasswordPopUp(driver);
    }

    @Step("Check error message 'Not Found'")
    public ForgotPasswordPopUp checkNotFoundMessage() {
        notFoundMessage.isDisplayed();
        return new ForgotPasswordPopUp(driver);
    }

    @Step("Check error message 'Not exsist'")
    public ForgotPasswordPopUp checkNotExistMessage() {
        notRequiredMessage.isDisplayed();
        return new ForgotPasswordPopUp(driver);
    }

    @Step("Fill 'email' field with valid email")
    public ForgotPasswordPopUp fillValidDataField() {
        type(emailField, ForgotPasswordData.VALID.getEmail());
        return PageFactory.initElements(driver, ForgotPasswordPopUp.class);
    }

    @Step("Fill 'email' field with not valid email")
    public ForgotPasswordPopUp fillNotValidDataField() {
        type(emailField, ForgotPasswordData.NOT_VALID.getEmail());
        return PageFactory.initElements(driver, ForgotPasswordPopUp.class);
    }

    @Step("Fill 'email' field with not exist email")
    public ForgotPasswordPopUp fillNotExistDataField() {
        type(emailField, ForgotPasswordData.NOT_EXIST.getEmail());
        return PageFactory.initElements(driver, ForgotPasswordPopUp.class);
    }

    @Step("Check opened 'Succes' pop-up")
    public ForgotPasswordPopUp checkOpenedPopUp() {
        checkText(infoPopUpTitle,"Email sent");
        return new ForgotPasswordPopUp(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
        driver.get(EnvironmentProperties.getProperty("login.url"));
    }

    public void driverWait() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#'][contains(text(),'Sign In')]")));
    }
}