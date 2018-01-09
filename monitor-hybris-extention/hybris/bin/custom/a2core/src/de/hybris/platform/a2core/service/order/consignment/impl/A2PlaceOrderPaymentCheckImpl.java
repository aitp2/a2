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
package de.hybris.platform.a2core.service.order.consignment.impl;

import de.hybris.platform.a2core.hook.order.A2CommercePlaceOrderMethodHook;
import de.hybris.platform.a2core.outbound.sap.A2OrderStatusClient;
import de.hybris.platform.a2core.outbound.sap.dto.ResultData;
import de.hybris.platform.a2core.service.order.consignment.A2PlaceOrderPaymentCheck;
import de.hybris.platform.servicelayer.model.ModelService;

import org.apache.log4j.Logger;

import net.sourceforge.pmd.util.StringUtil;




/**
 *
 */
public class A2PlaceOrderPaymentCheckImpl implements A2PlaceOrderPaymentCheck
{
	private static final Logger LOG = Logger.getLogger(A2PlaceOrderPaymentCheckImpl.class);
	private A2OrderStatusClient a2OrderStatusClient;
	private ModelService modelService;
	

	@Override
	public boolean setStatus(final String orderCode){
		
		final ResultData resultData = a2OrderStatusClient.getResult(orderCode);
		if(null!=resultData && StringUtil.isNotEmpty(resultData.getResultCode()) && "1".equals(resultData.getResultCode())){
			LOG.info("[resultData:"+resultData+"]");
			
			return true;
		}
		LOG.error("[ErrorMessage]:No payment result data");
		return false;
	}

	/**
	 * @return the a2OrderStatusClient
	 */
	public A2OrderStatusClient getA2OrderStatusClient()
	{
		return a2OrderStatusClient;
	}

	/**
	 * @param a2OrderStatusClient the a2OrderStatusClient to set
	 */
	public void setA2OrderStatusClient(A2OrderStatusClient a2OrderStatusClient)
	{
		this.a2OrderStatusClient = a2OrderStatusClient;
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

}
