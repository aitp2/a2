/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.a2core.setup;

import static de.hybris.platform.a2core.constants.A2coreConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import de.hybris.platform.a2core.constants.A2coreConstants;
import de.hybris.platform.a2core.service.A2coreService;


@SystemSetup(extension = A2coreConstants.EXTENSIONNAME)
public class A2coreSystemSetup
{
	private final A2coreService a2coreService;

	public A2coreSystemSetup(final A2coreService a2coreService)
	{
		this.a2coreService = a2coreService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		a2coreService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return A2coreSystemSetup.class.getResourceAsStream("/a2core/sap-hybris-platform.png");
	}
}
