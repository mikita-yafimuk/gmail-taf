package com.google.mail.qa.base.pages;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.mail.qa.base.utilities.TestConfiguration;
import com.google.mail.qa.base.webdriver.WebDriver;

public abstract class AbstractPage
{
	@Autowired
	protected WebDriver webDriver;
	@Autowired
	protected TestConfiguration testConfiguration;
}
