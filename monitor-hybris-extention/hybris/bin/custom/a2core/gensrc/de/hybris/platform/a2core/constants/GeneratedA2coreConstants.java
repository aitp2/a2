/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jan 15, 2018 10:55:02 AM                    ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 *  
 * Copyright (c) 2000-2016 SAP SE
 * All rights reserved.
 *  
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 *  
 */
package de.hybris.platform.a2core.constants;

/**
 * @deprecated since ages - use constants in Model classes instead
 */
@Deprecated
@SuppressWarnings({"unused","cast","PMD"})
public class GeneratedA2coreConstants
{
	public static final String EXTENSIONNAME = "a2core";
	public static class Attributes
	{
		public static class AbstractOrder
		{
			public static final String ISPAIDORSHIPPED = "isPaidOrShipped".intern();
			public static final String ORDERS = "orders".intern();
			public static final String ORIGINORDER = "originOrder".intern();
			public static final String PICKNOTE = "pickNote".intern();
		}
	}
	public static class Enumerations
	{
		public static class OrderStatus
		{
			public static final String SAPBACK = "SAPBACK".intern();
			public static final String PAID = "PAID".intern();
			public static final String PAIDFAIL = "PAIDFAIL".intern();
			public static final String SHIPPED = "SHIPPED".intern();
			public static final String SENT = "SENT".intern();
			public static final String RECEIVED = "RECEIVED".intern();
		}
	}
	public static class Relations
	{
		public static final String ORIGINORDERRELATION = "OriginOrderRelation".intern();
	}
	
	protected GeneratedA2coreConstants()
	{
		// private constructor
	}
	
	
}
