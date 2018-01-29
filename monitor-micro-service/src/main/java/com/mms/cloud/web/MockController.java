package com.mms.cloud.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jtwig.functions.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MockController {
	
	private static final Logger LOG = LoggerFactory.getLogger(MockController.class);
			
	@RequestMapping(value="/payMock")
	public void payMock(HttpServletRequest request, HttpServletResponse response, @Parameter String orderCode, @Parameter String province){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		LOG.info("orderStatus:Payed,orderCode:"+orderCode+",province:来自"+province+"订单,modifyTime:"+formatter.format(new Date()));
		
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.print("{\"resultCode\": \"1\"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	@RequestMapping(value="/sendMock")
	public void sendMock(HttpServletRequest request, HttpServletResponse response, @Parameter String orderCode, @Parameter String province){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		LOG.info("orderStatus:Sent,orderCode:"+orderCode+",province:来自"+province+"订单,modifyTime:"+formatter.format(new Date()));
		
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.print("{\"resultCode\": \"1\"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
}
