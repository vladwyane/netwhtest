package Page;

import Utils.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class PackagePopUp extends BasePage {

    @FindBy(xpath = "//*[@id=\"select2-package-container\"]")
    private WebElement selectPackageField;

    @FindBy(xpath = "//div[7]/div[3]/input")
    private WebElement beginShoppingBtn;

    @FindBy(xpath = "//div[7]/div[6]/div[1]/span/span[1]/span")
    private WebElement inputField;

    @FindBy(xpath = "//span/span[1]/input")
    private WebElement autocompleteField;

    @FindBy(xpath = "//div[1]/aside/div/div[1]/div[1]")
    private WebElement packageInfo;

    public PackagePopUp(WebDriver driver) {
        super(driver);
    }

    public PackagePopUp selectPackage() {
        selectPackageField.click();
        inputField.sendKeys("Special purchase");
        inputField.sendKeys(Keys.ENTER);
        beginShoppingBtn.click();
        return PageFactory.initElements(driver, PackagePopUp.class);
    }

    public PackagePopUp checkDivInfo(){
        checkText(packageInfo,"Package type: Special purchase change");
        return new PackagePopUp(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
    }

    public void driverWaitPopUp(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[7]/div[3]/input")));
    }

    public void driverWaitDivInfo(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/aside/div/div[1]/div[1]")));
    }
}