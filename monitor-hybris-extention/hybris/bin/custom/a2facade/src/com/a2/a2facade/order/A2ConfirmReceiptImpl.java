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
package com.a2.a2facade.order;


import de.hybris.platform.a2core.service.order.A2OrderService;

import org.apache.log4j.Logger;



/**
 *
 */
public class A2ConfirmReceiptImpl implements A2ConfirmReceipt
{
	private static final Logger LOG = Logger.getLogger(A2ConfirmReceiptImpl.class);
	private A2OrderService a2OrderService;

	@Override
	public void confirmReceipt(final String orderCode)
	{
		// YTODO Auto-generated method stub
		if (a2OrderService.confirmReceipt(orderCode))
		{
			LOG.info("order:" + orderCode + " is complete.");
		}
		else
		{
			LOG.error("unexpected error happened to order:" + orderCode);
		}
	}

	/**
	 * @return the a2OrderService
	 */
	public A2OrderService getA2OrderService()
	{
		return a2OrderService;
	}

	/**
	 * @param a2OrderService
	 *           the a2OrderService to set
	 */
	public void setA2OrderService(final A2OrderService a2OrderService)
	{
		this.a2OrderService = a2OrderService;
	}

}
