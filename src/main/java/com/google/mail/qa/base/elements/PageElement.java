package com.google.mail.qa.base.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.mail.qa.base.webdriver.WebDriver;

/**
 * @author Mikita Yafimuk
 */
public class PageElement implements BaseElement
{
	protected By by;
	protected WebDriver webDriver;
	protected WebElement webElement;

	public PageElement(By by, WebDriver webDriver, WebElement webElement)
	{
		this.by = by;
		this.webDriver = webDriver;
		this.webElement = webElement;
	}
}
