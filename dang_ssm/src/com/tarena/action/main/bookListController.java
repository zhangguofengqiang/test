package com.tarena.action.main;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tarena.action.BaseController;
import com.tarena.dao.BookDao;
import com.tarena.entity.Book;
import com.tarena.entity.Page;

@Controller
@RequestMapping("/main")
@SessionAttributes("page")
public class bookListController extends BaseController{
	private BookDao bookDao;
	public BookDao getBookDao() {
		return bookDao;
	}
	@Resource
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	@RequestMapping("/bookList.do")
	public String bookList(Model model,Page page){
    	List<Book> list1=bookDao.findByPage(page);
    	List<Book> list2=bookDao.findAllBook();
    	int countNumOfBook=0;
    	for(Book b:list2){
    		countNumOfBook+=b.getProductNum();
    	}
    	int rows=list2.size();
    	int totalPage=getTotalPage(rows,page.getPageSize());
    	model.addAttribute("countNumOfBook",countNumOfBook);
    	model.addAttribute("book1s",list1);
    	model.addAttribute("book2s",list2);
    	model.addAttribute("page",page);
    	model.addAttribute("totalPage",totalPage);
		return "main/book_list";
    }
	public int getTotalPage(int rows,int pageSize) {
		if(rows%pageSize==0){
			return rows/pageSize;
		}else{
			return rows/pageSize+1;
		}
	}
}
