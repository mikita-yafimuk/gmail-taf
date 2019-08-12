package com.google.mail.qa.pages;

import com.google.mail.qa.base.annotations.QAComponent;
import com.google.mail.qa.base.pages.AbstractPage;

@QAComponent
public class LoginPage extends AbstractPage
{
	public void openApplicationURL()
	{
		webDriver.goToURL(testConfiguration.getApplicationURL());
	}
}
