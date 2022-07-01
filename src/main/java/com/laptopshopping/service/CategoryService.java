package com.laptopshopping.service;

import java.util.List;

import com.laptopshopping.model.Category;

public interface CategoryService {

	Category addCategory(Category category,int adminId);

	List<Category> getAllCategory();

	Category updateCategory(Category category, int CategoryId);

	Category getCategoryById(int categoryId);

	void deleteCategoryById(int categoryId);
}
