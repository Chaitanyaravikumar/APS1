package com.cg.aps.repository;

import com.cg.aps.entity.UserEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, String>
{
	UserEntity firstName(String firstName);

	UserEntity emailId(String email);

	Optional<UserEntity> findById(String loginId);
	
}
