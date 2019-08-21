package com.google.mail.qa.base.utilities;

import org.springframework.beans.factory.annotation.Value;

import com.google.mail.qa.base.annotations.QAComponent;

/**
 * @author Mikita Yafimuk
 */
@QAComponent
public class TestConfiguration
{
	@Value("${gmail.url}")
	private String applicationURL;

	@Value("${defaultWaitTime}")
	private int defaultWaitTime;

	public String getApplicationURL()
	{
		return applicationURL;
	}

	public int getDefaultWaitTime()
	{
		return defaultWaitTime;
	}
}
