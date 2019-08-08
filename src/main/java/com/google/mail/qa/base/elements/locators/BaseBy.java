package com.google.mail.qa.base.elements.locators;

/**
 * @author Mikita Yafimuk
 */
public class BaseBy
{
	enum LocatorTypes
	{
		BY_CLASS_NAME,
		BY_CSS_SELECTOR,
		BY_ID,
		BY_LINK_TEXT,
		BY_NAME,
		BY_XPATH
	}

	private LocatorTypes type;
	private String key;
	private String[] arguments;

	BaseBy(LocatorTypes type, String key, String[] arguments)
	{
		this.type = type;
		this.key = key;
		this.arguments = arguments;
	}
}
