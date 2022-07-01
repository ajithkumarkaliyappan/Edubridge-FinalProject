package com.laptopshopping.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptopshopping.model.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist,Integer> {
	Optional<Wishlist> findByWishlistId(Integer wishlistId);
}
