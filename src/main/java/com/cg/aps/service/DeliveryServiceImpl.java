package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.aps.entity.DeliveryEntity;
import com.cg.aps.repository.IDeliveryRepository;

@Service
public class DeliveryServiceImpl implements IDeliveryService {
	
	
	@Autowired
	IDeliveryRepository deliveryRepository; 
	
	//***adding the delivery entity values***
	@Override
	public DeliveryEntity addDelivery(DeliveryEntity delivery) {
			//logger.info("Add Delivery method....");
			DeliveryEntity newDelivery =  deliveryRepository.save(delivery);
			return newDelivery;
	}
	
	//***get delivery details findbyId***
	@Override
	public DeliveryEntity getDeliveryById(int deliveryId) {
		//logger.info("Inside getDelivery by id method....");
		Optional<DeliveryEntity> opt = deliveryRepository.findById(deliveryId);
		DeliveryEntity delivery = null;
		if (opt.isPresent()){
			delivery = opt.get();
		}
		return delivery;
	}
	
	
	//***updating the values***
	@Override
	public DeliveryEntity updateDelivery(int deliveryId, DeliveryEntity delivery) {
		//logger.info("Updating Delivery method....");
		Optional<DeliveryEntity> opt = deliveryRepository.findById(deliveryId);
		if (opt.isPresent()) {
			deliveryRepository.save(delivery);
		}
		return delivery;
	}
	
	//***deleting the values***
	@Override
	public DeliveryEntity deleteDelivery(int deliveryId) {
		//logger.info("Deleting Delivery method....")
		Optional<DeliveryEntity> opt = deliveryRepository.findById(deliveryId);
		DeliveryEntity delivery = null;
		if (opt.isPresent()) {
			delivery = opt.get();
			deliveryRepository.deleteById(deliveryId);
		}
		return delivery;
	}
	
	//***getting values by owner name***
	@Override
	public List<DeliveryEntity> findDeliveryByName(String ownerName) {
		return deliveryRepository.findByOwnerName(ownerName);
	}
	
	//***getting all values***
	@Override
	public List<DeliveryEntity> searchAllDelivery() {
		//logger.info("Get all Delivery records method....");
		List<DeliveryEntity> deliveryList = deliveryRepository.findAll(); 
		return deliveryList;
	}
	
	//***getting all values with pagination and sorting***
	@Override
	public Page<DeliveryEntity> searchDeliveryWithPaginationAndSorting(int pageNo, int pageSize, String field) {
		Page<DeliveryEntity> deliveries = deliveryRepository.findAll(PageRequest.of(pageNo, pageSize).withSort(Sort.Direction.ASC, field));
		return deliveries;
	}


}
