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

import com.cg.aps.entity.GuardSalaryEntity;
import com.cg.aps.service.IGuardSalaryService;

@RestController
public class GuardSalaryController {

	@Autowired
	IGuardSalaryService gsServ;
	
	// Add guardSalary
	@PostMapping("/guardSalary/add")
	ResponseEntity<GuardSalaryEntity> addGuardSalary(@RequestBody GuardSalaryEntity gs) {
		System.out.println(gs);
		GuardSalaryEntity newGs = gsServ.addGuardSalary(gs);
		System.out.println(newGs);
		ResponseEntity<GuardSalaryEntity> response = new ResponseEntity<>(newGs, HttpStatus.CREATED); // 201 Created
		return response;
	};
	
	//update guardSalary
	@PutMapping("/guardSalary/update/{guardId}")
    ResponseEntity<GuardSalaryEntity> updateGuardSalary(@PathVariable int guardId, @RequestBody GuardSalaryEntity gs) {
    	GuardSalaryEntity updatedGs = gsServ.updateGuardSalary(gs, guardId);
    	return new ResponseEntity<>(updatedGs, HttpStatus.OK);
    };
    
    @DeleteMapping("/guardSalary/delete/{guardId}")
    ResponseEntity<GuardSalaryEntity> deleteGuardSalaryById(@PathVariable int guardId) {
    	GuardSalaryEntity gs = gsServ.deleteGuardSalaryById(guardId);
    	return new ResponseEntity<>(gs, HttpStatus.OK); // 200 Ok
    };
	
    // Get GuardSalary by id
 	@GetMapping("/guardSalary/get/{guardId}")
     ResponseEntity<GuardSalaryEntity> getGuardSalaryById(@PathVariable int guardId) {
     	GuardSalaryEntity gs = gsServ.getGuardSalaryById(guardId);
     	return new ResponseEntity<>(gs, HttpStatus.OK); // 200 Ok
     };
     
     //Get GuardSalary by name
     @GetMapping("/guardSalary/findByName/{guardName}")
     ResponseEntity<List<GuardSalaryEntity>> getGuardSalaryByName(@PathVariable("guardName") String name) {
     	List<GuardSalaryEntity> gsList = gsServ.getGuardSalaryByName(name);
     	return new ResponseEntity<>(gsList, HttpStatus.OK);
     }; 
     
     //Get all guardSalaries
     @GetMapping("/guardSalaries/findAll")
     ResponseEntity<List<GuardSalaryEntity>> searchAllGuardSalaries() {
     	List<GuardSalaryEntity> gsList = gsServ.searchAllGuardSalaries();
     	return new ResponseEntity<>(gsList, HttpStatus.OK);
     };
     
     @GetMapping("/guardSalary/paginationAndSort/{pageNo}/{pageSize}/{field}")
     ResponseEntity<Page<GuardSalaryEntity>> searchGuardSalaryWithPaginationAndSorting(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, @PathVariable("field") String field) {
    	 Page<GuardSalaryEntity> guardSalaries = gsServ.searchGuardSalaryWithPaginationAndSorting(pageNo, pageSize, field);
    	 return new ResponseEntity<>(guardSalaries, HttpStatus.OK);
     }
}
