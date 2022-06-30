package com.laptopshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptopshopping.model.Category;
import com.laptopshopping.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/addcategory/{adminId}")
	public ResponseEntity<Category> addCategory(@RequestBody Category category, @PathVariable("adminId") int adminId) {
			return new ResponseEntity<Category>(categoryService.addCategory(category,adminId), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Category> getAllProduct() {
		return categoryService.getAllCategory();
	}

	@GetMapping("{categoryId}")
	public ResponseEntity<Category> getCategoryById(@RequestBody Category category,
			@PathVariable("categoryId") int categoryId) {
		return new ResponseEntity<Category>(categoryService.getCategoryById(categoryId), HttpStatus.OK);
	}

	@PutMapping("{categoryId}")
	public ResponseEntity<Category> updateCategory(@PathVariable("categoryId") int categoryId,
			@RequestBody Category category) {
		return new ResponseEntity<Category>(categoryService.updateCategory(category, categoryId), HttpStatus.OK);
	}

	@DeleteMapping("{categoryId}")
	public ResponseEntity<String> deleteCategoryById(@PathVariable("categoryId") int categoryId) {
		categoryService.deleteCategoryById(categoryId);
		return new ResponseEntity<String>("category deleted successfully ", HttpStatus.OK);
	}

}
