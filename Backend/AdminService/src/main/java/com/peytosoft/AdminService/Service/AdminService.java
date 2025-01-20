package com.peytosoft.AdminService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.peytosoft.AdminService.Dao.AdminRepository;
import com.peytosoft.AdminService.Model.Admin;


@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminDao;

	public ResponseEntity<String> addAdmin(Admin admin) {
		adminDao.save(admin);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

}
