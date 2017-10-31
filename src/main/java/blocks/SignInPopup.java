package blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class SignInPopup extends BasePage {

    public SignInPopup(WebDriver driver) {
        super(driver);
        fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".popups.active")));
    }

    @FindBy(css = ".popups.active input[id='email']")
    private WebElement email;

    @FindBy(css = ".popups.active input[id='password']")
    private WebElement passwod;

    @FindBy(css = ".popups.active input[type='submit']")
    private WebElement signInBtn;

    private SignInPopup typeEmail(String email) {
        this.email.sendKeys(email);

        return this;
    }

    private SignInPopup typePassword(String password) {
        this.passwod.sendKeys(password);

        return this;
    }

    private void clickSignIn() {
        signInBtn.click();
    }

    public Header signIn(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickSignIn();
        fluentWait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".header_ .user li:first-child a "), "My Account"));

        return new Header(driver);
    }
}
