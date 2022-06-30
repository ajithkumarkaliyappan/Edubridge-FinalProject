package com.laptopshopping;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import com.laptopshopping.model.Admin;
import com.laptopshopping.repository.AdminRepository;

@SpringBootTest
class LaptopShopWebsiteApplicationTests {

	@Autowired
	private AdminRepository adminRepository;

	@Test
	@Order(1)
	@Disabled
	public void testCreateAdmin() {
		Admin admin = new Admin();
		admin.setAdminFirstName("ajith");
		admin.setAdminLastName("kumar");
		admin.setAdminEmailId("ajith@gmail.com");
		admin.setAdminPassword("Ajith@123");

		assertNotNull(adminRepository.save(admin));
	}

	@Test
	@Disabled
	@Order(2)
	public void loginAdmin() {

		Optional<Admin> admin = adminRepository.findByAdminEmailIdAndAdminPassword("ajith@gmail.com", "Ajith@123");

		Admin newAdmin = null;

		if (admin.isPresent()) {
			newAdmin = admin.get();
		}
		assertThat(newAdmin);

	}

	@Test
	@Disabled
	@Order(3)
	public void testReadAllAdmin() {
		List<Admin> admin = adminRepository.findAll();
		assertThat(admin).size().isGreaterThan(0);
	}

	@Test
	@Disabled
	@Order(4)
	public void updateAdmin() {

		Admin admin = adminRepository.findById(51).get();

		admin.setAdminLastName("Kumar");

		Admin updatedAdmin = adminRepository.save(admin);

		assertThat(updatedAdmin.adminLastName);
	}

	@Test
	//@Disabled
	@Order(5)
	public void getAdminById() {

		Admin admin = adminRepository.findById(51).get();

		assertThat(admin.getAdminId()).isEqualTo(51);
	}

	@Test
	@Disabled
	@Order(6)
	public void deleteAdmin() {
		Admin admin = adminRepository.findById(17).get();
		adminRepository.delete(admin);
	}

}
