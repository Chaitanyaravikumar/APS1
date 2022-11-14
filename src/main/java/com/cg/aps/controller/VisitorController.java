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

import com.cg.aps.entity.VisitorEntity;
import com.cg.aps.service.IVisitorService;

@RestController
public class VisitorController {
	@Autowired
	IVisitorService visitorService;
	
	//Logger logger=LoggerFactory.getLogger(VisitorController.class);
	
	@PostMapping("/visitor/add")
	ResponseEntity<VisitorEntity>  addVisitor(@RequestBody VisitorEntity visitor) 
	{
		VisitorEntity newVisitor  = visitorService.addVisitor(visitor);
		return new ResponseEntity<>(newVisitor, HttpStatus.CREATED);
	}
	
	@GetMapping("/visitor/get/{visitorNo}")
	ResponseEntity<VisitorEntity> findVisitorByVisitorNo(@PathVariable String visitorNo) 
	{
		//logger.info("Calling VisitorService findVisitorByVisitorNo() method");
		VisitorEntity visitor = visitorService.findByVisitorNo(visitorNo);
		//logger.info("Got response from visitor service");
		return new ResponseEntity<>(visitor, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/visitor/delete/{visitorNo}")
    ResponseEntity<VisitorEntity> deleteDelivery(@PathVariable String visitorNo) 
	{
    	VisitorEntity visitor = visitorService.deleteVisitor(visitorNo);
    	return new ResponseEntity<>(visitor, HttpStatus.OK);
	}	
	
	@PutMapping("/visitor/update/{visitorNo}")
	ResponseEntity<VisitorEntity> updateVisitor(@PathVariable String visitorNo, @RequestBody VisitorEntity visitor) 
	{
		VisitorEntity updatedVisitor = visitorService.updateVisitor(visitorNo, visitor);
		return new ResponseEntity<>(updatedVisitor,HttpStatus.OK);
	}
	
	
	@GetMapping("/visitor/searchAll")
	ResponseEntity<List<VisitorEntity>> searchAllVisitor()
	{
		List<VisitorEntity> visitorList = visitorService.searchAllVisitor();
		return new ResponseEntity<>(visitorList,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/visitor/findByOwnerName/{ownerName}")
	ResponseEntity<List<VisitorEntity>> findVisitorByOwnerName(@PathVariable("ownerName") String ownerName)
	{
		List<VisitorEntity> visitorList = visitorService.findVisitorByOwnerName(ownerName);
		return new ResponseEntity<>(visitorList, HttpStatus.OK);
	}
	
	
	@GetMapping("/visitor/paginationAndSort/{pageNo}/{pageSize}/{field}")
  	ResponseEntity<Page<VisitorEntity>> searchVisitorWithPaginationAndSorting(@PathVariable("pageNo") int pageNo,
  			@PathVariable("pageSize") int pageSize, @PathVariable("field") String field) {
  		Page<VisitorEntity> visitors = visitorService.searchVisitorWithPaginationAndSorting(pageNo, pageSize, field);
  		return new ResponseEntity<>(visitors, HttpStatus.OK);
  	}
	
}
