package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

public class BasePage extends PageObject {

    public BasePage(WebDriver driver) {
        setDriver(driver);
    }

    public String getCurrentURL(){
        return getDriver().getCurrentUrl();
    }
}
