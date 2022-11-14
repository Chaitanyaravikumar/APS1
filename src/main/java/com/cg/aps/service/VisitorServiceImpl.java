package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;


import com.cg.aps.entity.VisitorEntity;
import com.cg.aps.repository.IVisitorRepository;


@Service
public class VisitorServiceImpl implements IVisitorService {

	@Autowired
	IVisitorRepository visitorRepository;
	
	@Override
	public VisitorEntity addVisitor(VisitorEntity visitor) {
		///logger.info("Add Visitor method....");
		VisitorEntity newVisitor=  visitorRepository.save(visitor);
		return newVisitor;
	}

	@Override
	public VisitorEntity updateVisitor(String visitorNo, VisitorEntity visitor) {
		
		//logger.info("Updating Visitor Entity method....");
		Optional<VisitorEntity> opt = visitorRepository.findById(visitorNo);
		if (opt.isPresent()) {
			visitorRepository.save(visitor);
		}
		return visitor;
	}

	@Override
	public VisitorEntity deleteVisitor(String visitorNo) {
		
		//logger.info("Deleting Delivery method....")
		Optional<VisitorEntity> opt = visitorRepository.findById(visitorNo);
		VisitorEntity visitor = null;
		if (opt.isPresent()) {
			visitor = opt.get();
			visitorRepository.deleteById(visitorNo);
		}
		return visitor;
	}

	@Override
	public VisitorEntity findByVisitorNo(String visitorNo) {
		//logger.info("Inside getVisitor by VisitorNo method....");
		Optional<VisitorEntity> opt = visitorRepository.findById(visitorNo);
		VisitorEntity visitor = null;
		if (opt.isPresent()){
			visitor = opt.get();
		}
		return visitor;
	}
	
	@Override
	public List<VisitorEntity> findVisitorByOwnerName(String ownerName) {
		return visitorRepository.findByOwnerName(ownerName);
	}


	@Override
	public List<VisitorEntity> searchAllVisitor() {
		
		//logger.info("Get all Delivery records method....");
		List<VisitorEntity> visitorList = visitorRepository.findAll(); 
		return visitorList;
		 
	}

	@Override
	public Page<VisitorEntity> searchVisitorWithPaginationAndSorting(int pageNo, int pageSize, String field) {
		
		Page<VisitorEntity> visitors = visitorRepository.findAll(PageRequest.of(pageNo, pageSize).withSort(Sort.Direction.ASC , field));
		return visitors;
		
	}
		
	
}
