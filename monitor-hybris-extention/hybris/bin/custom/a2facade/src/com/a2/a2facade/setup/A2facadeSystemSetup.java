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
package com.a2.a2facade.setup;

import static com.a2.a2facade.constants.A2facadeConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.a2.a2facade.constants.A2facadeConstants;
import com.a2.a2facade.service.A2facadeService;


@SystemSetup(extension = A2facadeConstants.EXTENSIONNAME)
public class A2facadeSystemSetup
{
	private final A2facadeService a2facadeService;

	public A2facadeSystemSetup(final A2facadeService a2facadeService)
	{
		this.a2facadeService = a2facadeService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		a2facadeService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return A2facadeSystemSetup.class.getResourceAsStream("/a2facade/sap-hybris-platform.png");
	}
}
