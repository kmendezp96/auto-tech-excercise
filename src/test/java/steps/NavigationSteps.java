package steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.hamcrest.CoreMatchers;
import pages.HomePage;
import pages.NavigationBarComponent;
import pages.PlayoffsMachinePage;
import pages.StandingPage;

import static org.junit.Assert.assertThat;

public class NavigationSteps extends BaseSteps{

    private HomePage homePage;
    private NavigationBarComponent navigationBarComponent;
    private StandingPage standingPage;
    private PlayoffsMachinePage playoffsMachinePage;

    @Step("User is on the ESPN page")
    public void openApplication(){
        homePage = new HomePage(driver);
    }

    @Step("User moves to NFL Standing section")
    public void goToNFLStanding(){
        navigationBarComponent = new NavigationBarComponent(driver);
        standingPage = navigationBarComponent.chooseNFLSubsection("standing");
    }

    @Step("User selects Playoff Machine from Resources")
    public void goToNFLPlayoffMachine(){
        Serenity.setSessionVariable("currentUrl").to(standingPage.getCurrentURL());
        playoffsMachinePage = standingPage.goToSportSection("NFL","Playoff Machine");
    }

    @Step("User should be in playoff machine page")
    public void assertRedirection(){
        assertThat("current page url should be different to the standingUrl",
                ((String)Serenity.sessionVariableCalled("currentUrl"))
                .equals(playoffsMachinePage.getCurrentURL()),
                CoreMatchers.is(false));
    }
}
