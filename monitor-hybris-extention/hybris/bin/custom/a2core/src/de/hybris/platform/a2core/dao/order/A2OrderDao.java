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
package de.hybris.platform.a2core.dao.order;

import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.order.daos.OrderDao;

/**
 *
 */
public interface A2OrderDao extends OrderDao
{
	SearchPageData<OrderModel> findUnPayOrders(final PageableData pageableData, Integer notPaidDays);
	SearchPageData<OrderModel> findPaidOrders(final PageableData pageableData, Integer notPaidDays);
	public OrderModel getOrderByCode(String orderCode);
}
