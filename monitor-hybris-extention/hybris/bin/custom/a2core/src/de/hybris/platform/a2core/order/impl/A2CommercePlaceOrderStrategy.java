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
package de.hybris.platform.a2core.order.impl;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;

import de.hybris.platform.commerceservices.order.impl.DefaultCommercePlaceOrderStrategy;
import de.hybris.platform.commerceservices.service.data.CommerceCheckoutParameter;
import de.hybris.platform.commerceservices.service.data.CommerceOrderResult;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.order.CalculationService;
import de.hybris.platform.order.InvalidCartException;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.promotions.model.PromotionResultModel;

import java.util.Collections;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 *
 */
public class A2CommercePlaceOrderStrategy extends DefaultCommercePlaceOrderStrategy
{
	private static final Logger LOG = Logger.getLogger(A2CommercePlaceOrderStrategy.class);
	private CalculationService calculationService;
	
	@Override
	public CommerceOrderResult placeOrder(final CommerceCheckoutParameter parameter) throws InvalidCartException
	{
		final CartModel cartModel = parameter.getCart();
		validateParameterNotNull(cartModel, "Cart model cannot be null");
		final CommerceOrderResult result = new CommerceOrderResult();
		try
		{
			beforePlaceOrder(parameter);
			if (calculationService.requiresCalculation(cartModel))
			{
				// does not make sense to fail here especially since we don't fail below when we calculate order.
				// throw new IllegalArgumentException(String.format("Cart [%s] must be calculated", cartModel.getCode()));
				LOG.error(String.format("CartModel's [%s] calculated flag was false", cartModel.getCode()));
			}

			final CustomerModel customer = (CustomerModel) cartModel.getUser();
			validateParameterNotNull(customer, "Customer model cannot be null");

			final OrderModel orderModel = getOrderService().createOrderFromCart(cartModel);
			if (orderModel != null)
			{
				// Reset the Date attribute for use in determining when the order was placed
				orderModel.setDate(new Date());

				// Store the current site and store on the order
				orderModel.setSite(getBaseSiteService().getCurrentBaseSite());
				orderModel.setStore(getBaseStoreService().getCurrentBaseStore());
				orderModel.setLanguage(getCommonI18NService().getCurrentLanguage());

				if (parameter.getSalesApplication() != null)
				{
					orderModel.setSalesApplication(parameter.getSalesApplication());
				}

				// clear the promotionResults that where cloned from cart PromotionService.transferPromotionsToOrder will copy them over bellow.
				orderModel.setAllPromotionResults(Collections.<PromotionResultModel> emptySet());

				getModelService().saveAll(customer, orderModel);

				if (cartModel.getPaymentInfo() != null && cartModel.getPaymentInfo().getBillingAddress() != null)
				{
					final AddressModel billingAddress = cartModel.getPaymentInfo().getBillingAddress();
					orderModel.setPaymentAddress(billingAddress);
					orderModel.getPaymentInfo().setBillingAddress(getModelService().clone(billingAddress));
					getModelService().save(orderModel.getPaymentInfo());
				}
				getModelService().save(orderModel);
				// Transfer promotions to the order
				getPromotionsService().transferPromotionsToOrder(cartModel, orderModel, false);

				// Calculate the order now that it has been copied
				try
				{
					getCalculationService().calculateTotals(orderModel, false);
					getExternalTaxesService().calculateExternalTaxes(orderModel);
				}
				catch (final CalculationException ex)
				{
					LOG.error("Failed to calculate order [" + orderModel + "]", ex);
				}

				getModelService().refresh(orderModel);
				getModelService().refresh(customer);

				result.setOrder(orderModel);

		//		this.beforeSubmitOrder(parameter, result);

				//getOrderService().submitOrder(orderModel);
			}
			else
			{
				throw new IllegalArgumentException(String.format("Order was not properly created from cart %s", cartModel.getCode()));
			}
		}
		finally
		{
			getExternalTaxesService().clearSessionTaxDocument();
		}

		this.afterPlaceOrder(parameter, result);
		return result;
	}

	/**
	 * @return the calculationService
	 */
	public CalculationService getCalculationService()
	{
		return calculationService;
	}

	/**
	 * @param calculationService the calculationService to set
	 */
	public void setCalculationService(CalculationService calculationService)
	{
		this.calculationService = calculationService;
	}
	
	
}
