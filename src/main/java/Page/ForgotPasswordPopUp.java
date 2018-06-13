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

    public ForgotPasswordPopUp clickSignInLink() {
        signInLink.click();
        return new ForgotPasswordPopUp(driver);
    }

    public ForgotPasswordPopUp clickLink() {
        forgotPasswordLink.click();
        return new ForgotPasswordPopUp(driver);
    }

    public ForgotPasswordPopUp checkTitle() {
        String str = title.getText();
        Assert.assertEquals(str, "Forgot Password");
        return new ForgotPasswordPopUp(driver);
    }

    public ForgotPasswordPopUp clickBtn() {
        btn.click();
        return new ForgotPasswordPopUp(driver);
    }

    public ForgotPasswordPopUp checkNotFoundMessage() {
        notFoundMessage.isDisplayed();
        return new ForgotPasswordPopUp(driver);
    }

    public ForgotPasswordPopUp checkNotExistMessage() {
        notRequiredMessage.isDisplayed();
        return new ForgotPasswordPopUp(driver);
    }

    public ForgotPasswordPopUp fillValidDataField() {
        type(emailField, ProjectData.ForgotValidEmail);
        return PageFactory.initElements(driver, ForgotPasswordPopUp.class);
    }

    public ForgotPasswordPopUp fillNotValidDataField() {
        type(emailField, ProjectData.ForgotNotValidEmail);
        return PageFactory.initElements(driver, ForgotPasswordPopUp.class);
    }

    public ForgotPasswordPopUp fillNotExistDataField() {
        type(emailField, ProjectData.ForgotNotExistEmail);
        return PageFactory.initElements(driver, ForgotPasswordPopUp.class);
    }

    public ForgotPasswordPopUp checkOpenedPopUp() {
        String str = infoPopUpTitle.getText();
        Assert.assertEquals(str, "Email sent");
        return new ForgotPasswordPopUp(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
    }

    public void driverWait() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#'][contains(text(),'Sign In')]")));
    }
}
