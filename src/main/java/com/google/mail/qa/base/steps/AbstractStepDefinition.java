package com.google.mail.qa.base.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.google.mail.qa.base.utilities.PropertiesManager;

@ContextConfiguration("classpath:applicationContext.xml")
public abstract class AbstractStepDefinition
{
	@Autowired
	protected PropertiesManager propertiesManager;
}
