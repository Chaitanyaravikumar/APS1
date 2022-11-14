package com.cg.aps.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.aps.entity.VehicleEntity;

public interface IVehicleService {
	
	
	VehicleEntity addVehicle(VehicleEntity vehicle);

	VehicleEntity updateVehicle(String vehicleNo, VehicleEntity vehicle);

	VehicleEntity deleteVehicle(String vehicleNo);

	VehicleEntity findByVehicleNo(String vehicleNo);
	
	List<VehicleEntity> findVehicleByOwnerName(String ownerName);
	
	List<VehicleEntity> searchAllVehicle();
	
	Page<VehicleEntity> searchVehicleWithPaginationAndSorting(int pageNo, int pageSize, String field);

}
