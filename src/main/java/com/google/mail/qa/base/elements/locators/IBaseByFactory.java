package com.google.mail.qa.base.elements.locators;

/**
 * @author Mikita Yafimuk
 */
public interface IBaseByFactory
{
	BaseBy className(String className, String... arguments);

	BaseBy cssSelector(String cssSelector, String... arguments);

	BaseBy ID(String id, String... arguments);

	BaseBy linkText(String linkText, String... arguments);

	BaseBy name(String name, String... arguments);

	BaseBy xpath(String xpath, String... arguments);
}
