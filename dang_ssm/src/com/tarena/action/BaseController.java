package com.tarena.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Controller
public class BaseController {
    @ExceptionHandler
	public String execute(HttpServletRequest request,Exception ex){
    	request.setAttribute("ex",ex);
    	return "common/error";
    }
}
