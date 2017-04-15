package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"Feature/PayAmountWithoutStructure.feature"}
		,glue= {"step_Def"}
		,monochrome=true
	    ,plugin= {"pretty","html:target/cucumber_html_report"}		
	)	
public class PayAmountWithoutStructureRunner {

}
