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
public class A2JmsException extends Exception
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new liby jms exception.
	 */
	public A2JmsException()
	{
	}

	/**
	 * Instantiates a new liby jms exception.
	 *
	 * @param paramString
	 *           the param string
	 */
	public A2JmsException(final String paramString)
	{
		super(paramString);
	}

	/**
	 * Instantiates a new liby jms exception.
	 *
	 * @param paramString
	 *           the param string
	 * @param paramThrowable
	 *           the param throwable
	 */
	public A2JmsException(final String paramString, final Throwable paramThrowable)
	{
		super(paramString, paramThrowable);
	}

	/**
	 * Instantiates a new liby jms exception.
	 *
	 * @param paramThrowable
	 *           the param throwable
	 */
	public A2JmsException(final Throwable paramThrowable)
	{
		super(paramThrowable);
	}

	/**
	 * Instantiates a new liby jms exception.
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
	protected A2JmsException(final String paramString, final Throwable paramThrowable, final boolean paramBoolean1,
			final boolean paramBoolean2)
	{
		super(paramString, paramThrowable, paramBoolean1, paramBoolean2);
	}

}
