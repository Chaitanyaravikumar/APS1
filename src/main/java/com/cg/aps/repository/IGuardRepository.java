package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.GuardEntity;

@Repository
public interface IGuardRepository extends JpaRepository<GuardEntity, Integer> {

	List<GuardEntity> findByGuardName(String name);
}
