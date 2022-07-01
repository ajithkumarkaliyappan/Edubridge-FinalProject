package com.laptopshopping.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptopshopping.exception.ResourceNotFoundException;
import com.laptopshopping.model.Admin;
import com.laptopshopping.repository.AdminRepository;
import com.laptopshopping.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin registerAdmin(Admin admin)  {
		// TODO Auto-generated method stub
	return adminRepository.save(admin);
	}

	@Override
	public Admin loginAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.findByAdminEmailIdAndAdminPassword(admin.adminEmailId, admin.adminPassword)
				.orElseThrow(() -> new ResourceNotFoundException("Admin", "AdminId",
						admin.adminEmailId + " and " + admin.adminPassword));
	}

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public Admin updateAdmin(Admin admin, int adminId) {
		// TODO Auto-generated method stub
		Admin existingAdmin = adminRepository.findById(adminId).orElseThrow(() -> new ResourceNotFoundException("Admin",
				"AdminId", admin.adminEmailId + " and " + admin.adminPassword));
		existingAdmin.setAdminFirstName(admin.getAdminFirstName());
		existingAdmin.setAdminLastName(admin.getAdminLastName());
		existingAdmin.setAdminEmailId(admin.getAdminEmailId());
		existingAdmin.setAdminPassword(admin.getAdminPassword());
		adminRepository.save(existingAdmin);
		return existingAdmin;
	}

	@Override
	public Admin getByAdminId(int adminId) {
		// TODO Auto-generated method stub
		return adminRepository.findById(adminId).orElseThrow(
				() -> new ResourceNotFoundException("Admin", "AdminId", "no admin is available with this id"));
	}

	@Override
	public void deleteAdmin(int adminId) {
		// TODO Auto-generated method stub
		adminRepository.findById(adminId).orElseThrow(() -> new ResourceNotFoundException("Admin", "AdminId", adminId));
		adminRepository.deleteById(adminId);

	}

}
