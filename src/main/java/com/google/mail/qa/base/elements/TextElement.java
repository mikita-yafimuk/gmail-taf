package com.google.mail.qa.base.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.mail.qa.base.webdriver.WebDriver;

/**
 * @author Mikita Yafimuk
 */
public class TextElement extends PageElement
{
	public TextElement(By by, WebDriver webDriver, WebElement webElement)
	{
		super(by, webDriver, webElement);
	}
}
