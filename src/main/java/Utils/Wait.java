package Utils;
import Page.BasePage;
import org.openqa.selenium.WebDriver;

public class Wait extends BasePage{
    public Wait(WebDriver driver) {
        super(driver);
    }

    public void threadsSleepWait() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void open() {

    }
}
