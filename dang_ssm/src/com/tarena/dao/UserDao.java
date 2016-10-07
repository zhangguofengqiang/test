package com.tarena.dao;

import java.util.List;

import com.tarena.annotation.MybatisRepository;
import com.tarena.entity.Page;
import com.tarena.entity.User;


@MybatisRepository
public interface UserDao {
   public void save(User user);//
   public List<User> findByName(String name);//
   public User login(User user);//
   public List<User> findByEmail(String email);//
}
