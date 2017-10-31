package helpers.waiters;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class DocumentReadyState implements ExpectedCondition<Boolean> {
    @Override
    public Boolean apply(WebDriver driver) {
        try {
            ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            return Boolean.TRUE;
        }
        catch (Exception e) {
            return Boolean.FALSE;
        }

    }
}
