package Page;

import Utils.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;

public class MainPage extends BasePage{

    @FindBy(xpath = "//header/div/div[5]/div[1]")
    private WebElement inamteInform;

    @FindBy(xpath = "//a[@href=href='/quick-entry']")
    private WebElement shopNowBtn;

    @FindBy(xpath = "//a[@href='#'][contains(text(),'Change')]")
    private WebElement changeInmateLink;

    @FindBy(xpath = "//a[@href= '/taxonomies']")
    private WebElement allCategoriesMenu;

    @FindBy(xpath = "//a[@href='/taxonomy/1/taxons/5'")
    private WebElement productsLink;

    @FindBy(xpath = "//h3[contains(text(),'Clothing')]")
    private WebElement productsTitle;

    @FindBy(xpath = "//a[@href='/t/?t=categories%2Fclothing%2Fshirts']")
    private WebElement shirtsLink;

    @FindBy(xpath = "//h3[contains(text(),'Shirts')]")
    private WebElement shirtsTitle;

    @FindBy(xpath = "//li[8]//div[1]/button")
    private WebElement addToCart;

    @FindBy(xpath = "//div[2]/div[4]//ul")
    private WebElement productList;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickAllCategoriesMenu(){
        allCategoriesMenu.click();
        return new MainPage(driver);
    }

    public MainPage clickproductsLink(){
        productsLink.click();
        return new MainPage(driver);
    }

    public MainPage checkProductsTitle(){
        String str = productsTitle.getText();
        Assert.assertEquals(str, "CLOTHING");
        return new MainPage(driver);
    }

    public MainPage clickShirtsLink(){
        shirtsLink.click();
        return new MainPage(driver);
    }

    public MainPage checkShirtsTitle(){
        String str = shirtsTitle.getText();
        Assert.assertEquals(str, "SHIRTS");
        return new MainPage(driver);
    }

    public MainPage clickAddToCart(){
        addToCart.click();
        return new MainPage(driver);
    }

    public MainPage checkInmateInformation(){
        inamteInform.isDisplayed();
        return new MainPage(driver);
    }

    public MainPage clickShopNowBtn(){
        shopNowBtn.click();
        return new MainPage(driver);
    }

    public MainPage clickChangeLink() {
        changeInmateLink.click();
        return new MainPage(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
    }

    public void openWait(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href=href='/quick-entry']")));
    }

    public void loadTaxonWait(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/taxonomy/1/taxons/5'")));
    }

    public void loadProductsWait(){
        WebDriverWait wait = new WebDriverWait(driver, 130);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[8]//div[1]/button")));
    }

    public MainPage scrollDownToVisibleElement() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollDownToVisibleElement", addToCart);
        return new MainPage(driver);
    }
}
