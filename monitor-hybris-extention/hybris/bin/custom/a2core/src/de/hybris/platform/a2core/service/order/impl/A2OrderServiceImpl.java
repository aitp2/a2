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
package de.hybris.platform.a2core.service.order.impl;

import de.hybris.platform.a2core.dao.order.impl.A2OrderDaoImpl;
import de.hybris.platform.a2core.service.order.A2OrderService;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.order.OrderEntryModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.order.payment.PaymentInfoModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.order.InvalidCartException;
import de.hybris.platform.order.impl.DefaultOrderService;
import de.hybris.platform.util.DiscountValue;
import de.hybris.platform.util.TaxValue;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class A2OrderServiceImpl extends DefaultOrderService implements A2OrderService
{
	
	private A2OrderDaoImpl a2OrderDao;
	

	@Override
	public SearchPageData<OrderModel> findUnpaidOrders(PageableData pageableData){
		
		return getA2OrderDao().findUnPayOrders(pageableData, null);
	}

	@Override
	public OrderModel createOrderFromCart(CartModel cart) throws InvalidCartException
	{
		// YTODO Auto-generated method stub
		return null;
	}

	@Override
	public void submitOrder(OrderModel order)
	{
		// YTODO Auto-generated method stub
		
	}

	@Override
	public OrderModel placeOrder(CartModel cart, AddressModel deliveryAddress, AddressModel paymentAddress,
			PaymentInfoModel paymentInfo) throws InvalidCartException
	{
		// YTODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean calculateOrder(AbstractOrderModel order)
	{
		// YTODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderEntryModel addNewEntry(OrderModel order, ProductModel product, long qty, UnitModel unit, int number,
			boolean addToPresent)
	{
		// YTODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractOrderEntryModel addNewEntry(ComposedTypeModel entryType, OrderModel order, ProductModel product, long qty,
			UnitModel unit, int number, boolean addToPresent)
	{
		// YTODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderEntryModel addNewEntry(OrderModel order, ProductModel product, long qty, UnitModel unit)
	{
		// YTODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderModel clone(ComposedTypeModel orderType, ComposedTypeModel entryType, AbstractOrderModel original, String code)
	{
		// YTODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderEntryModel getEntryForNumber(OrderModel order, int number)
	{
		// YTODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderEntryModel> getEntriesForNumber(OrderModel order, int start, int end)
	{
		// YTODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderEntryModel> getEntriesForProduct(OrderModel order, ProductModel product)
	{
		// YTODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderModel saveOrder(OrderModel order)
	{
		// YTODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTotalTaxValue(OrderModel order, TaxValue taxValue)
	{
		// YTODO Auto-generated method stub
		
	}

	@Override
	public void addAllTotalTaxValues(OrderModel order, List<TaxValue> taxValues)
	{
		// YTODO Auto-generated method stub
		
	}

	@Override
	public void removeTotalTaxValue(OrderModel order, TaxValue taxValue)
	{
		// YTODO Auto-generated method stub
		
	}

	@Override
	public void addGlobalDiscountValue(OrderModel order, DiscountValue discountValue)
	{
		// YTODO Auto-generated method stub
		
	}

	@Override
	public void addAllGlobalDiscountValues(OrderModel order, List<DiscountValue> discountValues)
	{
		// YTODO Auto-generated method stub
		
	}

	@Override
	public void removeGlobalDiscountValue(OrderModel order, DiscountValue discountValue)
	{
		// YTODO Auto-generated method stub
		
	}

	@Override
	public DiscountValue getGlobalDiscountValue(OrderModel order, DiscountValue discountValue)
	{
		// YTODO Auto-generated method stub
		return null;
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
