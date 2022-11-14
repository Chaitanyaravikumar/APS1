package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.aps.entity.UserEntity;
import com.cg.aps.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	IUserRepository userRepo;
	
	@Override
	public UserEntity addUser(UserEntity user) {
		UserEntity newUser = userRepo.save(user) ;
		return newUser;
	}

	@Override
	public UserEntity updateUser(UserEntity user, String loginId) {
		Optional<UserEntity> opt = userRepo.findById(loginId);
		if(opt.isPresent()) {
			//update user
			userRepo.save(user);
			}
		return user;
	}

	@Override
	public UserEntity deleteUserById(String loginId) {
		Optional<UserEntity> opt = userRepo.findById(loginId);
		UserEntity user=null;
		if(opt.isPresent()) {
			//Read User obj from Optional
			user = opt.get();
			userRepo.deleteById(loginId);
		}
		return user;
	}

	@Override
	public UserEntity findByLoginId(String loginId) {
		Optional<UserEntity> opt = userRepo.findById(loginId);
		UserEntity user=null;
		if(opt.isPresent()) {
			//Read User obj from Optional
			user = opt.get();
		}
		return user;
	}

	@Override
	public List<UserEntity> searchAllUsers() {
		List<UserEntity> userList = userRepo.findAll();
		return userList;
	}

	
	//login-email id , password
	@Override
		public UserEntity registerUser(UserEntity user) {
			UserEntity newUser = userRepo.save(user) ;
			return newUser;
	}
	

	//input == login id && password
//	@Override
//	public UserEntity authenticate(UserEntity user) {
//		
//		
//		return null;
//	
//	@Override
//	public UserEntity authenticateUser(UserEntity user, String loginId) {
//		return user.verify(user.getLoginId(),user.getPassword());
//	}
	
	
	@Override
	public UserEntity changePassword(String loginId, String newPassword) {
		
			Optional<UserEntity> opt = userRepo.findById(loginId);
			UserEntity updatedUser = null;
			if(opt.isPresent()) {
				UserEntity dbUser = opt.get();
				dbUser.setPassword(newPassword);
				updatedUser = userRepo.save(dbUser);
			
		}
			return updatedUser;
	}
	//@Override
	//public boolean forgetPassword(String login) {
		// TODO Auto-generated method stub
	//	return false;
	//}

	@Override
	public Page<UserEntity> searchUserWithPaginationAndSorting(int pageNo, int pageSize, String field) {
		
		Page<UserEntity> vehicles = userRepo.findAll(PageRequest.of(pageNo, pageSize).withSort(Sort.Direction.ASC, field));
		return vehicles;
		
	}

}
