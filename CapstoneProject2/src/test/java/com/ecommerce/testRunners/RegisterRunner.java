package com.ecommerce.testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = ".\\src\\test\\resources\\features\\Login.feature", glue = { "com.ecommerce.stepDefination",
		"Hooks" }, plugin = { "pretty", "html:reports/HTMLReports.html", "json:reports/json-report.json",
				"junit:reports/junit_report.xml" })

public class RegisterRunner extends AbstractTestNGCucumberTests {

}
