package com.tarena.action.cart;

import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tarena.action.BaseController;
import com.tarena.dao.ProductDao;
import com.tarena.entity.Product;

@Controller
@RequestMapping("/cart")
public class deleteCartController extends BaseController{
	List<Product> list=new ArrayList<Product>();
	private double totalSave;
	private double totalCost;
	private ProductDao productDao;
	public ProductDao getProductDao() {
		return productDao;
	}
	@Resource
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	@RequestMapping("/deleteCartItem.do")
	public String deleteCart(@RequestParam int productId,HttpServletRequest request){
		Product p=productDao.findById(productId);
		list.add(p);
		totalSave=(Double) request.getSession().getAttribute("totalSave");
		totalCost=(Double) request.getSession().getAttribute("totalCost");
		totalCost-=p.getDangPrice()*p.getProductNum();
		totalSave-=(p.getFixedPrice()-p.getDangPrice())*p.getProductNum();
		request.getSession().setAttribute("totalSave",totalSave);
		request.getSession().setAttribute("totalCost",totalCost);
		request.getSession().setAttribute("deleteListCart",list);
		productDao.delete(productId);
		return "redirect:cartList.do";
	}
}
