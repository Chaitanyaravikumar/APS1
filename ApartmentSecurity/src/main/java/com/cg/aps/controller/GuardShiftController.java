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

import com.cg.aps.entity.GuardShiftEntity;
import com.cg.aps.service.IGuardShiftService;

@RestController
public class GuardShiftController {

	@Autowired
	IGuardShiftService gshServ;
	
	// Add guardShift
	@PostMapping("/guardShift/add")
	ResponseEntity<GuardShiftEntity> addGuardShift(@RequestBody GuardShiftEntity gsh) {
		System.out.println(gsh);
		GuardShiftEntity newGsh = gshServ.addGuardShift(gsh);
		System.out.println(newGsh);
		ResponseEntity<GuardShiftEntity> response = new ResponseEntity<>(newGsh, HttpStatus.CREATED); // 201 Created
		return response;
	};
	
	//update guardShift
	@PutMapping("/guardShift/update/{guardId}")
    ResponseEntity<GuardShiftEntity> updateGuardShift(@PathVariable int guardId, @RequestBody GuardShiftEntity gsh) {
    	GuardShiftEntity updatedGsh = gshServ.updateGuardShift(gsh, guardId);
    	return new ResponseEntity<>(updatedGsh, HttpStatus.OK);
    };
    
    @DeleteMapping("/guardShift/delete/{guardId}")
    ResponseEntity<GuardShiftEntity> deleteGuardShiftById(@PathVariable int guardId) {
    	GuardShiftEntity gsh = gshServ.deleteGuardShiftById(guardId);
    	return new ResponseEntity<>(gsh, HttpStatus.OK); // 200 Ok
    };
	
    // Get GuardShift by id
 	@GetMapping("/guardShift/get/{guardId}")
     ResponseEntity<GuardShiftEntity> getGuardShiftById(@PathVariable int guardId) {
     	GuardShiftEntity gsh = gshServ.getGuardShiftById(guardId);
     	return new ResponseEntity<>(gsh, HttpStatus.OK); // 200 Ok
     };
     
     //Get GuardShift by name
     @GetMapping("/guardShift/findByName/{guardName}")
     ResponseEntity<List<GuardShiftEntity>> getGuardShiftByName(@PathVariable("guardName") String name) {
     	List<GuardShiftEntity> gshList = gshServ.getGuardShiftByName(name);
     	return new ResponseEntity<>(gshList, HttpStatus.OK);
     }; 
     
     //Get all guardShifts
     @GetMapping("/guardShifts/findAll")
     ResponseEntity<List<GuardShiftEntity>> searchAllGuardShifts() {
     	List<GuardShiftEntity> gshList = gshServ.searchAllGuardShifts();
     	return new ResponseEntity<>(gshList, HttpStatus.OK);
     };
     
     @GetMapping("/guardShift/paginationAndSort/{pageNo}/{pageSize}/{field}")
     ResponseEntity<Page<GuardShiftEntity>> searchGuardShiftWithPaginationAndSorting(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, @PathVariable("field") String field) {
    	 Page<GuardShiftEntity> guardShifts = gshServ.searchGuardShiftWithPaginationAndSorting(pageNo, pageSize, field);
    	 return new ResponseEntity<>(guardShifts, HttpStatus.OK);
     }
}

