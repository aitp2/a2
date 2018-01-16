/*
 * [y] hybris Platform
 * 
 * Copyright (c) 2000-2017 SAP SE
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of SAP 
 * Hybris ("Confidential Information"). You shall not disclose such 
 * Confidential Information and shall use it only in accordance with the 
 * terms of the license agreement you entered into with SAP Hybris.
 */
package de.hybris.platform.a2util.exception;

/**
 *
 */
public class A2TaskRunnerException extends Exception
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new liby task runner exception.
	 */
	public A2TaskRunnerException()
	{
	}

	/**
	 * Instantiates a new liby task runner exception.
	 *
	 * @param paramString
	 *           the param string
	 */
	public A2TaskRunnerException(final String paramString)
	{
		super(paramString);
	}

	/**
	 * Instantiates a new liby task runner exception.
	 *
	 * @param var1
	 *           the var 1
	 */
	public A2TaskRunnerException(final Throwable var1)
	{
		super(var1);
	}

}
