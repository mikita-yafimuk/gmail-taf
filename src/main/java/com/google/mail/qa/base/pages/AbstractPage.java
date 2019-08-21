package com.google.mail.qa.base.pages;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.mail.qa.base.elements.factory.PageElementFactory;
import com.google.mail.qa.base.utilities.PropertiesManager;
import com.google.mail.qa.base.utilities.TestConfiguration;
import com.google.mail.qa.base.webdriver.WebDriver;

public abstract class AbstractPage
{
	@Autowired
	protected WebDriver webDriver;
	@Autowired
	protected PropertiesManager propertiesManager;
	@Autowired
	protected TestConfiguration testConfiguration;
	@Autowired
	protected PageElementFactory pageElementFactory;
}
