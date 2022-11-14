package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.aps.entity.VehicleEntity;
import com.cg.aps.repository.IVehicleRepository;

@Service
public class VehicleServiceImpl implements IVehicleService {
	
	@Autowired
	IVehicleRepository vehicleRepository;
	
	@Override
	public VehicleEntity addVehicle(VehicleEntity vehicle) {
		///logger.info("Add Vehicle method....");
		VehicleEntity newVehicle=  vehicleRepository.save(vehicle);
		return newVehicle;
	}

	@Override
	public VehicleEntity updateVehicle(String vehicleNo, VehicleEntity vehicle) {
		
		//logger.info("Updating Vehicle Entity method....");
		Optional<VehicleEntity> opt = vehicleRepository.findById(vehicleNo);
		if (opt.isPresent()) {
			vehicleRepository.save(vehicle);
		}
		return vehicle;
	}

	@Override
	public VehicleEntity deleteVehicle(String vehicleNo) {
		
		//logger.info("Deleting Delivery method....")
		Optional<VehicleEntity> opt = vehicleRepository.findById(vehicleNo);
		VehicleEntity vehicle = null;
		if (opt.isPresent()) {
			vehicle = opt.get();
			vehicleRepository.deleteById(vehicleNo);
		}
		return vehicle;
	}

	@Override
	public VehicleEntity findByVehicleNo(String vehicleNo) {
		//logger.info("Inside getVehicle by VehicleNo method....");
		Optional<VehicleEntity> opt = vehicleRepository.findById(vehicleNo);
		VehicleEntity vehicle = null;
		if (opt.isPresent()){
			vehicle = opt.get();
		}
		return vehicle;
	}
	
	@Override
	public List<VehicleEntity> findVehicleByOwnerName(String ownerName) {
		return vehicleRepository.findByOwnerName(ownerName);
	}


	@Override
	public List<VehicleEntity> searchAllVehicle() {
		
		//logger.info("Get all Delivery records method....");
		List<VehicleEntity> vehicleList = vehicleRepository.findAll(); 
		return vehicleList;
		 
	}

	@Override
	public Page<VehicleEntity> searchVehicleWithPaginationAndSorting(int pageNo, int pageSize, String field) {
		
		Page<VehicleEntity> vehicles = vehicleRepository.findAll(PageRequest.of(pageNo, pageSize).withSort(Sort.Direction.ASC, field));
		return vehicles;
		
	}
	
}
