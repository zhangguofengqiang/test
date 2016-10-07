package com.tarena.dao;

import java.util.List;

import com.tarena.annotation.MybatisRepository;
import com.tarena.entity.Product;


@MybatisRepository
public interface ProductDao {
   public List<Product> findAll();
   public void delete(int id);
   public void update(Product product);
   public Product findById(int id);
   public Product findByProductAndUser(Product product);
   public List<Product> findByUserName(String userName);
   public void save(Product product); 
}
