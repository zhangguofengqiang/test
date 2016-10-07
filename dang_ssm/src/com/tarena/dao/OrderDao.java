package com.tarena.dao;

import com.tarena.annotation.MybatisRepository;
import com.tarena.entity.Order;
import com.tarena.entity.User;


@MybatisRepository
public interface OrderDao {
   public void save(Order order);
   public Order findByOrderTime(long orderTime);
}
