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
		Object message = messageSource.getMessage(key, null, Locale.getDefault());
		return message != null ? message.toString() : null;
	}
}
