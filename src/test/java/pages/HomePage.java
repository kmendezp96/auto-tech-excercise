package pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://www.espn.com/?src=com")
public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
        open();
    }
}
