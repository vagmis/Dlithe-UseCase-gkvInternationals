package com.dlithe.gkveducation.repository;

import com.dlithe.gkveducation.entity.AdminLoginEntity;
import com.dlithe.gkveducation.entity.TeachersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminLoginDAO extends JpaRepository<AdminLoginEntity, Integer> {

    @Query(value = "SELECT * FROM admin_login WHERE admin_login_name=?1 AND admin_login_password=?2", nativeQuery = true)
     AdminLoginEntity addedUser(String adminLoginName, String adminLoginPassword);

    @Query(value = "SELECT * FROM admin_login" , nativeQuery = true)
    List<AdminLoginEntity> getAdmins();
}
