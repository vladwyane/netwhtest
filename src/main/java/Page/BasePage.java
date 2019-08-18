package Page;

import Block.FooterNavigation;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertTrue;

public abstract class BasePage {
    protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();

    FooterNavigation footerNavigation;

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

    protected void type(TextInput webElement, String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    protected void sendKeysSlowly(final WebElement element, final String keys) throws InterruptedException {
        for (int i = 0; i < keys.length(); i++){
            element.sendKeys(Character.toString(keys.charAt(i)));
            Thread.sleep(50);
        }
    }

    protected void waiting2seconds() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected boolean isElementInvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean waitUntilTextInElementAppear(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean waitUntilElementAppeared(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean waitUntilElementWillBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean scrollToElement(WebElement element) {

        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

        try {
            ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
            Thread.sleep(500);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isElementContainsAttributeValue(WebElement element, String attribute, String attributeValue) {
        return element.getAttribute(attribute).contains(attributeValue);
    }

    protected void changeAttributeValueWithJS(WebElement element, String attribute, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('" + attribute + "', '" + value + "')", element);

    }

    protected String getNumbersFromString(String value) {
        Pattern pat = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
        Matcher matcher = pat.matcher(value);
        while (matcher.find()) {
            return (matcher.group());
        }

        return (matcher.group());
    }

    public void clickNavItemFooter (String nameNavItem) {
        waitUntilElementAppeared(footerNavigation.listNavItems.get(0));
        scrollToElement(footerNavigation.listNavItems.get(0));
        for(WebElement element : footerNavigation.listNavItems) {
            if (element.getText().equals(nameNavItem.toUpperCase())) {
                waitUntilElementWillBeClickable(element);
                element.click();
                return;
            }
        }
        waitUntilElementWillBeClickable(footerNavigation.listNavItems.get(0));
        footerNavigation.listNavItems.get(0).click();
    }

    protected boolean hoverElementUsingJS(WebElement element) {
        String strJavaScript = "var element = arguments[0]; var mouseEventObj = document.createEvent('MouseEvents'); mouseEventObj.initEvent( 'mouseover', true, true ); element.dispatchEvent(mouseEventObj);";

        try {
            ((JavascriptExecutor) driver).executeScript(strJavaScript, element);
            Thread.sleep(500);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}