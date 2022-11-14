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

import com.cg.aps.entity.DeliveryEntity;
import com.cg.aps.service.IDeliveryService;


@RestController
public class DeliveryController {
	
	@Autowired
	IDeliveryService deliveryService;
	
	//Logger logger=LoggerFactory.getLogger(DeliveryController.class);
	
	@PostMapping("/delivery/add")
	ResponseEntity<DeliveryEntity>  addDelivery(@RequestBody DeliveryEntity delivery) 
	{
		DeliveryEntity newDelivery  = deliveryService.addDelivery(delivery);
		return new ResponseEntity<>(newDelivery, HttpStatus.CREATED);
	}
	
	@GetMapping("/delivery/get/{deliveryId}")
	ResponseEntity<DeliveryEntity> getDeliveryById(@PathVariable int deliveryId) 
	{
		//logger.info("Calling deliveryService getDeliveryById() method");
		DeliveryEntity delivery = deliveryService.getDeliveryById(deliveryId);
		//logger.info("Got response from delivery service");
		return new ResponseEntity<>(delivery, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delivery/delete/{deliveryId}")
    ResponseEntity<DeliveryEntity> deleteDelivery(@PathVariable int deliveryId) 
	{
    	DeliveryEntity delivery = deliveryService.deleteDelivery(deliveryId);
    	return new ResponseEntity<>(delivery, HttpStatus.OK);
	}	
	
	@PutMapping("/delivery/update/{deliveryId}")
	ResponseEntity<DeliveryEntity> updateDelivery(@PathVariable int deliveryId, @RequestBody DeliveryEntity delivery) 
	{
		DeliveryEntity updatedDelivery = deliveryService.updateDelivery(deliveryId, delivery);
		return new ResponseEntity<>(updatedDelivery,HttpStatus.OK);
	}
	
	
	@GetMapping("/delivery/searchAll")
	ResponseEntity<List<DeliveryEntity>> searchAllDelivery()
	{
		List<DeliveryEntity> deliveryList = deliveryService.searchAllDelivery();
		return new ResponseEntity<>(deliveryList,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/delivery/findByOwnerName/{ownerName}")
	ResponseEntity<List<DeliveryEntity>> findDeliveryByName(@PathVariable("ownerName") String ownerName)
	{
		List<DeliveryEntity> deliveryList = deliveryService.findDeliveryByName(ownerName);
		return new ResponseEntity<>(deliveryList, HttpStatus.OK);
	}
	
	
	@GetMapping("/delivery/paginationAndSort/{pageNo}/{pageSize}/{field}")
  	ResponseEntity<Page<DeliveryEntity>> searchDeliveryWithPaginationAndSorting(@PathVariable("pageNo") int pageNo,
  			@PathVariable("pageSize") int pageSize, @PathVariable("field") String field) {
  		Page<DeliveryEntity> deliveries = deliveryService.searchDeliveryWithPaginationAndSorting(pageNo, pageSize, field);
  		return new ResponseEntity<>(deliveries, HttpStatus.OK);
  	}
	 
}
