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
package de.hybris.platform.a2core.service.order.consignment.impl;

import de.hybris.platform.a2core.dao.order.impl.A2OrderDaoImpl;
import de.hybris.platform.a2core.outbound.sap.A2DeliveryClient;
import de.hybris.platform.a2core.outbound.sap.A2OrderStatusClient;
import de.hybris.platform.a2core.outbound.sap.dto.ResultData;
import de.hybris.platform.a2core.service.order.consignment.A2DeliveryCheck;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.servicelayer.model.ModelService;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import net.sourceforge.pmd.util.StringUtil;

/**
 *
 */
public class A2DeliveryCheckImpl implements A2DeliveryCheck
{
	private static final Logger LOG = Logger.getLogger(A2PlaceOrderPaymentCheckImpl.class);
	private A2DeliveryClient a2DeliveryClient;
	private ModelService modelService;
	private A2OrderDaoImpl a2OrderDao;

	@Override
	public boolean setStatus(final String orderCode){
		
		final ResultData resultData = a2DeliveryClient.getResult(orderCode);
		BigDecimal odc = new BigDecimal(orderCode);
		OrderModel orderModel = a2OrderDao.getOrderByCode(orderCode);
		if(!orderModel.getIsPaidOrShipped().booleanValue()){
			if(null!=resultData && StringUtil.isNotEmpty(resultData.getResultCode()) && "1".equals(resultData.getResultCode())){
				LOG.info("[resultData:"+resultData+"]");
				
				orderModel.setStatus(OrderStatus.SENT);
				modelService.save(orderModel);
				return true;
			}
		}
		else{
			if(odc.intValue()%2==0 && null!=resultData && StringUtil.isNotEmpty(resultData.getResultCode()) && "1".equals(resultData.getResultCode())){
				LOG.info("[resultData:"+resultData+"]");
				
				orderModel.setStatus(OrderStatus.SENT);
				modelService.save(orderModel);
				return true;
			}
		}
		
		LOG.error("[ErrorMessage]:No SENT data.");
		return false;
	}


	/**
	 * @return the a2DeliveryClient
	 */
	public A2DeliveryClient getA2DeliveryClient()
	{
		return a2DeliveryClient;
	}


	/**
	 * @param a2DeliveryClient the a2DeliveryClient to set
	 */
	public void setA2DeliveryClient(A2DeliveryClient a2DeliveryClient)
	{
		this.a2DeliveryClient = a2DeliveryClient;
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
	 * @return the a2OrderDao
	 */
	public A2OrderDaoImpl getA2OrderDao()
	{
		return a2OrderDao;
	}


	/**
	 * @param a2OrderDao the a2OrderDao to set
	 */
	public void setA2OrderDao(A2OrderDaoImpl a2OrderDao)
	{
		this.a2OrderDao = a2OrderDao;
	}
	

}
