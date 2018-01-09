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
package de.hybris.platform.a2util.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;


/**
 * super class of Hystrix Command for configuration.
 *
 * @param <T>           excuted result object
 */
public abstract class AbstractHystrixWSCommand<T> extends HystrixCommand<T>
{

	/**
	 * Set the configuration for Hystrix Command.
	 *
	 * @param config           configuration
	 */
	public AbstractHystrixWSCommand(final A2HystrixConfig config)
	{

		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(config.getGroupKey()))
				.andCommandPropertiesDefaults(
						HystrixCommandProperties.Setter().withExecutionIsolationThreadTimeoutInMilliseconds(config.getThreadTimeout()))
				.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey(config.getThreadPoolKey()))
				.andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(config.getThreadPoolCoreSize())));

	}

}
