package glue;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources",
        glue = "glue",
        plugin = {"pretty","html:target/myreport.html"},
        tags = "@mySmokeTest"


)
public class TestRunner {
}
