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
package de.hybris.platform.a2util.httpclient;

/**
 *
 */

import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.Header;


/**
 * The Class HttpResponse.
 */
public class HttpResponse
{

	/** The response headers. */
	private Header[] responseHeaders;

	/** The string result. */
	private String stringResult;

	/** The byte result. */
	private byte[] byteResult;

	/** The status code. */
	private int statusCode;

	/** The content length. */
	private long contentLength;

	/** The content type. */
	private String contentType;

	/**
	 * Gets the response headers.
	 *
	 * @return the response headers
	 */
	public Header[] getResponseHeaders()
	{
		return responseHeaders;
	}

	/**
	 * Sets the response headers.
	 *
	 * @param responseHeaders the new response headers
	 */
	public void setResponseHeaders(final Header[] responseHeaders)
	{
		this.responseHeaders = responseHeaders;
	}

	/**
	 * Gets the byte result.
	 *
	 * @return the byte result
	 */
	public byte[] getByteResult()
	{
		if (byteResult != null)
		{
			return byteResult;
		}
		if (stringResult != null)
		{
			return stringResult.getBytes();
		}
		return new byte[0];
	}

	/**
	 * Sets the byte result.
	 *
	 * @param byteResult the new byte result
	 */
	public void setByteResult(final byte[] byteResult)
	{
		this.byteResult = byteResult;
	}

	/**
	 * Gets the string result.
	 *
	 * @return the string result
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public String getStringResult() throws UnsupportedEncodingException
	{
		if (stringResult != null)
		{
			return stringResult;
		}
		if (byteResult != null)
		{
			return new String(byteResult, HttpProtocolHandler.DEFAULT_CHARSET);
		}
		return null;
	}

	/**
	 * Sets the string result.
	 *
	 * @param stringResult the new string result
	 */
	public void setStringResult(final String stringResult)
	{
		this.stringResult = stringResult;
	}

	/**
	 * Gets the status code.
	 *
	 * @return the statusCode
	 */
	public int getStatusCode()
	{
		return statusCode;
	}

	/**
	 * Sets the status code.
	 *
	 * @param statusCode           the statusCode to set
	 */
	public void setStatusCode(final int statusCode)
	{
		this.statusCode = statusCode;
	}

	/**
	 * Gets the content length.
	 *
	 * @return the contentLength
	 */
	public long getContentLength()
	{
		return contentLength;
	}

	/**
	 * Sets the content length.
	 *
	 * @param contentLength           the contentLength to set
	 */
	public void setContentLength(final long contentLength)
	{
		this.contentLength = contentLength;
	}

	/**
	 * Gets the content type.
	 *
	 * @return the contentType
	 */
	public String getContentType()
	{
		return contentType;
	}

	/**
	 * Sets the content type.
	 *
	 * @param contentType           the contentType to set
	 */
	public void setContentType(final String contentType)
	{
		this.contentType = contentType;
	}

}
