package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"Feature/ClassWiseStudentStrength.feature"}
		,glue= {"step_Def"}
		,monochrome=true
	    ,plugin= {"pretty","html:target/cucumber_html_report"}		
		,tags= {"@scenario2,@scenario1"}
	)
public class ClassWiseStudentStrengthRunner {

}
