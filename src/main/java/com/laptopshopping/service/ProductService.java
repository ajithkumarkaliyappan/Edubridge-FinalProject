package com.laptopshopping.service;

import java.util.List;

import com.laptopshopping.model.Product;

public interface ProductService {

	Product addProduct( Product product,int adminId,int categoryId);

	List<Product> getAllProduct();

	Product updateProduct(Product product, int productId);

	Product getByProductId(int productId);

	//List<Product> getProductByCategoryId(int categoryId);

	void deleteProductById(int productId);
}
