package com.cg.aps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.cg.aps.entity.SecurityEntity;

@Repository
public interface ISecurityRepository extends JpaRepository<SecurityEntity,Integer> 
{

	Optional<SecurityEntity> findByAlertId (Integer id);
}
