package steps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class TestRunner {
    @Steps
    NavigationSteps navigationSteps;

    @Before
    public void setUp(){
        navigationSteps.setUp();
    }

    @After
    public void tearDown(){
        navigationSteps.tearDown();
    }

    @Test
    public void NavigateToPlayoffMachine() {
        navigationSteps.openApplication();
        navigationSteps.goToNFLStanding();
        navigationSteps.goToNFLPlayoffMachine();
        navigationSteps.assertRedirection();
    }
}
