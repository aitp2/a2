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
public class A2JsonConverterException extends Exception
{
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new Liby json converter exception.
	 */
	public A2JsonConverterException()
	{
	}

	/**
	 * Instantiates a new Liby json converter exception.
	 *
	 * @param paramString
	 *           the param string
	 */
	public A2JsonConverterException(final String paramString)
	{
		super(paramString);
	}

	/**
	 * Instantiates a new Liby json converter exception.
	 *
	 * @param paramString
	 *           the param string
	 * @param paramThrowable
	 *           the param throwable
	 */
	public A2JsonConverterException(final String paramString, final Throwable paramThrowable)
	{
		super(paramString, paramThrowable);
	}

	/**
	 * Instantiates a new Liby json converter exception.
	 *
	 * @param paramThrowable
	 *           the param throwable
	 */
	public A2JsonConverterException(final Throwable paramThrowable)
	{
		super(paramThrowable);
	}

	/**
	 * Instantiates a new Liby json converter exception.
	 *
	 * @param paramString
	 *           the param string
	 * @param paramThrowable
	 *           the param throwable
	 * @param paramBoolean1
	 *           the param boolean 1
	 * @param paramBoolean2
	 *           the param boolean 2
	 */
	protected A2JsonConverterException(final String paramString, final Throwable paramThrowable, final boolean paramBoolean1,
			final boolean paramBoolean2)
	{
		super(paramString, paramThrowable, paramBoolean1, paramBoolean2);
	}
}
