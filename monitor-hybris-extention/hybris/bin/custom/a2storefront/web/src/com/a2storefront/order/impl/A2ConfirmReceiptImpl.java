/**
 * 
 */
package com.a2storefront.order.impl;

import de.hybris.platform.a2core.service.order.A2OrderService;


import org.apache.log4j.Logger;

import com.a2storefront.order.A2ConfirmReceipt;

/**
 * @author sigrid.l.sui
 *
 */
public class A2ConfirmReceiptImpl implements A2ConfirmReceipt
{

	private static final Logger LOG = Logger.getLogger(A2ConfirmReceiptImpl.class);
	private A2OrderService a2OrderService;
	
	@Override
	public void confirmReceipt(String orderCode)
	{
		// YTODO Auto-generated method stub
		if (a2OrderService.confirmReceipt(orderCode))
		{
			LOG.info("order:"+orderCode+" is complete.");
		}else{
			LOG.error("unexpected error happened to order:"+orderCode);
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
	 * @param a2OrderService the a2OrderService to set
	 */
	public void setA2OrderService(A2OrderService a2OrderService)
	{
		this.a2OrderService = a2OrderService;
	}

	
}
