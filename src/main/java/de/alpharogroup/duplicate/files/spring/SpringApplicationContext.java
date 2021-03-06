/**
 * Copyright (C) 2007 Asterios Raptis
 *
 * This program is open source software; you can redistribute it and/or modify
 * it under the terms of the Apache License V2.0 as published by
 * the Apache Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY.
 */
package de.alpharogroup.duplicate.files.spring;

import java.io.IOException;

import javax.xml.parsers.FactoryConfigurationError;

import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import lombok.Getter;

/**
 * The Class SpringApplicationContext.
 */
public class SpringApplicationContext {

	/** The instance. */
	private static SpringApplicationContext instance = new SpringApplicationContext();

	/**
	 * Gets the single instance of SpringApplicationContext.
	 *
	 * @return single instance of SpringApplicationContext
	 */
	public static SpringApplicationContext getInstance() {
		return instance;
	}

	/** The application context. */
	@Getter
	private ApplicationContext applicationContext;

	/**
	 * Instantiates a new spring application context.
	 */
	private SpringApplicationContext() {
		final String rootContextDirectoryClassPath = "/ctx";

		final String applicationContextPath = rootContextDirectoryClassPath + "/application-context.xml";

		final ApplicationContext ac = new ClassPathXmlApplicationContext(applicationContextPath);

		final Resource resource = ac.getResource("classpath:conf/log4j/log4jconfig.xml");

		try {
			DOMConfigurator.configure(resource.getURL());
		} catch (final FactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		applicationContext = ac;
	}

}
