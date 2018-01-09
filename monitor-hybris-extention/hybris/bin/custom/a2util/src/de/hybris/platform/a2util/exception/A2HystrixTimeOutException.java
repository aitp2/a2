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
public class A2HystrixTimeOutException extends RuntimeException
{
	/**
	 * Instantiates a new liby hystrix time out exception.
	 */
	public A2HystrixTimeOutException()
	{
	}

	/**
	 * Instantiates a new liby hystrix time out exception.
	 *
	 * @param var1
	 *           the var 1
	 */
	public A2HystrixTimeOutException(final String var1)
	{
		super(var1);
	}

	/**
	 * Instantiates a new liby hystrix time out exception.
	 *
	 * @param var1
	 *           the var 1
	 * @param var2
	 *           the var 2
	 */
	public A2HystrixTimeOutException(final String var1, final Throwable var2)
	{
		super(var1, var2);
	}

	/**
	 * Instantiates a new liby hystrix time out exception.
	 *
	 * @param var1
	 *           the var 1
	 */
	public A2HystrixTimeOutException(final Throwable var1)
	{
		super(var1);
	}
}
