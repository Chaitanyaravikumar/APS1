package com.cg.aps.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.FlatEntity;

@Repository
public interface IFlatEntityRepository extends JpaRepository<FlatEntity, String>
{
	List<FlatEntity> findByOwnerName(String name);
	Optional<FlatEntity> findByFlatNo(String id);
}
