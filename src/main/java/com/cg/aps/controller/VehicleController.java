package com.cg.aps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.aps.entity.VehicleEntity;
import com.cg.aps.service.IVehicleService;


@RestController
public class VehicleController {
	
	
	@Autowired
	IVehicleService vehicleService;
	
	//Logger logger=LoggerFactory.getLogger(VehicleController.class);
	
	@PostMapping("/vehicle/add")
	ResponseEntity<VehicleEntity>  addVehicle(@RequestBody VehicleEntity vehicle) 
	{
		VehicleEntity newVehicle  = vehicleService.addVehicle(vehicle);
		return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
	}
	
	@GetMapping("/vehicle/get/{vehicleNo}")
	ResponseEntity<VehicleEntity> findVehicleByVehicleNo(@PathVariable String vehicleNo) 
	{
		//logger.info("Calling VehicleService findVehicleByVehicleNo() method");
		VehicleEntity vehicle = vehicleService.findByVehicleNo(vehicleNo);
		//logger.info("Got response from vehicle service");
		return new ResponseEntity<>(vehicle, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/vehicle/delete/{vehicleNo}")
    ResponseEntity<VehicleEntity> deleteDelivery(@PathVariable String vehicleNo) 
	{
    	VehicleEntity vehicle = vehicleService.deleteVehicle(vehicleNo);
    	return new ResponseEntity<>(vehicle, HttpStatus.OK);
	}	
	
	@PutMapping("/vehicle/update/{vehicleNo}")
	ResponseEntity<VehicleEntity> updateVehicle(@PathVariable String vehicleNo, @RequestBody VehicleEntity vehicle) 
	{
		VehicleEntity updatedVehicle = vehicleService.updateVehicle(vehicleNo, vehicle);
		return new ResponseEntity<>(updatedVehicle,HttpStatus.OK);
	}
	
	
	@GetMapping("/vehicle/searchAll")
	ResponseEntity<List<VehicleEntity>> searchAllVehicle()
	{
		List<VehicleEntity> vehicleList = vehicleService.searchAllVehicle();
		return new ResponseEntity<>(vehicleList,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/vehicle/findByOwnerName/{ownerName}")
	ResponseEntity<List<VehicleEntity>> findVehicleByOwnerName(@PathVariable("ownerName") String ownerName)
	{
		List<VehicleEntity> vehicleList = vehicleService.findVehicleByOwnerName(ownerName);
		return new ResponseEntity<>(vehicleList, HttpStatus.OK);
	}
	
	
	@GetMapping("/vehicle/paginationAndSort/{pageNo}/{pageSize}/{field}")
  	ResponseEntity<Page<VehicleEntity>> searchVehicleWithPaginationAndSorting(@PathVariable("pageNo") int pageNo,
  			@PathVariable("pageSize") int pageSize, @PathVariable("field") String field) {
  		Page<VehicleEntity> vehicles = vehicleService.searchVehicleWithPaginationAndSorting(pageNo, pageSize, field);
  		return new ResponseEntity<>(vehicles, HttpStatus.OK);
  	}
	

}
