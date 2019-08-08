package com.google.mail.qa.base.webdriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

/**
 * @author Mikita Yafimuk
 */
public class WebDriverListener extends AbstractWebDriverEventListener
{
	private final static Logger logger = LogManager.getLogger();

	@Override
	public void beforeNavigateTo(String url, WebDriver driver)
	{
		logger.debug("Navigating to URL {} ...", url);
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver)
	{
		super.beforeClickOn(element, driver);
	}
}
