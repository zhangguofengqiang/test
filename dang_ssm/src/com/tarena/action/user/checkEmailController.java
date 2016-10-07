package com.tarena.action.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tarena.action.BaseController;
import com.tarena.dao.UserDao;
import com.tarena.entity.User;

@Controller
@RequestMapping("/user")
public class checkEmailController extends BaseController{
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}
    @Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
    @RequestMapping(value="/{v}.do")
    @ResponseBody
    public String checkEmail(@PathVariable("v") String v){
    	List<User> list=userDao.findByEmail(v);
    	if(list.isEmpty()){
    		return "success";
    	}
    	return "error";
    }
}
