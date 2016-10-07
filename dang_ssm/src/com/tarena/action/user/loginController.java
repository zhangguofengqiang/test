package com.tarena.action.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tarena.action.BaseController;
import com.tarena.dao.UserDao;
import com.tarena.entity.User;
@Controller
@RequestMapping("/user")
public class loginController extends BaseController{
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}
    @Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@RequestMapping("/toLogin.do")
    public String login(){
    	return "user/login_form";
    }
	@RequestMapping("/check.do")
    public String check(@RequestParam("name") String name,@RequestParam("password") String password,
    		Model model,HttpServletRequest request){
		User u1=new User();
		u1.setName(name);
		u1.setPassword(password);
		User u2=userDao.login(u1);
		//int t=1/0;这里用于测试异常
    	if(u2!=null){
    		request.getSession().setAttribute("userId",u2.getId());
    		request.getSession().setAttribute("name",name);
    		return "main/main";
    	}else{
    		model.addAttribute("info","对不起，你输入的用户名或者密码错误");
    		return "user/login_form";
    	}
    }
}
