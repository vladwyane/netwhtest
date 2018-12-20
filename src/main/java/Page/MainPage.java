package Page;

import Utils.ConfigProperties;
import Utils.EnvironmentProperties;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class MainPage extends BasePage {


    @FindBy(xpath = "//header/div/div[5]/div[1]")
    private WebElement inamteInform;

    @FindBy(xpath = "//a[@href='/quick-entry']")
    private WebElement shopNowBtn;

    @FindBy(xpath = "//a[@href='#'][contains(text(),'Change')]")
    private WebElement changeInmateLink;

    @FindBy(xpath = "//a[@href='#'][contains(text(),'change')]")
    private WebElement changePackageLink;

    @FindBy(xpath = "//div[7]/div[6]")
    private WebElement changePackagePopUp;

    @FindBy(xpath = "//div[3]/div/div[6]")
    private WebElement changeInmatePopUp;

    @FindBy(xpath = "//a[@href='#'][contains(text(),'Search by inmate ID')]")
    private WebElement searchInmateByIDLink;

    @FindBy(xpath = "//a[@href='#'][contains(text(),'Search by Inmate Name')]")
    private WebElement searchInmateByNameLink;

    @FindBy(xpath = "//a[@href= '/taxonomies']")
    private WebElement allCategoriesMenu;

    @FindBy(xpath = "//div[2]/div/ul/li[6]/a")
    private WebElement musicStoreLink;

    @FindBy(xpath = "//a[@href='/taxonomy/1/taxons/5'")
    private WebElement productsLink;

    @FindBy(xpath = "//h3[contains(text(),'Clothing')]")
    private WebElement productsTitle;

    @FindBy(xpath = "//div[2]/div/ul/li[3]/a/span[1]")
    private WebElement clothingLink;

    @FindBy(tagName = "h3")
    private WebElement clothingTitle;

    @FindBy(xpath = "//div[2]/div[2]/ul/li[1]/a/span[1]")
    private WebElement shirtsLink;

    @FindBy(tagName = "h3")
    private WebElement shirtsTitle;

    @FindBy(xpath = "//div[4]/ul/li[1]//div[1]/button")
    private WebElement addToCartBtnStandard;

    @FindBy(xpath = "//div[4]/ul/li[5]//div[1]/button")
    private WebElement addToCartBtnCustom;

    @FindBy(xpath = "//div[1]/div/div[1]/aside/div/div[2]/ul")
    private WebElement miniCart;

    @FindBy(xpath = "//a[@href='/checkout']")
    private WebElement checkoutBtn;

    @FindBy(xpath = "//a[@href='/account']")
    private WebElement myAccountLink;

    @FindBy(tagName = "h3")
    private WebElement profileTitle;

    @FindBy(xpath = "//a[@href='/products/sale']")
    private WebElement salePageTab;

    @FindBy(xpath = "//a[@href='/products/new']")
    private WebElement newArrivalsTab;

    @FindBy(xpath = "//a[@href='/products/bestsellers']")
    private WebElement bestSellersTab;

    @FindBy(tagName = "h3")
    private WebElement saleTitle;

    @FindBy(tagName = "h3")
    private WebElement newArrivalsTitle;

    @FindBy(tagName = "h3")
    private WebElement bestSellersTitle;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click 'All categories' link")
    public MainPage clickAllCategories() {
        allCategoriesMenu.click();
        return new MainPage(driver);
    }

    @Step("Click 'Music Store' link")
    public MainPage clickMusicStoreLink() {
        musicStoreLink.click();
        return new MainPage(driver);
    }

    @Step("Click 'Clothing' link")
    public MainPage clickClothingLink() {
        clothingLink.click();
        return new MainPage(driver);
    }

    @Step("Check 'Clothing' section title")
    public MainPage checkClothingTitle() {
        checkText(clothingTitle, "CLOTHING");
        return new MainPage(driver);
    }

    @Step("Click 'Shirts' link")
    public MainPage clickShirtsLink() {
        shirtsLink.click();
        return new MainPage(driver);
    }

    @Step("Check 'Shirts' section title")
    public MainPage checkShirtsTitle() {
        checkText(shirtsTitle, "SHIRTS");
        return new MainPage(driver);
    }

    @Step("Click 'Add to cart' button for standard product")
    public MainPage addToCartStandardProduct() {
        addToCartBtnStandard.click();
        return new MainPage(driver);
    }

    @Step("Check added standard product to cart")
    public MainPage checkCart() {
        assertTrue(isElementPresent(miniCart));
        return new MainPage(driver);
    }

    @Step("Click 'Checkout' button")
    public MainPage clickCheckoutBtn() {
        checkoutBtn.click();
        return new MainPage(driver);
    }

    @Step("Opened 'My Account page'")
    public MainPage openedMyAccount() {
        myAccountLink.click();
        assertTrue(isElementPresent(profileTitle));
        return new MainPage(driver);
    }

    @Step("Opened Sale page")
    public MainPage openSalePage() {
        salePageTab.click();
        checkText(saleTitle, "SALE");
        return new MainPage(driver);
    }

    @Step("Opened NEW ARRIVALS page")
    public MainPage openNewArrivalsPage() {
        newArrivalsTitle.click();
        checkText(newArrivalsTitle, "NEW ARRIVALS");
        return new MainPage(driver);
    }

    @Step("Opened NEW ARRIVALS page")
    public MainPage openBestSellersPage() {
        bestSellersTitle.click();
        checkText(bestSellersTitle, "BEST SELLERS");
        return new MainPage(driver);
    }

    public MainPage clickChangePackage() {
        changePackageLink.click();
        return new MainPage(driver);
    }

    public MainPage checkPopUpOpened() {
        isElementPresent(changePackagePopUp);
        return new MainPage(driver);
    }

//    public MainPage getElemCatalogLists() {
//        for (WebElement catalog : listCatalogs) {
//            currentCatalogs.add(catalog.getText());
//        }
//        return new MainPage(driver);
//    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
        driver.get(EnvironmentProperties.getProperty("login.url"));
    }

    public void waitAllCategoriesLink() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/taxonomies']")));
    }

    public void openWait() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href=href='/quick-entry']")));
    }

    public void loadTaxonWait() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/taxonomy/1/taxons/5'")));
    }

    public void loadProductsWait() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[8]//div[1]/button")));
    }

    public void waitTaxonLink() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href= '/taxonomies']")));
    }

    public void waitTitleText() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
    }

    public void waitShirtsLink() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div[2]/ul/li[1]/a/span[1]")));
    }

    public void waitShirtsTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
    }

    public void waitVisibleStandardProduct() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[4]/ul/li[1]//div[1]/button")));
    }

    public void waitMiniCart() {
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]/div/div[1]/aside/div/div[2]/ul")));
    }

    public MainPage scrollDownToVisibleElementCustomProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollDownToVisibleElement", addToCartBtnCustom);
        return new MainPage(driver);
    }

    public MainPage scrollDownToVisibleElementStandardProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollDownToVisibleElement", addToCartBtnStandard);
        return new MainPage(driver);
    }
}