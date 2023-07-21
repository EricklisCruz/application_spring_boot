package com.projetodeestudo.course.service;

import com.projetodeestudo.course.models.entities.Order;
import com.projetodeestudo.course.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Order findOrderById(Integer id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
        return order;
    }
}
