package com.cg.aps.service;

import java.util.List;

import org.springframework.data.domain.Page;

//import org.h2.mvstore.Page;

import com.cg.aps.entity.UserEntity;


public interface IUserService 
{
	UserEntity addUser(UserEntity user);
	
	UserEntity updateUser(UserEntity user, String loginId);
	
	UserEntity deleteUserById(String loginId);
	
	UserEntity findByLoginId(String loginId);
	
	List<UserEntity> searchAllUsers();
	
	Page<UserEntity> searchUserWithPaginationAndSorting(int pageNo, int pageSize, String field);
	
//	UserEntity authenticateUser(UserEntity user, String loginId);
	
	//forget password
	
	UserEntity changePassword(String loginId, String newPassword) ;
    
	UserEntity registerUser(UserEntity user);

   
}

