package com.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.entity.Order;
import com.orderservice.entity.OrderResponse;
import com.orderservice.exception.OrderException;
import com.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {
	@Autowired
	private OrderService orderService;

		@PostMapping("/addOrder")
	public ResponseEntity<Order> add(@RequestBody Order order) throws Exception {
		Order order1 = orderService.addOrder(order);
		return new ResponseEntity<>(order1, HttpStatus.OK);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Order> update(@PathVariable int id) throws OrderException {
		Order order1 = orderService.updateOrder(id);
		return new ResponseEntity<>(order1, HttpStatus.OK);

	}

	@DeleteMapping("/delet/{orderId}")
	public ResponseEntity<String> delet(@PathVariable int orderId) {
		orderService.deletOrder(orderId);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}

	@GetMapping("/get/{orderId}")
	public ResponseEntity<?> get(@PathVariable int orderId) throws OrderException {
		OrderResponse use = orderService.getOrder(orderId);
		return new ResponseEntity<>(use, HttpStatus.OK);

	}

	@GetMapping("/get")
	public ResponseEntity<List<Order>> getAll() {
		List<Order> ref = orderService.getAllOrders();
		return new ResponseEntity<List<Order>>(ref, HttpStatus.OK);

	}

	@GetMapping("/getorders/{id}")
	public ResponseEntity<List<Order>> getByid(@PathVariable String id) {
		List<Order> ord = orderService.findByDoctorId(id);
		return new ResponseEntity<List<Order>>(ord, HttpStatus.OK);

	}
}
