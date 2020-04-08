package pages;

import org.awaitility.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.awaitility.Awaitility.await;

public class NavigationBarComponent extends BasePage{

    @FindBy(xpath = "//*[@id='global-nav']//a[@name='&lpos=sitenavdefault+sitenav_nfl']")
    private WebElement NFLCategory;

    private final String NFLSubsection = "//*[contains(@class,'sports menu-nfl')]//a[contains(@name,'%s')]";


    public NavigationBarComponent(WebDriver driver){
        super(driver);
    }
    public StandingPage chooseNFLSubsection(String subsection){

        await().atMost(Duration.ONE_MINUTE)
                .pollInterval(Duration.ONE_SECOND)
                .ignoreException(NoSuchElementException.class)
                .until(()-> NFLCategory.isEnabled());

        new Actions(getDriver())
                .moveToElement(NFLCategory)
                .build()
                .perform();

        await().atMost(Duration.ONE_MINUTE)
                .pollInterval(Duration.ONE_SECOND)
                .ignoreException(NoSuchElementException.class)
                .until(() -> {
                            String currentURl = getDriver().getCurrentUrl();
                            getDriver()
                                    .findElement(By.xpath(String.format(NFLSubsection,subsection)))
                                    .click();
                            return !currentURl.equals(getCurrentURL());
                        }
                        );
        return new StandingPage(getDriver());
    }

}
