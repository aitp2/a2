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
package de.hybris.platform.a2util.helper;

import de.hybris.platform.a2util.string.A2StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class HttpHelper
{
	private final static Logger LOG = LoggerFactory.getLogger(HttpHelper.class);

	/**
	 * get the charset from content-type. if not found,return default UTF-8
	 */
	public static String getCharset(final String contentType)
	{
		if (!StringUtils.isEmpty(contentType))
		{
			final String segs[] = A2StringUtils.trim(contentType).split(";");
			for (final String seg : segs)
			{
				if (seg.indexOf("=") > 0)
				{
					final String words[] = seg.split("=");
					for (int i = 0; i < words.length; i++)
					{
						if ("charset".equalsIgnoreCase(words[i]))
						{
							if (i < (words.length - 1))
							{
								return words[i + 1];
							}
						}
					}
				}
			}
		}

		return null;
	}

	/**
	 * get the charset from content-type. if not found,return default UTF-8
	 *
	 * @throws UnsupportedEncodingException
	 */
	public static String generateQueryString(final Map<String, String> paramMap, final String enc)
			throws UnsupportedEncodingException
	{
		StringBuffer params = new StringBuffer();
		for (final String key : paramMap.keySet())
		{
			if (StringUtils.isNotBlank(key))
			{
				params.append(key);
				params.append("=");
				if (StringUtils.isNotEmpty(paramMap.get(key)))
				{
					params.append(URLEncoder.encode(paramMap.get(key), enc));
				}
				params.append("&");
			}
		}

		if (params.length() > 0)
		{
			params = params.deleteCharAt(params.length() - 1);
		}
		if (LOG.isDebugEnabled())
		{
			LOG.debug("Rest request params:[{}]", params.toString());
		}
		return params.toString();
	}
}
