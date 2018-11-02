package Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;


import java.util.List;

import static org.testng.Assert.assertTrue;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
    }


    protected void type(WebElement webElement, String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    public abstract void open();

    protected boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean checkText(WebElement element, String text) {
        try {
            String str = element.getText();
            Assert.assertEquals(str, text);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean checHTMLAttribute(WebElement element, String attribute, String answere) {
        try {
            String str = element.getAttribute(attribute);
            assertTrue(str.contains(answere));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean fillDropDownFieldWithSaveSelectedElem(WebElement element, String str) {
        try {
            element.click();
            element.sendKeys(str);
            element.sendKeys(Keys.ENTER);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean fillDropDownField(WebElement element, WebElement inputElement, String str) {
        try {
            element.click();
            inputElement.sendKeys(str);
            inputElement.sendKeys(Keys.ENTER);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean moveToElem(WebElement element) {
        try {
            Actions builder = new Actions(this.driver);
            builder.moveToElement(element);
            builder.click();
            builder.build().perform();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean getElementInList(WebElement element, List<WebElement> elementList) {
        try {
            element = elementList.get(1);
            element.click();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}