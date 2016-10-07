package com.tarena.action.cart;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tarena.action.BaseController;
import com.tarena.dao.ProductDao;
import com.tarena.entity.Product;

@Controller
@RequestMapping("/cart")
public class updateCartController extends BaseController{
	
	private ProductDao productDao;
	public ProductDao getProductDao() {
		return productDao;
	}
	@Resource
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	@RequestMapping("/updateCartItem.do")
	public String cartList(@RequestParam int productId,@RequestParam int quantity){
		Product p=new Product();
		p.setId(productId);
		p.setProductNum(quantity);
		productDao.update(p);
		return "redirect:cartList.do";
	}
}
