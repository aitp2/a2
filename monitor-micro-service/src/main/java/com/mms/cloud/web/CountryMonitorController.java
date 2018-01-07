package com.mms.cloud.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mms.cloud.dto.CountryOrderMonitorDTO;
import com.mms.cloud.facade.OrderMonitorFacade;
import com.mms.cloud.utils.MonitorStatus;

@Controller
public class CountryMonitorController {
	
	@Autowired
	private OrderMonitorFacade orderMonitorFacade;
	
	@RequestMapping("/countryMonitor")
    public String index(ModelMap map) {
		Map<String,List<CountryOrderMonitorDTO>> map_data = orderMonitorFacade.getCountryOrderMonitorData(null);
		StringBuffer yujing_json = new StringBuffer();
		yujing_json.append("[");
		int i=1;
		for(CountryOrderMonitorDTO countryOrderMonitorDTO:map_data.get(MonitorStatus.YUJING)){
			yujing_json.append("{name: '").append(countryOrderMonitorDTO.getProvince())
				.append("', value:").append(countryOrderMonitorDTO.getNum());
			if(i == map_data.get(MonitorStatus.YUJING).size()){
				yujing_json.append("}");
			}else{
				yujing_json.append("},");
			}
			i = i + 1;
		}
		yujing_json.append("]");
		map.addAttribute("yujing_json", yujing_json);
		
		StringBuffer jinggao_json = new StringBuffer();
		jinggao_json.append("[");
		int j=1;
		for(CountryOrderMonitorDTO countryOrderMonitorDTO:map_data.get(MonitorStatus.JINGGAO)){
			jinggao_json.append("{name: '").append(countryOrderMonitorDTO.getProvince())
				.append("', value:").append(countryOrderMonitorDTO.getNum());
			if(i == map_data.get(MonitorStatus.JINGGAO).size()){
				jinggao_json.append("}");
			}else{
				jinggao_json.append("},");
			}
			i = i + 1;
		}
		jinggao_json.append("]");
		map.addAttribute("jinggao_json", jinggao_json);
		
        return "countryMonitor";
    }
}
