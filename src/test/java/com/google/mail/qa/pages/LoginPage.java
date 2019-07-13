package com.google.mail.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.mail.qa.base.annotations.QAComponent;
import com.google.mail.qa.base.pages.AbstractPage;
import com.google.mail.qa.base.utilities.BaseConstants;

@QAComponent
public class LoginPage extends AbstractPage
{
	public void openApplicationURL()
	{
		WebDriver webDriver = new ChromeDriver();
		webDriver.get(BaseConstants.applicationURL);
		try
		{
			Thread.sleep(10_000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		webDriver.close();
	}
}
