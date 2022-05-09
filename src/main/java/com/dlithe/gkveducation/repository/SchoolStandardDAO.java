package com.dlithe.gkveducation.repository;

import com.dlithe.gkveducation.entity.SchoolStandardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolStandardDAO extends JpaRepository<SchoolStandardEntity, Integer> {
}
