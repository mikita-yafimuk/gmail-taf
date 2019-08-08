package com.google.mail.qa.base.webdriver;

import java.util.Arrays;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.mail.qa.base.exceptions.BaseException;

/**
 * @author Mikita Yafimuk
 */
public enum DriverClass
{
	CHROME(ChromeDriver.class),
	FIREFOX(FirefoxDriver.class),
	IF(InternetExplorerDriver.class);

	private Class<? extends RemoteWebDriver> driverClass;

	DriverClass(Class<? extends RemoteWebDriver> driverClass)
	{
		this.driverClass = driverClass;
	}

	public Class<? extends RemoteWebDriver> getDriverClass()
	{
		return this.driverClass;
	}

	public static DriverClass getDriverClassByName(String driverClassName)
	{
		return Arrays.stream(DriverClass.values())
				.filter(driverClass -> {
					try
					{
						return Class.forName(driverClassName).equals(driverClass.getDriverClass());
					}
					catch (ClassNotFoundException e)
					{
						return false;
					}
				}).findFirst()
				.orElseThrow(() -> new BaseException("Unknown driver name: " + driverClassName));
	}
}
