package com.orderservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orderservice.entity.Drug;
import com.orderservice.entity.Order;
import com.orderservice.entity.OrderResponse;
import com.orderservice.entity.User;
import com.orderservice.exception.OrderException;
import com.orderservice.repository.OrderRepo;



@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private RestTemplate restTemplate;

	
	@Override
	public Order addOrder(Order order) throws OrderException {
		
		
		return orderRepo.save(order);
		

	}



	public Order updateOrder(int orderId) {
		Order order = orderRepo.findById(orderId).orElseThrow(()-> new OrderException("Order not found"));
		return orderRepo.save(order);
	}
	
	@Override
	public void deletOrder(int orderId) {

		orderRepo.deleteById(orderId);

	}

	@Override
	public OrderResponse getOrder(int orderId) throws OrderException {

		Order order = orderRepo.findById(orderId)
				.orElseThrow(() -> new OrderException("Order not found with ordr ID " + orderId));
	
		
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setQuantity(order.getQuantity());
		orderResponse.setOrderDate(order.getOrderDate());
		orderResponse.setOrderId(orderId);
		
		User user = restTemplate.getForObject("http://localhost:8081/user/getUser/"+order.getUserId(), User.class);
		Drug drug = restTemplate.getForObject("http://localhost:8082/drug/get/"+order.getDrugId(), Drug.class);
		
		orderResponse.setDrug(drug);
		orderResponse.setUser(user);
		
		return orderResponse;
	}

	@Override
	public List<Order> getAllOrders() {

		return orderRepo.findAll();
	}

	@Override
	public void deletAllOrder(Order order) {
		orderRepo.deleteAll();

	}

	public List<Order> findByDoctorId(String id) {

		return orderRepo.findAllByUserId(id);

	}

	// -------------------------For retrieving User details from
	// UserManagement----------------------

	public User getUserDetailsByUserId(String Email) throws OrderException {

		String userManagementServiceUrl = "http://localhost:8081/User/get/{Email}";// using Url from the user
																					// microservice we are getting the
																					// User details

		ResponseEntity<User> response = restTemplate.getForEntity(userManagementServiceUrl, User.class, Email);

		if (response.getStatusCode().is2xxSuccessful()) {

			return response.getBody(); // Return the retrieved Crop

		} else {

			throw new OrderException("userId " + Email + " is not valid");

		}

	}

	// -------------------for retrieving Drug details

	public Drug getDrugDetailsByDrugId(long drugId) throws OrderException {

		String drugManagementServiceUrl = "http://localhost:8082/Drug/get/{drugId}";// using Url from the user
																					// microservice we are getting the
																					// User details

		ResponseEntity<Drug> response = restTemplate.getForEntity(drugManagementServiceUrl, Drug.class, drugId);

		if (response.getStatusCode().is2xxSuccessful()) {

			return response.getBody(); // Return the retrieved

		} else {

			throw new OrderException("drugId" + drugId + " is not valid");

		}

	}

}
