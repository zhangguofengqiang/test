package com.tarena.action.cart;

import java.util.List;

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
public class insertController extends BaseController{
	private ProductDao productDao;
	public ProductDao getProductDao() {
		return productDao;
	}
	@Resource
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	@RequestMapping("/insert.do")
	public String insert(HttpServletRequest request,@RequestParam("productId")int productId){
		List<Product> deleteListCart=(List<Product>) request.getSession().getAttribute("deleteListCart");
		List<Product> products=(List<Product>) request.getSession().getAttribute("products");
		for(int i=0;i<deleteListCart.size();i++){
			if(deleteListCart.get(i).getId()==productId){
				//products.add(deleteListCart.get(i));
				productDao.save(deleteListCart.get(i));
				deleteListCart.remove(i);
			}
		}
		request.getSession().setAttribute("deleteListCart",deleteListCart);
		request.getSession().setAttribute("products",products);
		return "redirect:cartList.do";
	}
}
