package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.VisitorEntity;

@Repository
public interface IVisitorRepository extends JpaRepository<VisitorEntity, String>
{
	List<VisitorEntity> findByOwnerName(String ownerName);
}
