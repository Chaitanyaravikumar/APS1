package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.aps.entity.GuardEntity;
import com.cg.aps.repository.IGuardRepository;

@Service
public class GuardServiceImpl implements IGuardService {

	@Autowired
	IGuardRepository gRepo;

	@Override
	public GuardEntity addGuard(GuardEntity g) {
		// Add g to db
		GuardEntity newg = gRepo.save(g);
		// return newly added g ob
		return newg;
	}

	@Override
	public GuardEntity updateGuard(GuardEntity g, int guardId) {
		Optional<GuardEntity> opt = gRepo.findById(guardId);
		if(opt.isPresent()) {
			// update guard
			gRepo.save(g);
		} 
		return g;
	}

	@Override
	public GuardEntity deleteGuardById(int guardId) {
		Optional<GuardEntity> opt = gRepo.findById(guardId);
		GuardEntity g=null;
		if(opt.isPresent()) {
			// Read Guard obj from Optional
			g = opt.get();
			gRepo.deleteById(guardId);
		}	
		return g;
	}

	@Override
	public List<GuardEntity> getGuardByName(String guardName) {
		return gRepo.findByGuardName(guardName);
	}

	@Override
	public GuardEntity getGuardById(int guardId) {
		Optional<GuardEntity> opt = gRepo.findById(guardId);
		GuardEntity g=null;
		if(opt.isPresent()) {
			// Read Guard obj from Optional
			g = opt.get();
		}	
		return g;
	}

	@Override
	public List<GuardEntity> searchAllGuards() {
		List<GuardEntity> gList = gRepo.findAll();
		return gList;
	}

	@Override
	public Page<GuardEntity> searchGuardWithPaginationAndSorting(int pageNo, int pageSize, String field) {
		Page<GuardEntity> guards = gRepo.findAll(PageRequest.of(pageNo, pageSize).withSort(Sort.Direction.ASC, field));
		return guards;
	}
}
