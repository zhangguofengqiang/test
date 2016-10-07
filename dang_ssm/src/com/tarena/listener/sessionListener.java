package com.tarena.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class sessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent e) {
		HttpSession session=e.getSession();
		ServletContext context=session.getServletContext();
		Object num=context.getAttribute("count");
		if(num==null){
			context.setAttribute("count",1);
		}else{
			context.setAttribute("count",Integer.parseInt(num.toString())+1);
		}
		System.out.println("创建总的浏览量为："+context.getAttribute("count"));
	}

	public void sessionDestroyed(HttpSessionEvent e) {
		HttpSession session=e.getSession();
		ServletContext context=session.getServletContext();
		Object num=context.getAttribute("count");
		if(num==null){
			context.setAttribute("count",1);
		}else{
			context.setAttribute("count",Integer.parseInt(num.toString())-1);
		}
		System.out.println("销毁总的浏览量为："+context.getAttribute("count"));
	}

}
