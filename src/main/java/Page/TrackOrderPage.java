package Page;

import Data.Header.TrackOrderGSOData;
import Data.Header.TrackOrderUPSData;
import Utils.ConfigProperties;
import Utils.EnvironmentProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class TrackOrderPage extends BasePage {

    @FindBy(xpath = "//a[@href='/track-order']")
    private WebElement trackOrderLink;

    @FindBy(tagName = "h3")
    private WebElement title;

    @FindBy(xpath = "//*[@id=\"order_number\"]")
    private WebElement inputOrderNumber;

    @FindBy(xpath = "//*[@id=\"inmate_number\"]")
    private WebElement inputInmateID;

    @FindBy(xpath = "//form/div/div[3]/input")
    private WebElement searchBtn;

    @FindBy(xpath = "//table/tr[2]/td[6]/a")
    private WebElement trackOrderPopUp;

    @FindBy(xpath = "//div[8]/div/h4")
    private WebElement popUpTitle;

    @FindBy(xpath = "//div[8]/div/h6")
    private WebElement trackingNumber;

    @FindBy(xpath = "//p[contains(text(),'The order_number field is required.')]")
    private WebElement orderNumberErrorMessage;

    @FindBy(xpath = "//p[contains(text(),'The inmate_number field is required.')]")
    private WebElement inmateIDErrorMessage;

    public TrackOrderPage(WebDriver driver) {
        super(driver);
    }

    public TrackOrderPage checkDisplayOrderNumberErrorMessage() {
        assertTrue(isElementPresent(orderNumberErrorMessage));
        return new TrackOrderPage(driver);
    }

    public TrackOrderPage checkDisplayInmateIDErrorMessage() {
        assertTrue(isElementPresent(inmateIDErrorMessage));
        return new TrackOrderPage(driver);
    }

    public TrackOrderPage openTrackOrderPage() {
        trackOrderLink.click();
        checkText(title, "TRACK ORDER");
        return new TrackOrderPage(driver);
    }

    public TrackOrderPage clickSearchBtn() {
        searchBtn.click();
        return new TrackOrderPage(driver);
    }

    public TrackOrderPage fillFieldsUPS() {
        type(inputOrderNumber, TrackOrderUPSData.VALID_ORDER_DATA.getOrderNumber());
        type(inputInmateID, TrackOrderUPSData.VALID_ORDER_DATA.getInmateID());
        return new TrackOrderPage(driver);
    }

    public TrackOrderPage fillFieldsGSO() {
        type(inputOrderNumber, TrackOrderGSOData.VALID_ORDER_DATA.getOrderNumber());
        type(inputInmateID, TrackOrderGSOData.VALID_ORDER_DATA.getInmateID());
        return new TrackOrderPage(driver);
    }

    public TrackOrderPage clickTrackorderPopUpLink() {
        trackOrderPopUp.click();
        return new TrackOrderPage(driver);
    }

    public TrackOrderPage checkUPSPopUp() {
        checkText(popUpTitle, "TRACKING INFORMATION UPS");
        checkText(trackingNumber, "Tracking Number: 1Z1264000354325966");
        return new TrackOrderPage(driver);
    }

    public TrackOrderPage checkGSOPopUp() {
        checkText(popUpTitle, "TRACKING INFORMATION GSO");
        checkText(trackingNumber, "Tracking Number: 66022082018369762865");
        return new TrackOrderPage(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
        //  driver.get(EnvironmentProperties.getProperty("login.url"));
    }

    public void draiverWaitLink() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/track-order']")));
    }

    public void driverWaitPreloader() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//main/div[2]/div/div/div[1]")));
    }

    public void driverWaitTrackPopUp() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[8]/div/h4")));
    }

//    public void driverWaitTrackGSOPopUp(){
//        WebDriverWait wait = new WebDriverWait(driver, 130);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[8]/div/h4")));
//    }
}