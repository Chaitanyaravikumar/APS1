package com.cg.aps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.aps.entity.GuardEntity;
import com.cg.aps.service.IGuardService;

@RestController
public class GuardController {

	@Autowired
	IGuardService gServ;
	
	// Add guard
	@PostMapping("/guard/add")
	ResponseEntity<GuardEntity> addGuard(@RequestBody GuardEntity g) {
		System.out.println(g);
		GuardEntity newG = gServ.addGuard(g);
		System.out.println(newG);
		ResponseEntity<GuardEntity> response = new ResponseEntity<>(newG, HttpStatus.CREATED); // 201 Created
		return response;
	};
	
	//update guard
	@PutMapping("/guard/update/{guardId}")
    ResponseEntity<GuardEntity> updateGuard(@PathVariable int guardId, @RequestBody GuardEntity g) {
    	GuardEntity updatedG = gServ.updateGuard(g, guardId);
    	return new ResponseEntity<>(updatedG, HttpStatus.OK);
    };
    
    @DeleteMapping("/guard/delete/{guardId}")
    ResponseEntity<GuardEntity> deleteGuardById(@PathVariable int guardId) {
    	GuardEntity g = gServ.deleteGuardById(guardId);
    	return new ResponseEntity<>(g, HttpStatus.OK); // 200 Ok
    };
	
    // Get Guard by id
 	@GetMapping("/guard/get/{guardId}")
     ResponseEntity<GuardEntity> getGuardById(@PathVariable int guardId) {
     	GuardEntity g = gServ.getGuardById(guardId);
     	return new ResponseEntity<>(g, HttpStatus.OK); // 200 Ok
     };
     
     //Get Guard by name
     @GetMapping("/guard/findByName/{guardName}")
     ResponseEntity<List<GuardEntity>> getGuardByName(@PathVariable("guardName") String name) {
     	List<GuardEntity> gList = gServ.getGuardByName(name);
     	return new ResponseEntity<>(gList, HttpStatus.OK);
     }; 
     
     //Get all guards
     @GetMapping("/guard/findAll")
     ResponseEntity<List<GuardEntity>> searchAllGuards() {
     	List<GuardEntity> gList = gServ.searchAllGuards();
     	return new ResponseEntity<>(gList, HttpStatus.OK);
     };
     
     @GetMapping("/guard/paginationAndSort/{pageNo}/{pageSize}/{field}")
     ResponseEntity<Page<GuardEntity>> searchGuardWithPaginationAndSorting(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, @PathVariable("field") String field) {
    	 Page<GuardEntity> guards = gServ.searchGuardWithPaginationAndSorting(pageNo, pageSize, field);
    	 return new ResponseEntity<>(guards, HttpStatus.OK);
     }
}
