package com.google.mail.qa.steps;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.mail.qa.base.steps.AbstractStepDefinition;
import com.google.mail.qa.pages.LoginPage;

import cucumber.api.java.en.When;

public class LoginStep extends AbstractStepDefinition
{
	@Autowired
	private LoginPage loginPage;

	@When("^I open home page$")
	public void openHomePage()
	{
		loginPage.openApplicationURL();
	}
}
