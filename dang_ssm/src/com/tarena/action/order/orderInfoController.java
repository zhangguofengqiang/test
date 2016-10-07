package com.tarena.action.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.action.BaseController;
@Controller
@RequestMapping("/order")
public class orderInfoController extends BaseController{
    @RequestMapping("/orderInfo.do")
	public String orderInfo(){
    	return "order/order_info";
    }
}
