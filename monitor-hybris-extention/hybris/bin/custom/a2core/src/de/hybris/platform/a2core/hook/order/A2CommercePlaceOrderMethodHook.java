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
package de.hybris.platform.a2core.hook.order;

import de.hybris.platform.a2core.service.order.consignment.A2PlaceOrderPaymentCheck;
import de.hybris.platform.commerceservices.event.QuoteBuyerOrderPlacedEvent;
import de.hybris.platform.commerceservices.order.hook.impl.CommercePlaceQuoteOrderMethodHook;
import de.hybris.platform.commerceservices.service.data.CommerceCheckoutParameter;
import de.hybris.platform.commerceservices.service.data.CommerceOrderResult;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.order.QuoteModel;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.enums.PaymentStatus;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.util.ServicesUtil;
import de.hybris.platform.util.DateRange;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.bouncycastle.asn1.dvcs.Data;
import org.glassfish.jersey.client.JerseyWebTarget;

import groovy.util.logging.Log;
/**
 *
 */
public class A2CommercePlaceOrderMethodHook extends CommercePlaceQuoteOrderMethodHook
{

	private static final Logger LOG = Logger.getLogger(A2CommercePlaceOrderMethodHook.class);

	private ModelService modelService;
	private A2PlaceOrderPaymentCheck a2PlaceOrderPaymentCheck;
	
	@Override
	public void afterPlaceOrder(final CommerceCheckoutParameter parameter, final CommerceOrderResult orderResult)
	{	
		final OrderModel order = orderResult.getOrder();
		ServicesUtil.validateParameterNotNullStandardMessage("order", order);
		
		final boolean issuccess = a2PlaceOrderPaymentCheck.setStatus(order.getCode());
		if(issuccess)
		{
			
			LOG.info("order status: PAID, total price:"+
					order.getTotalPrice()+", order code:"+order.getCode()+", user:"+order.getUser().getUid());
		}
		else
		{
			order.setStatus(OrderStatus.CREATED);
			order.setPaymentStatus(PaymentStatus.NOTPAID);
			LOG.info("order status: CREATED, total price:"+
					order.getTotalPrice()+", order code:"+order.getCode()+", user:"+order.getUser().getUid());
		}
		modelService.save(order);
		// Set quote state for quote order
		/*final QuoteModel quoteModel = order.getQuoteReference();
		if (quoteModel != null)
		{
			if (LOG.isDebugEnabled())
			{
				LOG.debug(String.format("Quote Order has been placed. Quote Code : [%s] , Order Code : [%s]", quoteModel.getCode(),
						order.getCode()));
			}
			final QuoteBuyerOrderPlacedEvent quoteBuyerOrderPlacedEvent = new QuoteBuyerOrderPlacedEvent(order, quoteModel);
			getEventService().publishEvent(quoteBuyerOrderPlacedEvent);
		}*/
		
	}
	
	private String getDate(){
		Date date = new Date();
		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return myFmt.format(date);
	}

	/**
	 * @return the modelService
	 */
	public ModelService getModelService()
	{
		return modelService;
	}

	/**
	 * @param modelService the modelService to set
	 */
	public void setModelService(ModelService modelService)
	{
		this.modelService = modelService;
	}

	
	
	/**
	 * @return the a2PlaceOrderPaymentCheck
	 */
	public A2PlaceOrderPaymentCheck getA2PlaceOrderPaymentCheck()
	{
		return a2PlaceOrderPaymentCheck;
	}

	/**
	 * @param a2PlaceOrderPaymentCheck the a2PlaceOrderPaymentCheck to set
	 */
	public void setA2PlaceOrderPaymentCheck(A2PlaceOrderPaymentCheck a2PlaceOrderPaymentCheck)
	{
		this.a2PlaceOrderPaymentCheck = a2PlaceOrderPaymentCheck;
	}

}
