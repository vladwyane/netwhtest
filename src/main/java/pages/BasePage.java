package pages;

import helpers.waiters.DocumentReadyState;
import helpers.waiters.JQueryWait;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected Wait fluentWait;
    protected Actions move;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
        fluentWait = new FluentWait(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        move = new Actions(driver);
    }

    public void goToTop() {
        js.executeScript("window.scrollTo(0, 0);");
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }

    public void waitJS() {
        fluentWait.until(ExpectedConditions.and(new JQueryWait(), new DocumentReadyState()));
    }

    public BasePage openPage(String url) {
        driver.get(url);
        waitJS();
        return this;
    }
}
