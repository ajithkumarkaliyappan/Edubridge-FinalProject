package com.laptopshopping.service;

import java.util.List;

import com.laptopshopping.model.Admin;

public interface AdminService {
	Admin registerAdmin(Admin admin);

	Admin loginAdmin(Admin admin);

	List<Admin> getAllAdmin();

	Admin updateAdmin(Admin admin, int adminId);

	void deleteAdmin(int adminId);

	Admin getByAdminId(int adminId);

}
