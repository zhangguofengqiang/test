package com.tarena.dao;

import java.util.List;

import com.tarena.annotation.MybatisRepository;
import com.tarena.entity.Book;
import com.tarena.entity.Page;


@MybatisRepository
public interface BookDao {
   public List<Book> findPart1(int num);
   public List<Book> findPart2(int num);
   public List<Book> findPart3(int num);
   public Book findBookById(int id);
   public List<Book> findByPage(Page page);
   public List<Book> findAllBook();
}
