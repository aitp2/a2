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
package de.hybris.platform.a2util.setup;

import static de.hybris.platform.a2util.constants.A2utilConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import de.hybris.platform.a2util.constants.A2utilConstants;
import de.hybris.platform.a2util.service.A2utilService;


@SystemSetup(extension = A2utilConstants.EXTENSIONNAME)
public class A2utilSystemSetup
{
	private final A2utilService a2utilService;

	public A2utilSystemSetup(final A2utilService a2utilService)
	{
		this.a2utilService = a2utilService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		a2utilService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return A2utilSystemSetup.class.getResourceAsStream("/a2util/sap-hybris-platform.png");
	}
}
