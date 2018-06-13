package Page;

import Utils.ConfigProperties;
import com.sun.imageio.plugins.wbmp.WBMPImageReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

public class PackagePopUp extends BasePage {

    @FindBy(xpath = "//*[@id=\"select2-package-container\"]")
    private WebElement selectPackageField;

    @FindBy(xpath = "//div[7]/div[3]/input")
    private WebElement beginShoppingBtn;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement inputField;

    public PackagePopUp(WebDriver driver) {
        super(driver);
    }

    public PackagePopUp checkSelectPackagField() {
        assertTrue(isElementPresent(selectPackageField));
        return new PackagePopUp(driver);
    }

    public PackagePopUp selectPackage() {
        selectPackageField.click();
        inputField.sendKeys("Standard package");
        inputField.sendKeys(Keys.ENTER);
        beginShoppingBtn.click();
        return PageFactory.initElements(driver, PackagePopUp.class);
    }



    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
    }

}
