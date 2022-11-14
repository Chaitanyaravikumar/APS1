package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.GuardShiftEntity;

@Repository
public interface IGuardShiftRepository extends JpaRepository<GuardShiftEntity, Integer> {

	List<GuardShiftEntity> findByGuardName(String name);
}
