package com.laptopshopping.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.laptopshopping.model.Admin;

import com.laptopshopping.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/register")
	public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminService.registerAdmin(admin), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminService.loginAdmin(admin), HttpStatus.OK);
	}

	@GetMapping
	public List<Admin> getAllAdmin() {
		return adminService.getAllAdmin();
	}

	@GetMapping("{adminId}")
	public ResponseEntity<Admin> getByAdminId(@PathVariable("adminId") int adminId, @RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminService.getByAdminId(adminId), HttpStatus.FOUND);
	}

	@PutMapping("{adminId}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable("adminId") int adminId, @RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminService.updateAdmin(admin, adminId), HttpStatus.OK);
	}

	@DeleteMapping("{adminId}")
	public ResponseEntity<String> deleteAdminById(@PathVariable("adminId") int adminId) {
		adminService.deleteAdmin(adminId);
		return new ResponseEntity<String>("admin deleted successfully ", HttpStatus.OK);
	}


}
