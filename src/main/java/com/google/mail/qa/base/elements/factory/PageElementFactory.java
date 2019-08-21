package com.google.mail.qa.base.elements.factory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.mail.qa.base.elements.PageElement;
import com.google.mail.qa.base.elements.TextElement;
import com.google.mail.qa.base.elements.locators.BaseBy;
import com.google.mail.qa.base.exceptions.BaseException;
import com.google.mail.qa.base.utilities.PropertiesManager;
import com.google.mail.qa.base.utilities.TestConfiguration;
import com.google.mail.qa.base.webdriver.WebDriver;

/**
 * @author Mikita Yafimuk
 */
public class PageElementFactory implements IPageElementFactory
{
	@Autowired
	private WebDriver webDriver;
	@Autowired
	private TestConfiguration testConfiguration;

	@Autowired
	private PropertiesManager propertiesManager;

	@Override
	public <T extends PageElement> T getElement(Class<T> pageElementType, BaseBy baseBy, int timeout)
	{
		By by = translateBy(baseBy);
		WebElement webElement = webDriver.waitPresenceOfElementLocated(by, timeout);
		return castElement(pageElementType, by, webElement);
	}

	@Override
	public <T extends PageElement> T getElement(Class<T> pageElementType, BaseBy baseBy)
	{
		return getElement(pageElementType, baseBy, testConfiguration.getDefaultWaitTime());
	}

	@Override
	public <T extends PageElement> T getElementIfPresent(Class<T> pageElementType, BaseBy baseBy)
	{
		By by = translateBy(baseBy);
		WebElement webElement;
		try
		{
			webElement = webDriver.waitPresenceOfElementLocated(by, 0);
		}
		catch (TimeoutException e)
		{
			return null;
		}

		return castElement(pageElementType, by, webElement);
	}

	@Override
	public <T extends PageElement> List<T> getElements(Class<T> pageElementType, BaseBy baseBy, int timeout)
	{
		return null;
	}

	@Override
	public <T extends PageElement> List<T> getElements(Class<T> pageElementType, BaseBy baseBy)
	{
		return null;
	}

	/**
	 * @param baseBy {@link BaseBy} framework custom By.
	 * @return {@link By} default Selenium object with resolved string property.
	 */
	private By translateBy(BaseBy baseBy)
	{
		String argumentBy = propertiesManager.get(baseBy.getKey(), baseBy.getArguments());
		BaseBy.LocatorType locatorType = baseBy.getType();
		switch (locatorType)
		{
			case BY_ID:
				return By.id(argumentBy);
			case BY_NAME:
				return By.name(argumentBy);
			case BY_XPATH:
				return By.xpath(argumentBy);
			case BY_CLASS_NAME:
				return By.className(argumentBy);
			case BY_CSS_SELECTOR:
				return By.cssSelector(argumentBy);
			default:
				throw new BaseException("By with type " + locatorType + "could not be found");
		}
	}

	@Override
	public <T extends PageElement> T castElement(Class<T> pageElementType, By by, WebElement webElement)
	{
		if (TextElement.class.isAssignableFrom(pageElementType))
		{
			return pageElementType.cast(new TextElement(by, webDriver, webElement));
		}
		else
		{
			return pageElementType.cast(new PageElement(by, webDriver, webElement));
		}
	}
}
