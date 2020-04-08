package pages;

import org.awaitility.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import static org.awaitility.Awaitility.await;

public class StandingPage extends BasePage {

    @FindBy(xpath = "//*[@class='flex justify-between mt3 mb5 items-center']//select[contains(@class,'dropdown')]")
    private WebElement dropdownMenuButton;

    public StandingPage(WebDriver driver){
        super(driver);
    }

    public PlayoffsMachinePage goToSportSection(String sport, String section){
        await().atMost(Duration.ONE_MINUTE)
                .pollInterval(Duration.ONE_SECOND)
                .ignoreException(NoSuchElementException.class)
                .until(() ->
                        dropdownMenuButton
                                .isEnabled());

        dropdownMenuButton.click();
        String javaScriptCodeSelectOption = "document.getElementsByClassName('dropdown__select')[2]" +
                ".getElementsByTagName('option')[1]" +
                ".selected = 'selected';";
        String javaScriptCodeClickElement = "document.getElementsByClassName('dropdown__select')[2]" +
                ".getElementsByTagName('option')[1].click();";
        String javaScriptCodeGetPlayOffMachineUrl = "return window[\"__espnfitt__\"]['page']['content']" +
                "[\"navigation\"][\"sports\"].filter((el) => el[\"l\"][\"t\"]" +
                ".includes('%s'))[0][\"i\"].filter((el) => el[\"l\"][\"t\"]" +
                ".includes(\"%s\"))[0][\"l\"][\"w\"][\"h\"]";

        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        getDriver().navigate().to((String)jse.executeScript(String
                .format(javaScriptCodeGetPlayOffMachineUrl, sport, section)));
        return new PlayoffsMachinePage(getDriver());
    }
}
