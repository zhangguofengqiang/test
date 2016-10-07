package com.tarena.action.main;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.action.BaseController;
import com.tarena.dao.BookDao;
import com.tarena.entity.Book;

@Controller
@RequestMapping("/main")
public class hotSaleBookController extends BaseController{
	private BookDao bookDao;
	public BookDao getBookDao() {
		return bookDao;
	}
	@Resource
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	@RequestMapping("/hotSaleBook.do")
	public String hotSaleBook(Model model){
		List<Book> books=bookDao.findPart2(10);
		model.addAttribute("books",books);
		return "main/hot_sale_new";
    }
}
