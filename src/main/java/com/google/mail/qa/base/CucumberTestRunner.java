package com.google.mail.qa.base;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/cucumber.json", "html:target/cucumber.html" },
		glue = "com.google.mail.qa",
		features = "src/main/resources")
public class CucumberTestRunner
{
}