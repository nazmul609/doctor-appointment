package com.peytosoft.AdminService.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peytosoft.AdminService.Model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{

}
