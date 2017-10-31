package blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.DashboardPage;

public class Header extends BasePage {

    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".header_ .user li:first-child a ")
    private WebElement signInLink;

    @FindBy(xpath = "//a[@href='/account']")
    private WebElement myAccount;


    public SignInPopup openSignInPopup() {
        signInLink.click();
        return new SignInPopup(driver);
    }

    public DashboardPage openMyAccount() {
        myAccount.click();

        return new DashboardPage(driver);
    }
}
