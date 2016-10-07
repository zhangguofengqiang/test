package com.tarena.action.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tarena.action.BaseController;
import com.tarena.dao.UserDao;
import com.tarena.entity.User;
@Controller
@RequestMapping("/user")
public class registerController extends BaseController{
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}
    @Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
    @RequestMapping("/register.do")
    public String add(@RequestParam String name,@RequestParam String password,@RequestParam String email){
    	userDao.save(new User(name,password,email));
    	return "user/register_ok";
    }
}
