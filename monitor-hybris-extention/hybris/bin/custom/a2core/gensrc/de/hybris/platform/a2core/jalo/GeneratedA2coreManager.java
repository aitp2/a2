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
package de.hybris.platform.a2core.jalo;

import de.hybris.platform.a2core.constants.A2coreConstants;
import de.hybris.platform.constants.CoreConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.order.AbstractOrder;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.util.OneToManyHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Generated class for type <code>A2coreManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedA2coreManager extends Extension
{
	/**
	* {@link OneToManyHandler} for handling 1:n ORDERS's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<AbstractOrder> ORIGINORDERRELATIONORDERSHANDLER = new OneToManyHandler<AbstractOrder>(
	CoreConstants.TC.ABSTRACTORDER,
	false,
	"originOrder",
	null,
	false,
	true,
	CollectionType.SET
	);
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put("pickNote", AttributeMode.INITIAL);
		tmp.put("isPaidOrShipped", AttributeMode.INITIAL);
		tmp.put("originOrder", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.order.AbstractOrder", Collections.unmodifiableMap(tmp));
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	@Override
	public String getName()
	{
		return A2coreConstants.EXTENSIONNAME;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractOrder.isPaidOrShipped</code> attribute.
	 * @return the isPaidOrShipped - This type is used for is send sap.
	 */
	public Boolean isIsPaidOrShipped(final SessionContext ctx, final AbstractOrder item)
	{
		return (Boolean)item.getProperty( ctx, A2coreConstants.Attributes.AbstractOrder.ISPAIDORSHIPPED);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractOrder.isPaidOrShipped</code> attribute.
	 * @return the isPaidOrShipped - This type is used for is send sap.
	 */
	public Boolean isIsPaidOrShipped(final AbstractOrder item)
	{
		return isIsPaidOrShipped( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractOrder.isPaidOrShipped</code> attribute. 
	 * @return the isPaidOrShipped - This type is used for is send sap.
	 */
	public boolean isIsPaidOrShippedAsPrimitive(final SessionContext ctx, final AbstractOrder item)
	{
		Boolean value = isIsPaidOrShipped( ctx,item );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractOrder.isPaidOrShipped</code> attribute. 
	 * @return the isPaidOrShipped - This type is used for is send sap.
	 */
	public boolean isIsPaidOrShippedAsPrimitive(final AbstractOrder item)
	{
		return isIsPaidOrShippedAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AbstractOrder.isPaidOrShipped</code> attribute. 
	 * @param value the isPaidOrShipped - This type is used for is send sap.
	 */
	public void setIsPaidOrShipped(final SessionContext ctx, final AbstractOrder item, final Boolean value)
	{
		item.setProperty(ctx, A2coreConstants.Attributes.AbstractOrder.ISPAIDORSHIPPED,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AbstractOrder.isPaidOrShipped</code> attribute. 
	 * @param value the isPaidOrShipped - This type is used for is send sap.
	 */
	public void setIsPaidOrShipped(final AbstractOrder item, final Boolean value)
	{
		setIsPaidOrShipped( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AbstractOrder.isPaidOrShipped</code> attribute. 
	 * @param value the isPaidOrShipped - This type is used for is send sap.
	 */
	public void setIsPaidOrShipped(final SessionContext ctx, final AbstractOrder item, final boolean value)
	{
		setIsPaidOrShipped( ctx, item, Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AbstractOrder.isPaidOrShipped</code> attribute. 
	 * @param value the isPaidOrShipped - This type is used for is send sap.
	 */
	public void setIsPaidOrShipped(final AbstractOrder item, final boolean value)
	{
		setIsPaidOrShipped( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractOrder.orders</code> attribute.
	 * @return the orders
	 */
	public Set<AbstractOrder> getOrders(final SessionContext ctx, final AbstractOrder item)
	{
		return (Set<AbstractOrder>)ORIGINORDERRELATIONORDERSHANDLER.getValues( ctx, item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractOrder.orders</code> attribute.
	 * @return the orders
	 */
	public Set<AbstractOrder> getOrders(final AbstractOrder item)
	{
		return getOrders( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AbstractOrder.orders</code> attribute. 
	 * @param value the orders
	 */
	public void setOrders(final SessionContext ctx, final AbstractOrder item, final Set<AbstractOrder> value)
	{
		ORIGINORDERRELATIONORDERSHANDLER.setValues( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AbstractOrder.orders</code> attribute. 
	 * @param value the orders
	 */
	public void setOrders(final AbstractOrder item, final Set<AbstractOrder> value)
	{
		setOrders( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to orders. 
	 * @param value the item to add to orders
	 */
	public void addToOrders(final SessionContext ctx, final AbstractOrder item, final AbstractOrder value)
	{
		ORIGINORDERRELATIONORDERSHANDLER.addValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to orders. 
	 * @param value the item to add to orders
	 */
	public void addToOrders(final AbstractOrder item, final AbstractOrder value)
	{
		addToOrders( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from orders. 
	 * @param value the item to remove from orders
	 */
	public void removeFromOrders(final SessionContext ctx, final AbstractOrder item, final AbstractOrder value)
	{
		ORIGINORDERRELATIONORDERSHANDLER.removeValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from orders. 
	 * @param value the item to remove from orders
	 */
	public void removeFromOrders(final AbstractOrder item, final AbstractOrder value)
	{
		removeFromOrders( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractOrder.originOrder</code> attribute.
	 * @return the originOrder
	 */
	public AbstractOrder getOriginOrder(final SessionContext ctx, final AbstractOrder item)
	{
		return (AbstractOrder)item.getProperty( ctx, A2coreConstants.Attributes.AbstractOrder.ORIGINORDER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractOrder.originOrder</code> attribute.
	 * @return the originOrder
	 */
	public AbstractOrder getOriginOrder(final AbstractOrder item)
	{
		return getOriginOrder( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AbstractOrder.originOrder</code> attribute. 
	 * @param value the originOrder
	 */
	public void setOriginOrder(final SessionContext ctx, final AbstractOrder item, final AbstractOrder value)
	{
		item.setProperty(ctx, A2coreConstants.Attributes.AbstractOrder.ORIGINORDER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AbstractOrder.originOrder</code> attribute. 
	 * @param value the originOrder
	 */
	public void setOriginOrder(final AbstractOrder item, final AbstractOrder value)
	{
		setOriginOrder( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractOrder.pickNote</code> attribute.
	 * @return the pickNote - return order pick note.
	 */
	public String getPickNote(final SessionContext ctx, final AbstractOrder item)
	{
		return (String)item.getProperty( ctx, A2coreConstants.Attributes.AbstractOrder.PICKNOTE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>AbstractOrder.pickNote</code> attribute.
	 * @return the pickNote - return order pick note.
	 */
	public String getPickNote(final AbstractOrder item)
	{
		return getPickNote( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AbstractOrder.pickNote</code> attribute. 
	 * @param value the pickNote - return order pick note.
	 */
	public void setPickNote(final SessionContext ctx, final AbstractOrder item, final String value)
	{
		item.setProperty(ctx, A2coreConstants.Attributes.AbstractOrder.PICKNOTE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>AbstractOrder.pickNote</code> attribute. 
	 * @param value the pickNote - return order pick note.
	 */
	public void setPickNote(final AbstractOrder item, final String value)
	{
		setPickNote( getSession().getSessionContext(), item, value );
	}
	
}
