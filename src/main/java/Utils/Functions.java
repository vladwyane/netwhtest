package Utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Functions {

    public static int RandomGen(int i, int c) {
        return (int) (Math.random() * (Math.abs(i - c) + 1)) + Math.min(i, c);
    }

    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
