package com.laptopshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptopshopping.model.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
