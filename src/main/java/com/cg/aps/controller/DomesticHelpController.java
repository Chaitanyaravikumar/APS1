package com.cg.aps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.aps.entity.DomesticHelpEntity;
import com.cg.aps.service.IDomesticHelpService;


@RestController
public class DomesticHelpController {
	
	@Autowired
	IDomesticHelpService domestichelpServ;
	
	// Add domestic help 
			@PostMapping("/domestichelp/add")
			ResponseEntity<DomesticHelpEntity> addDomesticHelp(@RequestBody DomesticHelpEntity dhelp) {
				System.out.println(dhelp);
				DomesticHelpEntity newDomesticHelp = domestichelpServ.add(dhelp);
				System.out.println(newDomesticHelp);
				ResponseEntity<DomesticHelpEntity> response = new ResponseEntity<>(newDomesticHelp, HttpStatus.CREATED); // 201 Created
				return response;
			}
			
			
	//update domestic help
			@PutMapping("/domestichelp/update/{flatNo}")
		    ResponseEntity<DomesticHelpEntity> updateUser(@PathVariable("flatNo") String flatNo, @RequestBody DomesticHelpEntity domestichelp) {
				DomesticHelpEntity updatedDomesticHelp = domestichelpServ.updateDomesticHelp(domestichelp, flatNo);
		    	return new ResponseEntity<>(updatedDomesticHelp, HttpStatus.OK);
		    }
			
			
    //delete domestic help by flatno
			@DeleteMapping("/domestichelp/delete/{flatNo}")
		    ResponseEntity<DomesticHelpEntity> deleteDomesticHelpById(@PathVariable("flatNo") String flatNo) {
				DomesticHelpEntity dhelp = domestichelpServ.deleteByFlatNo(flatNo);
		    	return new ResponseEntity<>(dhelp, HttpStatus.OK); // 200 Ok
		    }
			
	//find domestic help by name
			@GetMapping("/domestichelp/get/{name}")
		     ResponseEntity<DomesticHelpEntity> findByName(@PathVariable("name") String name) {
				DomesticHelpEntity dhelp = domestichelpServ.findByName(name);
		     	return new ResponseEntity<>(dhelp, HttpStatus.OK); // 200 Ok
		     }
			
			
	//find dhelp by flatno
			@GetMapping("/domestichelp/get/{flatNo}")
		     ResponseEntity<DomesticHelpEntity> findByFlatNo(@PathVariable("flatNo") String flatNo) {
				DomesticHelpEntity dhelp = domestichelpServ.findByFlatNo(flatNo);
		     	return new ResponseEntity<>(dhelp, HttpStatus.OK); // 200 Ok
		     }
			
			
	//list search all
			@GetMapping("/domestichelp/searchAll")
		    ResponseEntity<List<DomesticHelpEntity>> searchAll() {
		     List<DomesticHelpEntity> DomesticHelpList = domestichelpServ.searchAllDomesticHelp();
		     return new ResponseEntity<>(DomesticHelpList, HttpStatus.OK);
		     } 
			
	//List search(DomesticHelp dhelp, long pageNo, int pageSize)
}  