package com.google.mail.qa.base.webdriver;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Value;

import com.google.mail.qa.base.annotations.QAComponent;

/**
 * @author Mikita Yafimuk
 */
@QAComponent
public class WebDriver
{
	private DriverClass driverClass;
	private EventFiringWebDriver eventFiringWebDriver;

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

	public void goToURL(String URL)
	{
		eventFiringWebDriver.get(URL);
	}

	@Value("${driverType}")
	public void setDriverClass(String driverClass)
	{
		this.driverClass = DriverClass.getDriverClassByName(driverClass);
	}
}
