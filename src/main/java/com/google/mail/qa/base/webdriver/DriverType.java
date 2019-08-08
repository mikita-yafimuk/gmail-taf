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
public enum DriverType
{
	CHROME(ChromeDriver.class),
	FIREFOX(FirefoxDriver.class),
	IF(InternetExplorerDriver.class);

	private Class<? extends RemoteWebDriver> driverType;

	DriverType(Class<? extends RemoteWebDriver> driverType)
	{
		this.driverType = driverType;
	}

	public Class<? extends RemoteWebDriver> getDriverType()
	{
		return this.driverType;
	}

	public static DriverType getDriverByName(String driverName)
	{
		return Arrays.stream(DriverType.values())
				.filter(driverType -> {
					try
					{
						return Class.forName(driverName).equals(driverType.getDriverType());
					}
					catch (ClassNotFoundException e)
					{
						return false;
					}
				}).findFirst()
				.orElseThrow(() -> new BaseException("Unknown driver name: " + driverName));
	}
}
