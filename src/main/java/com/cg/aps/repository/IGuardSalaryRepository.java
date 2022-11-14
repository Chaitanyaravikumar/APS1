package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.GuardSalaryEntity;

@Repository
public interface IGuardSalaryRepository extends JpaRepository<GuardSalaryEntity, Integer> {

	List<GuardSalaryEntity> findByGuardName(String name);
}
