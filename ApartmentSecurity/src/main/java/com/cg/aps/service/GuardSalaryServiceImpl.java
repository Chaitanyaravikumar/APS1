package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.aps.entity.GuardSalaryEntity;
import com.cg.aps.repository.IGuardSalaryRepository;

@Service
public class GuardSalaryServiceImpl implements IGuardSalaryService {
	
	@Autowired
	IGuardSalaryRepository gsRepo;

	@Override
	public GuardSalaryEntity addGuardSalary(GuardSalaryEntity gs) {
		// Add gs to db
		GuardSalaryEntity newgs = gsRepo.save(gs);
		// return newly added gs obj
		return newgs;
	}

	@Override
	public GuardSalaryEntity updateGuardSalary(GuardSalaryEntity gs, int guardId) {
		Optional<GuardSalaryEntity> opt = gsRepo.findById(guardId);
		if(opt.isPresent()) {
			// update guardSalary
			gsRepo.save(gs);
		} 
		return gs;
	}

	@Override
	public GuardSalaryEntity deleteGuardSalaryById(int guardId) {
		Optional<GuardSalaryEntity> opt = gsRepo.findById(guardId);
		GuardSalaryEntity gs=null;
		if(opt.isPresent()) {
			// Read GuardSalary obj from Optional
			gs = opt.get();
			gsRepo.deleteById(guardId);
		}	
		return gs;
	}
	
	@Override
	public GuardSalaryEntity getGuardSalaryById(int guardId) {
		Optional<GuardSalaryEntity> opt = gsRepo.findById(guardId);
		GuardSalaryEntity gs=null;
		if(opt.isPresent()) {
			// Read GuardSalary obj from Optional
			gs = opt.get();
		}	
		return gs;
	}

	@Override
	public List<GuardSalaryEntity> getGuardSalaryByName(String guardName) {
		return gsRepo.findByGuardName(guardName);
	}

	@Override
	public List<GuardSalaryEntity> searchAllGuardSalaries() {
		List<GuardSalaryEntity> gsList = gsRepo.findAll();
		return gsList;
	}

	@Override
	public Page<GuardSalaryEntity> searchGuardSalaryWithPaginationAndSorting(int pageNo, int pageSize, String field) {
		Page<GuardSalaryEntity> guardSalaries = gsRepo.findAll(PageRequest.of(pageNo, pageSize).withSort(Sort.Direction.ASC, field));
		return guardSalaries;
	}

}
