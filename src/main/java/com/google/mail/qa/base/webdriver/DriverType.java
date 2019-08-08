package com.google.mail.qa.base.webdriver;

import com.google.mail.qa.base.exceptions.BaseException;

/**
 * @author Mikita Yafimuk
 */
public enum DriverType
{
	CHROME("Chrome"),
	FIREFOX("Firefox");

	private String driverType;

	DriverType(String driverType)
	{
		this.driverType = driverType;
	}

	public String getDriverType()
	{
		return this.driverType;
	}

	public static DriverType getDriverByName(String driverName)
	{
		for (DriverType driverType : DriverType.values())
		{
			if (driverType.getDriverType().equalsIgnoreCase(driverName))
			{
				return driverType;
			}
		}
		throw new BaseException("Unknown driver name: " + driverName);
	}
}
