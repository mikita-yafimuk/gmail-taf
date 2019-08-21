package com.google.mail.qa.base.webdriver;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.google.mail.qa.base.annotations.QAComponent;
import com.google.mail.qa.base.utilities.TestConfiguration;

/**
 * @author Mikita Yafimuk
 */
@QAComponent
public class WebDriver
{
	@Autowired
	private TestConfiguration testConfiguration;

	private DriverClass driverClass;
	private EventFiringWebDriver eventFiringWebDriver;

	@Value("${driverType}")
	public void setDriverClass(String driverClass)
	{
		this.driverClass = DriverClass.getDriverClassByName(driverClass);
	}

	@PostConstruct
	public void init() throws Exception
	{
		Class<?> retrievedClass = Class.forName(driverClass.getDriverClass().getName());
		RemoteWebDriver remoteWebDriver = (RemoteWebDriver) retrievedClass.getDeclaredConstructor().newInstance();
		eventFiringWebDriver = new EventFiringWebDriver(remoteWebDriver);
		eventFiringWebDriver.register(new WebDriverListener());
		eventFiringWebDriver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		eventFiringWebDriver.manage().window().maximize();
	}

	@PreDestroy
	public void destroy()
	{
		eventFiringWebDriver.quit();
	}

	/**
	 * Navigates to defined URL
	 *
	 * @param URL
	 */
	public void goToURL(String URL)
	{
		eventFiringWebDriver.get(URL);
	}

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
		return new WebDriverWait(eventFiringWebDriver, timeout).until(ExpectedConditions.presenceOfElementLocated(by));
	}
}
