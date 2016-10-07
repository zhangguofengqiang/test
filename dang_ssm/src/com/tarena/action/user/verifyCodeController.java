package com.tarena.action.user;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tarena.action.BaseController;
@Controller
@RequestMapping("/user")
public class verifyCodeController extends BaseController{
	@RequestMapping("/verifyCode.do")
	@ResponseBody
	public String verifyCode(@RequestParam String code,HttpServletRequest request){
		String graphCode=(String) request.getSession().getAttribute("code");
		if(code.equalsIgnoreCase(graphCode)){
			return "success";
		}
		return "error";
	}
}
