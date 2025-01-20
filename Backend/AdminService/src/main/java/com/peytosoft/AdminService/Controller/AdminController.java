package com.peytosoft.AdminService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peytosoft.AdminService.Model.Admin;
import com.peytosoft.AdminService.Service.AdminService;



@RestController
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("addAdmin")
    public ResponseEntity<String> addAdmin(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }

}
