package Page;

import Utils.ConfigProperties;
import Utils.EnvironmentProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CatalogsPage extends BasePage {
    @FindBy(className = "product-list")
    private WebElement productList;

    @FindBy(className = "catalog-list")
    private WebElement catalogList;

    public CatalogsPage(WebDriver driver) {
        super(driver);
    }

    private List<String> listCatalogs = new ArrayList<>();
    private List<String> currentCatalogs = new ArrayList<>();

    public CatalogsPage addProductsToArrayList() {

        List<WebElement> listProducts = productList.findElements(By.xpath("//div/div[2]/ul[2]/*"));

        for (int i = 0; i < listProducts.size(); i++) {
            currentCatalogs.add(listProducts.get(i).getText());
        }
        return new CatalogsPage(driver);
    }

    public CatalogsPage addCatalogsToArrayList() {

        List<WebElement> listsCatalogs = catalogList.findElements(By.xpath("//div/div[2]/div/ul/*"));

        for (int i = 0; i < listsCatalogs.size(); i++) {
            listCatalogs.add(listsCatalogs.get(i).getText());
        }

        return new CatalogsPage(driver);
    }

    public CatalogsPage getCatalogsFromArrayList() {
        int index = 0;
        for (; index < listCatalogs.size(); index++) {
            listCatalogs.get(index);
        }

        return new CatalogsPage(driver);
    }

    public CatalogsPage getProductsFromArrayList() {
        int index = 0;
        for (; index < listCatalogs.size(); index++) {
            listCatalogs.get(index);
        }
        return new CatalogsPage(driver);
    }

    @Override
        public void open() {
            driver.get(ConfigProperties.getProperty("login.url"));
            driver.get(EnvironmentProperties.getProperty("login.url"));
    }
}