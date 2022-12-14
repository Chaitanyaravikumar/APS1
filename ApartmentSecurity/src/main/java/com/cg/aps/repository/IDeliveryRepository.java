package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.DeliveryEntity;
@Repository
public interface IDeliveryRepository extends JpaRepository<DeliveryEntity, Integer>
{
List<DeliveryEntity> findByOwnerName(String ownerName);
	
	DeliveryEntity findByDeliveryId(int id);
}
