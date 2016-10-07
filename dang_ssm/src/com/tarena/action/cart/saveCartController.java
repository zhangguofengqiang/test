package com.tarena.action.cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tarena.action.BaseController;

@Controller
@RequestMapping("/cart")
public class saveCartController extends BaseController{
	@RequestMapping("/saveCart.do")
	@ResponseBody
	public String cartList(){
		return "success";
	}
}
