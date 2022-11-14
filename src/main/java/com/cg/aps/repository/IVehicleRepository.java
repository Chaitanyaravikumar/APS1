package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.VehicleEntity;

@Repository
public interface IVehicleRepository extends JpaRepository<VehicleEntity, String>{
	
	List<VehicleEntity> findByOwnerName(String ownerName);
}
