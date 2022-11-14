package com.cg.aps.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.aps.entity.DeliveryEntity;

public interface IDeliveryService {
	
	DeliveryEntity addDelivery(DeliveryEntity delivery);

	DeliveryEntity updateDelivery(int deliveryId, DeliveryEntity delivery);

	DeliveryEntity deleteDelivery(int deliveryId);

	List<DeliveryEntity> findDeliveryByName(String ownerName);

	DeliveryEntity getDeliveryById(int deliveryId);

	List<DeliveryEntity> searchAllDelivery();
	
	Page<DeliveryEntity> searchDeliveryWithPaginationAndSorting(int pageNo, int pageSize, String field);

	
}
