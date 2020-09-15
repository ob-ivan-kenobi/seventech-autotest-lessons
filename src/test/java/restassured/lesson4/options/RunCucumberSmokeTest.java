package restassured.lesson4.options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"restassured.lesson4.stepdefs"},
        features = {"src/test/java/restassured/lesson4/features"})
public class RunCucumberSmokeTest {

}