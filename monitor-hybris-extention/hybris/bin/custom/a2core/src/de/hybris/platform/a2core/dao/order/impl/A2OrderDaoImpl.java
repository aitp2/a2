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
package de.hybris.platform.a2core.dao.order.impl;

import de.hybris.platform.a2core.dao.order.A2OrderDao;
import de.hybris.platform.commerceservices.search.flexiblesearch.PagedFlexibleSearchService;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.enums.PaymentStatus;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.order.delivery.DeliveryModeModel;
import de.hybris.platform.core.model.order.payment.PaymentModeModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.order.daos.impl.DefaultOrderDao;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 *
 */
public class A2OrderDaoImpl extends DefaultOrderDao implements A2OrderDao
{
	private PagedFlexibleSearchService pagedFlexibleSearchService;
	
	@Override
	public SearchPageData<OrderModel> findUnPayOrders(final PageableData pageableData, Integer notPaidDays){
		final StringBuilder queryString = new StringBuilder();
		//sql queryString
		queryString.append("SELECT {c1:pk}");
		queryString.append(" FROM {").append(OrderModel._TYPECODE).append(" AS c1 }");
		queryString.append(" WHERE  {c1:").append(OrderModel.PAYMENTSTATUS).append("}=?paymentStatus ");
		queryString.append(" AND {c1:").append(AbstractOrderModel.DATE).append("} <=?reminderTime");
		queryString.append(" AND {c1:").append(AbstractOrderModel.STATUS).append("} =?orderStatus");

		//now - not paydays
		final Calendar calendar = Calendar.getInstance();
		if (notPaidDays == null)
		{
			notPaidDays=new Integer(0);
		}
		calendar.add(Calendar.DAY_OF_MONTH, -notPaidDays.intValue());

		final Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("paymentStatus", PaymentStatus.NOTPAID);
		queryParams.put("reminderTime", calendar.getTime());
		queryParams.put("orderStatus", OrderStatus.PAIDFAIL);
		final SearchPageData<OrderModel> search = getPagedFlexibleSearchService().search(queryString.toString(), queryParams,
				pageableData);
		return search;
	}

	@Override
	public List<AbstractOrderEntryModel> findEntriesByNumber(String entryTypeCode, AbstractOrderModel order, int number)
	{
		// YTODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AbstractOrderEntryModel> findEntriesByNumber(AbstractOrderModel order, int number)
	{
		// YTODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AbstractOrderEntryModel> findEntriesByNumber(String entryTypeCode, AbstractOrderModel order, int start, int end)
	{
		// YTODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AbstractOrderEntryModel> findEntriesByNumber(AbstractOrderModel order, int start, int end)
	{
		// YTODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AbstractOrderEntryModel> findEntriesByProduct(String entryTypeCode, AbstractOrderModel order, ProductModel product)
	{
		// YTODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AbstractOrderEntryModel> findEntriesByProduct(AbstractOrderModel order, ProductModel product)
	{
		// YTODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AbstractOrderModel> findOrdersByCurrency(CurrencyModel currency)
	{
		// YTODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AbstractOrderModel> findOrdersByDelivereMode(DeliveryModeModel deliveryMode)
	{
		// YTODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AbstractOrderModel> findOrdersByPaymentMode(PaymentModeModel paymentMode)
	{
		// YTODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * @return the pagedFlexibleSearchService
	 */
	public PagedFlexibleSearchService getPagedFlexibleSearchService()
	{
		return pagedFlexibleSearchService;
	}

	/**
	 * @param pagedFlexibleSearchService the pagedFlexibleSearchService to set
	 */
	public void setPagedFlexibleSearchService(PagedFlexibleSearchService pagedFlexibleSearchService)
	{
		this.pagedFlexibleSearchService = pagedFlexibleSearchService;
	}

}
