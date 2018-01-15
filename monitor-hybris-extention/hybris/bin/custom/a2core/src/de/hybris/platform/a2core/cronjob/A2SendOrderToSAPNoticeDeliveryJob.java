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
package de.hybris.platform.a2core.cronjob;

import de.hybris.platform.a2core.service.order.consignment.A2DeliveryCheck;
import de.hybris.platform.a2core.service.order.consignment.A2PlaceOrderPaymentCheck;
import de.hybris.platform.a2core.service.order.impl.A2OrderServiceImpl;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.common.base.Stopwatch;

/**
 *
 */
public class A2SendOrderToSAPNoticeDeliveryJob extends AbstractJobPerformable<CronJobModel>
{
	private static final Logger LOG = Logger.getLogger(A2SendOrderToSAPNoticeDeliveryJob.class);

	private A2OrderServiceImpl orderService;
	private int pageSize = 100;
	private A2DeliveryCheck a2DeliveryCheck;

	@Override
	public PerformResult perform(final CronJobModel arg0) {
		LOG.info("A2SendOrderToSAPNoticeDeliveryJob START!");
		final Stopwatch stopwatch = Stopwatch.createStarted();
		
		final PageableData pageableData = new PageableData();
		pageableData.setPageSize(this.pageSize);
		int i = 0;
		List<OrderModel> list = new ArrayList<OrderModel>();
		final List<OrderModel> allList = new ArrayList<OrderModel>();
		do {
			LOG.info("current PAID order page : " + i);
			pageableData.setCurrentPage(i);
			final SearchPageData<OrderModel> search = getOrderService().findPaidOrders(pageableData);
			list = search.getResults();
			if (list.size() > 0) {
				allList.addAll(list);
				i++;
			}
		} while (list.size() == this.pageSize);
		
		if (list.size()>0)
		{
			for (final OrderModel order : allList)
			{
				if(a2DeliveryCheck.setStatus(order.getCode()))
				{
					LOG.info("order status: SENT, total price:"+
							order.getTotalPrice()+", order code:"+order.getCode()+", user:"+order.getUser().getUid());
				}
				else
				{
					LOG.info("order status:"+order.getStatus().getCode()+", total price:"+
							order.getTotalPrice()+", order code:"+order.getCode()+", user:"+order.getUser().getUid());
				}
			}	
		}
		
		// current pageSize eq the
		// result's size show that may
		// be have data
		LOG.info("have " + allList.size() + " orders unSENT.");
		stopwatch.stop();
		LOG.debug("A2OrderPaymentCheckJob Use Time :" + stopwatch.toString());
		LOG.info("A2OrderPaymentCheckJob END!");
		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}
	

	/**
	 * @return the orderService
	 */
	public A2OrderServiceImpl getOrderService()
	{
		return orderService;
	}


	/**
	 * @param orderService the orderService to set
	 */
	public void setOrderService(A2OrderServiceImpl orderService)
	{
		this.orderService = orderService;
	}


	/**
	 * @return the pageSize
	 */
	public int getPageSize()
	{
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}


	/**
	 * @return the a2DeliveryCheck
	 */
	public A2DeliveryCheck getA2DeliveryCheck()
	{
		return a2DeliveryCheck;
	}


	/**
	 * @param a2DeliveryCheck the a2DeliveryCheck to set
	 */
	public void setA2DeliveryCheck(A2DeliveryCheck a2DeliveryCheck)
	{
		this.a2DeliveryCheck = a2DeliveryCheck;
	}


}
