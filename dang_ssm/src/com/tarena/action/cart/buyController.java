package com.tarena.action.cart;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tarena.action.BaseController;
import com.tarena.dao.ProductDao;
import com.tarena.entity.Product;

@Controller
@RequestMapping("/cart")
public class buyController extends BaseController{
	private ProductDao productDao;
	public ProductDao getProductDao() {
		return productDao;
	}
	@Resource
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	@RequestMapping("/buy.do")
	@ResponseBody
	public String buy(@RequestParam("productName")String productName,@RequestParam("description")String description,
			@RequestParam("addTime")long addTime,@RequestParam("fixedPrice")double fixedPrice,
			@RequestParam("dangPrice")double dangPrice,HttpServletRequest request){
		String userName=(String) request.getSession().getAttribute("name");
		if(userName==null){
			return "denglu";
		}
		Product tempProduct=new Product();
		tempProduct.setUserName(userName);
		tempProduct.setProductName(productName);
		Product p=productDao.findByProductAndUser(tempProduct);
		if(p==null){
			Product p1=new Product();
			p1.setProductName(productName);
			p1.setDescription(description);
			p1.setAddTime(addTime);
			p1.setFixedPrice(fixedPrice);
			p1.setDangPrice(dangPrice);
			p1.setProductNum(1);
			p1.setUserName(userName);
			productDao.save(p1);
			return "success";
		}
		return "errror";
	}
}
