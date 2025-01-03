package com.techlearn.service;

import com.techlearn.entity.*;
import com.techlearn.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class SampleDataService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public void addSampleData() {
        // Add Role
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setDescription("Administrator role");
        roleRepository.save(adminRole); // Lưu Role

        // Add User and set the role for the user
        User user = new User();
        user.setUsername("john_doe");
        user.setPassword("password123");
        user.setEmail("john.doe@example.com");
        user.setRole(adminRole); // Gán Role cho User
        userRepository.save(user); // Lưu User

        // Add Order
        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("Pending");
        order.setTotalPrice(new BigDecimal("100.00"));
        orderRepository.save(order);

        // Add OrderDetail
        OrderDetail detail = new OrderDetail();
        detail.setOrder(order);
        detail.setProductId(1);
        detail.setQuantity(2);
        detail.setUnitPrice(new BigDecimal("50.00"));
        detail.setSubtotal(new BigDecimal("100.00"));
        orderDetailRepository.save(detail);
    }
}
