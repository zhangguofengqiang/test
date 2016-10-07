package com.tarena.action.main;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tarena.action.BaseController;
import com.tarena.dao.BookDao;
import com.tarena.entity.Book;
@Controller
@RequestMapping("/main")
public class bookDetailController extends BaseController{
	private BookDao bookDao;
	public BookDao getBookDao() {
		return bookDao;
	}
	@Resource
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	@RequestMapping("/bookDetail.do")
	public String bookDetail(@RequestParam("bookId")int bookId,Model model){
		Book book=bookDao.findBookById(bookId);
    	model.addAttribute("book",book);
		return "main/product";
    }
}
