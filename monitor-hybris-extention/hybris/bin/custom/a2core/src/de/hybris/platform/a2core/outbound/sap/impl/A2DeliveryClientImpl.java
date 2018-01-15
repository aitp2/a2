/*
 * [y] hybris Platform
 * 
 * Copyright (c) 2000-2018 SAP SE
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of SAP 
 * Hybris ("Confidential Information"). You shall not disclose such 
 * Confidential Information and shall use it only in accordance with the 
 * terms of the license agreement you entered into with SAP Hybris.
 */
package de.hybris.platform.a2core.outbound.sap.impl;

import de.hybris.platform.a2core.outbound.sap.A2DeliveryClient;
import de.hybris.platform.a2core.outbound.sap.dto.ResultData;
import de.hybris.platform.a2util.client.A2RestfulClient;
import de.hybris.platform.a2util.httpclient.HttpRequest;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class A2DeliveryClientImpl extends A2RestfulClient implements A2DeliveryClient
{
	private final static Logger LOG = LoggerFactory.getLogger(A2OrderStatusClientImpl.class);
	
	@Override
	public ResultData getResult(final String orderCode){
		
		if (LOG.isDebugEnabled())
		{
			LOG.debug("begin to fetch result data.");
		}
		
		final Map<String, String> urlVariables = new HashMap<>();
		if (StringUtils.isNotEmpty(orderCode)) {
			urlVariables.put("orderCode", orderCode);
		}
		
		try
		{
			final long startTime = System.currentTimeMillis();
			final ResultData rr = getResponse(urlVariables, ResultData.class, HttpRequest.METHOD_GET,
					getConfigurationService().getConfiguration().getInt("sap.result.rest.outtime"));
			final long endTime = System.currentTimeMillis();
			if (LOG.isDebugEnabled())
			{
				LOG.debug("finished to fetch result data by orderCode[{}]. consume time: {} ms", orderCode,
						Long.valueOf(endTime - startTime));
			}
			return rr;
		}
		catch (final Exception e)
		{
			LOG.error("error happened when fetching result data.");
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	protected String getPropertyKey()
	{
		return "sap.delivery.result.rest.uri";
	}
}
