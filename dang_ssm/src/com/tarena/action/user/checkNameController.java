package com.tarena.action.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tarena.action.BaseController;
import com.tarena.dao.UserDao;
import com.tarena.entity.User;

@Controller
@RequestMapping("/user")
public class checkNameController extends BaseController{
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}
    @Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
    @RequestMapping("/checkName.do")
    @ResponseBody
    public String checkName(@RequestParam String name){
    	List<User> list=userDao.findByName(name);
    	if(list.isEmpty()){
    		return "success";
    	}
    	return "error";
    }
}
