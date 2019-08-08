package com.google.mail.qa.base.elements.locators;

import com.google.mail.qa.base.annotations.QAComponent;

/**
 * @author Mikita Yafimuk
 */
@QAComponent
public class BaseByFactory implements IBaseByFactory
{
	@Override
	public BaseBy className(String className, String... arguments)
	{
		return new BaseBy(BaseBy.LocatorTypes.BY_CLASS_NAME, className, arguments);
	}

	@Override
	public BaseBy ID(String id, String... arguments)
	{
		return new BaseBy(BaseBy.LocatorTypes.BY_ID, id, arguments);
	}

	@Override
	public BaseBy name(String name, String... arguments)
	{
		return new BaseBy(BaseBy.LocatorTypes.BY_NAME, name, arguments);
	}

	@Override
	public BaseBy cssSelector(String cssSelector, String... arguments)
	{
		return new BaseBy(BaseBy.LocatorTypes.BY_CSS_SELECTOR, cssSelector, arguments);
	}

	@Override
	public BaseBy linkText(String linkText, String... arguments)
	{
		return new BaseBy(BaseBy.LocatorTypes.BY_LINK_TEXT, linkText, arguments);
	}

	@Override
	public BaseBy xpath(String xpath, String... arguments)
	{
		return new BaseBy(BaseBy.LocatorTypes.BY_XPATH, xpath, arguments);
	}
}
