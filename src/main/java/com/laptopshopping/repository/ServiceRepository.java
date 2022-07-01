package com.laptopshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptopshopping.model.Service;



public interface ServiceRepository extends JpaRepository<Service,Integer> {

}
