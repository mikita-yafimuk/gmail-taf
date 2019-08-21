package com.google.mail.qa.base.webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.mail.qa.base.annotations.QAComponent;
import com.google.mail.qa.base.utilities.TestConfiguration;

/**
 * @author Mikita Yafimuk
 */
@QAComponent
public class WebDriverWaiter
{
	@Autowired
	private WebDriver webDriver;
	@Autowired
	private TestConfiguration testConfiguration;

	/**
	 * Waits for element with default timeout
	 *
	 * @param by
	 * @return {@link WebElement}
	 */
	public WebElement waitPresenceOfElementLocated(By by)
	{
		return waitPresenceOfElementLocated(by, testConfiguration.getDefaultWaitTime());
	}

	/**
	 * Waits for element with defined timeout
	 *
	 * @param by
	 * @param timeout
	 * @return {@link WebElement}
	 */
	public WebElement waitPresenceOfElementLocated(By by, int timeout)
	{
		return new WebDriverWait(webDriver.getEventFiringWebDriver(), timeout).until(
				ExpectedConditions.presenceOfElementLocated(by));
	}

	/**
	 * Waits for elements with default timeout
	 *
	 * @param by
	 * @return {@link List<WebElement>}
	 */
	public List<WebElement> waitPresenceOfElementsLocated(By by)
	{
		return waitPresenceOfElementsLocated(by, testConfiguration.getDefaultWaitTime());
	}

	/**
	 * Waits for elements with defined timeout
	 *
	 * @param by
	 * @param timeout
	 * @return {@link List<WebElement>}
	 */
	public List<WebElement> waitPresenceOfElementsLocated(By by, int timeout)
	{
		return new WebDriverWait(webDriver.getEventFiringWebDriver(), timeout).until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}
}
