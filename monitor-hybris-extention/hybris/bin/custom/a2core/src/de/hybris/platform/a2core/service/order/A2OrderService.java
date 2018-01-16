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
package de.hybris.platform.a2core.service.order;

import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.order.OrderService;

/**
 *
 */
public interface A2OrderService extends OrderService
{
	SearchPageData<OrderModel> findUnpaidOrders(PageableData pageableData);
	
	SearchPageData<OrderModel> findPaidOrders(PageableData pageableData);
	
	boolean confirmReceipt(final String orderCode);
}
