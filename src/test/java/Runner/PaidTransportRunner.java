package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"Feature/PaidTransport.feature"}
		,glue= {"step_Def"}
		,monochrome=true
	    ,plugin= {"pretty","html:target/cucumber_html_report"}		
		,tags={"@scenario2"}
	)
public class PaidTransportRunner {

}
