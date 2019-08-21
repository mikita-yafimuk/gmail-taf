package com.google.mail.qa.base.elements.locators;

/**
 * @author Mikita Yafimuk
 */
public class BaseBy
{
	public enum LocatorType
	{
		BY_CLASS_NAME,
		BY_CSS_SELECTOR,
		BY_ID,
		BY_LINK_TEXT,
		BY_NAME,
		BY_XPATH
	}

	private LocatorType type;
	private String key;
	private String[] arguments;

	BaseBy(LocatorType type, String key, String[] arguments)
	{
		this.type = type;
		this.key = key;
		this.arguments = arguments;
	}

	public LocatorType getType()
	{
		return type;
	}

	public String getKey()
	{
		return key;
	}

	public String[] getArguments()
	{
		return arguments;
	}
}
