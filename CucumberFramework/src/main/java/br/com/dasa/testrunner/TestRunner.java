package br.com.dasa.testrunner;

import cucumber.api.CucumberOptions;

@CucumberOptions(
		features = "Feature"
		,glue={"stepDefinition"}
		)
public class TestRunner {

}
