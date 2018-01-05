package com.mms.cloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CountryMonitorController {
	
	@RequestMapping("/countryMonitor")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
//        map.addAttribute("key", value);
        // return模板文件的名称，对应src/main/resources/templates/welcome.html
        return "countryMonitor";
    }
}
