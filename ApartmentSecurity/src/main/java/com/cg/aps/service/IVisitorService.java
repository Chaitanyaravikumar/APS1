package com.cg.aps.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.aps.entity.VisitorEntity;

public interface IVisitorService {
	
	VisitorEntity addVisitor(VisitorEntity visitor);

	VisitorEntity updateVisitor(String visitorNo, VisitorEntity visitor);

	VisitorEntity deleteVisitor(String visitorNo);

	VisitorEntity findByVisitorNo(String visitorNo);
		
	List<VisitorEntity> findVisitorByOwnerName(String ownerName);
		
	List<VisitorEntity> searchAllVisitor();
		
	Page<VisitorEntity> searchVisitorWithPaginationAndSorting(int pageNo, int pageSize, String field);


}
