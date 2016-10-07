package com.tarena.action.cart;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.action.BaseController;
import com.tarena.dao.ProductDao;
import com.tarena.entity.Product;

@Controller
@RequestMapping("/cart")
public class recoverCartController extends BaseController{
	
	private ProductDao productDao;
	public ProductDao getProductDao() {
		return productDao;
	}
	@Resource
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	@RequestMapping("/recoveryCartItem.do")
	public String cartList(HttpServletRequest request){
		List<Product> deleteListCart=(List<Product>) request.getSession().getAttribute("deleteListCart");
		request.getSession().setAttribute("deleteListCart",deleteListCart);
		return "cart/cart_list";
	}
}
