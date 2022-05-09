package com.dlithe.gkveducation.repository;

import com.dlithe.gkveducation.entity.TeachersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachersDAO extends JpaRepository<TeachersEntity, Integer> {
}
