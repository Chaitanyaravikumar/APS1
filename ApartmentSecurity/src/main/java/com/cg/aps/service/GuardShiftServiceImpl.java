package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.aps.entity.GuardShiftEntity;
import com.cg.aps.repository.IGuardShiftRepository;

@Service
public class GuardShiftServiceImpl implements IGuardShiftService {

	@Autowired
	IGuardShiftRepository gshRepo;

	@Override
	public GuardShiftEntity addGuardShift(GuardShiftEntity gsh) {
		// Add gsh to db
		GuardShiftEntity newgsh = gshRepo.save(gsh);
		// return newly added gsh obj
		return newgsh;
	}

	@Override
	public GuardShiftEntity updateGuardShift(GuardShiftEntity gsh, int guardId) {
		Optional<GuardShiftEntity> opt = gshRepo.findById(guardId);
		if(opt.isPresent()) {
			// update guardShift
			gshRepo.save(gsh);
		} 
		return gsh;
	}

	@Override
	public GuardShiftEntity deleteGuardShiftById(int guardId) {
		Optional<GuardShiftEntity> opt = gshRepo.findById(guardId);
		GuardShiftEntity gsh=null;
		if(opt.isPresent()) {
			// Read GuardShift obj from Optional
			gsh = opt.get();
			gshRepo.deleteById(guardId);
		}	
		return gsh;
	}

	@Override
	public List<GuardShiftEntity> getGuardShiftByName(String guardName) {
		return gshRepo.findByGuardName(guardName);
	}

	@Override
	public GuardShiftEntity getGuardShiftById(int guardId) {
		Optional<GuardShiftEntity> opt = gshRepo.findById(guardId);
		GuardShiftEntity gsh=null;
		if(opt.isPresent()) {
			// Read GuardShift obj from Optional
			gsh = opt.get();
		}	
		return gsh;
	}

	@Override
	public List<GuardShiftEntity> searchAllGuardShifts() {
		List<GuardShiftEntity> gshList = gshRepo.findAll();
		return gshList;
	}

	@Override
	public Page<GuardShiftEntity> searchGuardShiftWithPaginationAndSorting(int pageNo, int pageSize, String field) {
		Page<GuardShiftEntity> guardShifts = gshRepo.findAll(PageRequest.of(pageNo, pageSize).withSort(Sort.Direction.ASC, field));
		return guardShifts;
	}
	
	
}
