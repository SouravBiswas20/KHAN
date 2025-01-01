package teatRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="src/test/resources/coursera.feature",
                 glue="teatRunner")



public class Khan_testRunner {

}
