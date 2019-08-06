package com.google.mail.qa.base.pages;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.mail.qa.base.utilities.TestConfiguration;

public abstract class AbstractPage
{
	@Autowired
	protected TestConfiguration testConfiguration;
}
