package com.tarena.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class userInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("after");
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("post");
	}
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		//System.out.println(name+"  "+password);
		if(name.isEmpty()||password.isEmpty()){
			//request.getRequestDispatcher("toLogin.do").forward(request, response);
			response.sendRedirect("toLogin.do");
			return false;
		}
		System.out.println("true");
		return true;
	}
}
