package helpers.waiters;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;


public class JQueryWait implements ExpectedCondition<Boolean> {

    @Override
    public Boolean apply(WebDriver driver) {
        try {
            ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
}

