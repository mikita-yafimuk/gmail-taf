package com.google.mail.qa.base.utilities;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Mikita Yafimuk
 */
public class ApplicationContextProvider implements ApplicationContextAware
{
	private static ApplicationContext appContext;

	private ApplicationContextProvider()
	{
	}

	public static ApplicationContext getApplicationContext()
	{
		return appContext;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		appContext = applicationContext;
	}
}
