package com.mms.cloud.service;

import java.util.List;

import com.mms.cloud.dto.OrderEntity;

public interface OrderMonitorService {
	
	public List<OrderEntity> getOrderData(String starttime,String endtime);

}
