package com.cg.aps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.aps.entity.UserEntity;
import com.cg.aps.service.IUserService;



@RestController
public class UserController 
{

	@Autowired
	IUserService userServ;
	
	// Add user
		@PostMapping("/user/add")
		ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user) {
			System.out.println(user);
			UserEntity newUser = userServ.addUser(user);
			System.out.println(newUser);
			ResponseEntity<UserEntity> response = new ResponseEntity<>(newUser, HttpStatus.CREATED); // 201 Created
			return response;
		}
	
		//update user
		@PutMapping("/user/update/{loginId}")
	    ResponseEntity<UserEntity> updateUser(@PathVariable("loginId") String loginId, @RequestBody UserEntity user) {
	    	UserEntity updatedUser = userServ.updateUser(user, loginId);
	    	return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	    }
	    
		//delete user
	    @DeleteMapping("/user/delete/{loginId}")
	    ResponseEntity<UserEntity> deleteUserById(@PathVariable("loginId") String loginId) {
	    	UserEntity user = userServ.deleteUserById(loginId);
	    	return new ResponseEntity<>(user, HttpStatus.OK); // 200 Ok
	    }
	
	     // find User by id
		 	@GetMapping("/user/get/{loginId}")
		     ResponseEntity<UserEntity> findByLoginId(@PathVariable("loginId") String loginId) {
		     	UserEntity user = userServ.findByLoginId(loginId);
		     	return new ResponseEntity<>(user, HttpStatus.OK); // 200 Ok
		     }
		     
		 //Get all users
		    @GetMapping("/user/findAll")
		    ResponseEntity<List<UserEntity>> searchAllUsers() {
		     List<UserEntity> userList = userServ.searchAllUsers();
		     return new ResponseEntity<>(userList, HttpStatus.OK);
		     } 
		     
		  //register user
		     @PostMapping("/user/register")
		     ResponseEntity<UserEntity> registerUser(@RequestBody UserEntity user) {
					System.out.println(user);
					UserEntity newUser = userServ.addUser(user);
					System.out.println(newUser);
					return new ResponseEntity<>(newUser, HttpStatus.CREATED); // 201 Created
					
				}
		     
		     
		 //forgot password
		     
		     
		     
//		   //authenticate users
//		     @GetMapping("/user/authenticate/{loginId}")
//		    ResponseEntity<UserEntity> getUserAuthentication(@RequestBody UserEntity user) { 
//		    	userServ.authenticate(user);
//				return new ResponseEntity<>("Logged In",HttpStatus.OK);
//		    }
		     
		     
		   //change password
		     @PostMapping("/user/change/password/{loginId}")
		     ResponseEntity<UserEntity> changePassword(@PathVariable("loginId") String loginId, @RequestBody String password)
		     {
			    	UserEntity updatedUser = userServ.changePassword(loginId, password);
			    	return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		     }
		     
		     //search with pagination and sorting
		     @GetMapping("/user/paginationAndSort/{pageNo}/{pageSize}/{field}")
		   	ResponseEntity<Page<UserEntity>> searchUserWithPaginationAndSorting(@PathVariable("pageNo") int pageNo,
		   			@PathVariable("pageSize") int pageSize, @PathVariable("field") String field) {
		   		Page<UserEntity> user = userServ.searchUserWithPaginationAndSorting(pageNo, pageSize, field);
		   		return new ResponseEntity<>(user, HttpStatus.OK);
		   	}
		 	
		     
}   
		     
