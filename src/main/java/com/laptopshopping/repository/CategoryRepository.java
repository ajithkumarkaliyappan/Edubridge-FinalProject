package com.laptopshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptopshopping.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
