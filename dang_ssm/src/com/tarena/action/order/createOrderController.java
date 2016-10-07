package com.tarena.action.order;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tarena.action.BaseController;
import com.tarena.dao.OrderDao;
import com.tarena.entity.Order;

@Controller
@RequestMapping("/order")
public class createOrderController extends BaseController{
   private OrderDao orderDao;
   public OrderDao getOrderDao() {
	  return orderDao;
   }
   @Resource
   public void setOrderDao(OrderDao orderDao) {
	  this.orderDao = orderDao;
   }
   @RequestMapping("/createOrder.do")
   public String createOrder(@RequestParam("receiveName")String receiveName,
		   @RequestParam("fullAddress")String fullAddress,@RequestParam("postalCode")String postalCode,
		   @RequestParam("phone")String phone,@RequestParam("mobile")String mobile,HttpServletRequest req,Model model){
	   Order order=new Order();
	   order.setReceiveName(receiveName);
	   order.setFullAddress(fullAddress);
	   order.setPostalCode(postalCode);
	   order.setPhone(phone);
	   order.setMobile(mobile);
	   order.setUserId((Integer)req.getSession().getAttribute("userId"));
	   order.setTotalPrice((Double)req.getSession().getAttribute("totalCost"));
	   long orderTime=new Date().getTime();
	   order.setOrderTime(orderTime);
	   orderDao.save(order);
	   model.addAttribute("orderTime",orderDao.findByOrderTime(orderTime).getId());
	   return "order/order_ok";
   }
}
