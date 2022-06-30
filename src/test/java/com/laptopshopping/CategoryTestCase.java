package com.laptopshopping;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import com.laptopshopping.model.Category;
import com.laptopshopping.repository.CategoryRepository;

@SpringBootTest
class CategoryTestCase {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	@Disabled
	@Order(1)
	public void addCategory() {
		Category category = new Category();
		category.setCategoryName("normal");
		category.setCategoryDiscription("low end devices");
		assertNotNull(categoryRepository.save(category));
	}
	
	@Test
	//@Disabled
	@Order(2)
	public void getAllCategory() {
		List<Category> category = categoryRepository.findAll();
		assertThat(category).size().isGreaterThan(0);
	}
	
	@Test
	//@Disabled
	@Order(3)
	public void getCategoryById() {
		Category category = categoryRepository.findById(151).get();
		assertThat(category.getCategoryId()).isEqualTo(151);
	}
	
	@Test
	//@Disabled
	@Order(4)
	public void updateCategory() {
		Category category = categoryRepository.findById(151).get();
		category.setCategoryName("basic");
		Category updatedCategory = categoryRepository.save(category);
		assertThat(updatedCategory.categoryName);
	}

	@Test
	@Disabled
	@Order(5)
	public void deleteCategory() {
		Category category = categoryRepository.findById(2).get();
		categoryRepository.delete(category);
	}
}
