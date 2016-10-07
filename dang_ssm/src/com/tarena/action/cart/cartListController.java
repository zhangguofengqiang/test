package com.tarena.action.cart;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.action.BaseController;
import com.tarena.dao.ProductDao;
import com.tarena.entity.Product;

@Controller
@RequestMapping("/cart")
public class cartListController extends BaseController{
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
	@RequestMapping("/cartList.do")
	public String cartList(HttpServletRequest request){
		totalSave=0;
		totalCost=0;
		String userName=(String) request.getSession().getAttribute("name");
		if(userName==null){
			return "redirect:../user/toLogin.do";
			//return "user/login_form";
		}
		List<Product> products=(List<Product>) productDao.findByUserName(userName);
		request.getSession().setAttribute("products",products);
		for(int i=0;i<products.size();i++){
			totalSave+=(products.get(i).getFixedPrice()-products.get(i).getDangPrice())*products.get(i).getProductNum();
			totalCost+=products.get(i).getDangPrice()*products.get(i).getProductNum();
		}
		request.getSession().setAttribute("totalSave",totalSave);
		request.getSession().setAttribute("totalCost",totalCost);
		return "cart/cart_list";
	}
}
