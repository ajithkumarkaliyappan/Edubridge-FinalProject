package com.laptopshopping.repository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptopshopping.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

//	Optional<Product> findByCategoryId(int categoryId);
}
