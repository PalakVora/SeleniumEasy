package seleniumeasy.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( plugin = {"pretty","html:target/htmlreports"}, 
				features = "src/test/resources/seleniumeasy", 
				glue= "seleniumeasy.cucumber", 
				tags = {"@otherstab","@InputForm"}
			)
public class RunCucumberTest {

}
