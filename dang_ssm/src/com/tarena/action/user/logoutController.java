package com.tarena.action.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.action.BaseController;

@Controller
@RequestMapping("/user")
public class logoutController extends BaseController{
    @RequestMapping("/logout.do")
	public String exit(HttpServletRequest request){
    	//System.out.println(request.getSession().getId());
//    	request.getSession().removeAttribute("name");
//    	request.getSession().removeAttribute("userId");
//    	request.getSession().removeAttribute("totalSave");
//    	request.getSession().removeAttribute("totalCost");
//    	request.getSession().removeAttribute("totalCost");
//    	request.getSession().removeAttribute("deleteListCart");
//    	request.getSession().removeAttribute("products");
//    	request.getSession().removeAttribute("code");
    	request.getSession().invalidate();
    	return "user/login_form";
    }
}
