package Block;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@Block(@FindBy(className= "footer-nav"))
public class FooterNavigation extends HtmlElement {

    @Name("ArrayList of nav items")
    @FindBys( {@FindBy(css = "li a")} )
    public List<WebElement> listNavItems;
}
