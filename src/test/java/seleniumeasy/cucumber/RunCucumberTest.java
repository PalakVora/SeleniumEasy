package seleniumeasy.cucumber;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

@RunWith(Cucumber.class)
@ExtendedCucumberOptions(
        jsonReport = "target/cucumber.json",
        jsonUsageReport = "target/cucumber-usage.json",
        usageReport = true,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        pdfPageSize = "A4 Landscape",
        toPDF = true,
        outputFolder = "target",
        retryCount = 3)
@CucumberOptions( plugin = {"usage","html:target/report.html","json:target/cucumber.json"}, 
				features = "src/test/resources/seleniumeasy", 
				glue= "seleniumeasy.cucumber", 
				tags = "@otherstab",
				monochrome=true
			)
public class RunCucumberTest  {

	
}
