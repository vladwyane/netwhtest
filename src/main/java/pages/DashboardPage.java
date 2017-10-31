package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    @FindBy(css = "h3")
    private WebElement title;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public String getNameIntitle() {
        return title.getText().replaceFirst("HELLO, ", "").replace("!", "");
    }
}
