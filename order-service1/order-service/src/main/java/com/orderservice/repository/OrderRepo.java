package com.orderservice.repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.orderservice.entity.Order;


@Repository
public interface OrderRepo extends MongoRepository<Order, Integer> {


	
	public List<Order> findAllByUserId(String id);

}
