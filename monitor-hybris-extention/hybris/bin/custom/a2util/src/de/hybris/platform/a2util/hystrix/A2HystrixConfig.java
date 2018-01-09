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

/**
 *
 */
public class A2HystrixConfig
{
	/**
	 * Hystrix uses the command group key to group together commands such as for reporting, alerting, dashboards, or
	 * team/library ownership.
	 */
	private String groupKey;

	/**
	 * Thread-pool key represents a HystrixThreadPool for monitoring, metrics publishing, caching, and other such uses.
	 */
	private String threadPoolKey;

	/** thread-pool core size. */
	private int threadPoolCoreSize;

	/** thread running timeout. */
	private int threadTimeout;

	/**
	 * get method of groupKey.
	 *
	 * @return groupKey
	 */
	public String getGroupKey()
	{
		return this.groupKey;
	}

	/**
	 * set method of groupKey.
	 *
	 * @param groupKey
	 *           groupKey
	 */
	public void setGroupKey(final String groupKey)
	{
		this.groupKey = groupKey;
	}

	/**
	 * get method of threadPoolKey.
	 *
	 * @return threadPoolKey
	 */
	public String getThreadPoolKey()
	{
		return this.threadPoolKey;
	}

	/**
	 * Sets the thread pool key.
	 *
	 * @param threadPoolKey
	 *           the new thread pool key
	 */
	public void setThreadPoolKey(final String threadPoolKey)
	{
		this.threadPoolKey = threadPoolKey;
	}

	/**
	 * Gets the thread pool core size.
	 *
	 * @return the thread pool core size
	 */
	@SuppressWarnings("javadoc")
	public int getThreadPoolCoreSize()
	{
		return this.threadPoolCoreSize;
	}

	/**
	 * Sets the thread pool core size.
	 *
	 * @param threadPoolCoreSize
	 *           the new thread pool core size
	 */
	@SuppressWarnings("javadoc")
	public void setThreadPoolCoreSize(final int threadPoolCoreSize)
	{
		this.threadPoolCoreSize = threadPoolCoreSize;
	}

	/**
	 * Gets the thread timeout.
	 *
	 * @return the thread timeout
	 */
	@SuppressWarnings("javadoc")
	public int getThreadTimeout()
	{
		return this.threadTimeout;
	}

	/**
	 * Sets the thread timeout.
	 *
	 * @param threadTimeout
	 *           the new thread timeout
	 */
	@SuppressWarnings("javadoc")
	public void setThreadTimeout(final int threadTimeout)
	{
		this.threadTimeout = threadTimeout;
	}
}
