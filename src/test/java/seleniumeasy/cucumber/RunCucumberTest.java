package seleniumeasy.cucumber;

//import io.cucumber.junit.Cucumber;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.TestNGCucumberRunner;

//import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions( plugin = {"usage","html:target/htmlreports-others.html"}, 
				features = "src/test/resources/seleniumeasy", 
				glue= "seleniumeasy.cucumber", 
				tags = "@otherstab",
				monochrome=true
			)
public class RunCucumberTest  {
	TestNGCucumberRunner abc;
}
