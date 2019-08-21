package com.google.mail.qa.base.utilities;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.google.mail.qa.base.annotations.QAComponent;

/**
 * @author Mikita Yafimuk
 */
@QAComponent
public class PropertiesManager
{
	@Autowired
	private ResourceBundleMessageSource messageSource;

	public String get(String key)
	{
		return messageSource.getMessage(key, null, Locale.getDefault());
	}

	public String get(String key, String... arguments)
	{
		return messageSource.getMessage(key, arguments, Locale.getDefault());
	}
}
