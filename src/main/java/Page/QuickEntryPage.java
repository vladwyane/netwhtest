package Page;

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

public class QuickEntryPage extends BasePage {

    @FindBy(xpath = "//a[@href='/quick-entry']")
    private WebElement shopNowBtn;

    @FindBy(tagName = "h3")
    private WebElement title;

    @FindBy(xpath = "//div[2]//form/input")
    private WebElement itemNumberfield;

    @FindBy(xpath = "//div[2]//form/button")
    private WebElement checkButton;

    @FindBy(xpath = "//a[@href='/cart']")
    private WebElement miniCart;

    @FindBy(xpath = "//div[2]/div/div[2]/p")
    private WebElement errorMessage;

    @FindBy(className = "remove")
    private WebElement removeLink;

    @FindBy(id = "sign-in-email")
    private WebElement emailField;

    @FindBy(id = "sign-in-password")
    private WebElement passwordField;

    @FindBy(xpath = "//div[2]/form/div[3]/input[@class='btn']")
    private WebElement btn;

    @FindBy(xpath = "//a[@href='/checkout']")
    private WebElement checkoutBtn;

    @FindBy(tagName = "h3")
    private WebElement checkoutTitle;

    public QuickEntryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click 'Shop now' button")
    public QuickEntryPage clickShopNowBtn(){
        shopNowBtn.click();
        return PageFactory.initElements(driver, QuickEntryPage.class);
    }

    @Step("Check 'Quick Entry' page title")
    public QuickEntryPage checkTitle() {
        checkText(title,"QUICK ENTRY");
        return new QuickEntryPage(driver);
    }

    @Step("Fill 'Item number' field with right SKU")
    public QuickEntryPage fillItemNumberField() {
        itemNumberfield.sendKeys("antES001");
        return new QuickEntryPage(driver);
    }

    @Step("Fill 'Item number' field with wrong SKU")
    public QuickEntryPage fillWrongItemNumberField() {
        itemNumberfield.sendKeys("qwerty");
        return new QuickEntryPage(driver);
    }

    @Step("Click 'Check' link")
    public QuickEntryPage clickCheckButton() {
        checkButton.click();
        return new QuickEntryPage(driver);
    }

    @Step("Check error message with wrong SKU")
    public QuickEntryPage checkErrorMessage() {
        isElementPresent(errorMessage);
        return new QuickEntryPage(driver);
    }

    @Step("Click 'Remove' link")
    public QuickEntryPage clickRemoveLink(){
        removeLink.click();
        return new QuickEntryPage(driver);
    }

    @Step("Check added product with 'Quick Entry'")
    public QuickEntryPage checkProduct() {
        isElementPresent(miniCart);
        return new QuickEntryPage(driver);
    }

    @Step("Open Checkout page")
    public QuickEntryPage openCheckoutPage(){
        checkoutBtn.click();
        checkText(checkoutTitle, "CHECKOUT");
        return new QuickEntryPage(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
        driver.get(EnvironmentProperties.getProperty("login.url"));
    }

    public void driverWait() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]//form/input")));
    }

    public void driverWaitBtn() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/quick-entry']")));
    }

    public void driverWaitProducts(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/cart']")));
    }

    public void driverWaitPreloader(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//main/div[2]/div/div/div[1]")));
    }
}