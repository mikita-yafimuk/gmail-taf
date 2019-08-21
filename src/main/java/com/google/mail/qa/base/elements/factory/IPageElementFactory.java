package com.google.mail.qa.base.elements.factory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.mail.qa.base.elements.PageElement;
import com.google.mail.qa.base.elements.locators.BaseBy;

/**
 * @author Mikita Yafimuk
 */
public interface IPageElementFactory
{

	<T extends PageElement> T getElement(Class<T> pageElementType, BaseBy baseBy, int timeout);

	<T extends PageElement> T getElement(Class<T> pageElementType, BaseBy baseBy);

	<T extends PageElement> T getElementIfPresent(Class<T> pageElementType, BaseBy baseBy);

	<T extends PageElement> List<T> getElements(Class<T> pageElementType, BaseBy baseBy, int timeout);

	<T extends PageElement> List<T> getElements(Class<T> pageElementType, BaseBy baseBy);

	<T extends PageElement> T castElement(Class<T> pageElementType, By by, WebElement webElement);
}