package com.mms.cloud.facade;

import java.util.List;

import com.mms.cloud.dto.OrderEntity;

public interface OrderMonitorFacade {
	
	public List<OrderEntity> getOrderData(String starttime,String endtime);
	
}
