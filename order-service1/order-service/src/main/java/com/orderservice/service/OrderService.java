package com.orderservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.orderservice.entity.Order;
import com.orderservice.entity.OrderResponse;
import com.orderservice.exception.OrderException;



@Service
public interface OrderService {
	
	public Order addOrder(Order order) throws OrderException;

	public OrderResponse getOrder(int orderId) throws OrderException;

	public Order updateOrder(int orderId) throws OrderException;

	void deletOrder(int orderId);

	public List<Order> getAllOrders();

	public void deletAllOrder(Order order);

	public List<Order> findByDoctorId(String id);
}
