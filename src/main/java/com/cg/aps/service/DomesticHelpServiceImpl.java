package com.cg.aps.service;
//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import java.util.Optional;
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.aps.entity.DomesticHelpEntity;
import com.cg.aps.repository.IDomesticHelpRepository;

@Service
public class DomesticHelpServiceImpl implements IDomesticHelpService {
	@Autowired
	IDomesticHelpRepository domesticRepo;
	
	@Override
	//add domestic help
	public DomesticHelpEntity add(DomesticHelpEntity dhelp) {
		return domesticRepo.save(dhelp);
	}

	@Override
	public DomesticHelpEntity updateDomesticHelp(DomesticHelpEntity dhelp, String flatNo) {
		Optional<DomesticHelpEntity> opt = domesticRepo.findByFlatNo(flatNo);
		if(opt.isPresent()) {
			//update user
			domesticRepo.save(dhelp);
			}
		return dhelp;
	}
	
	
	@Override
	public DomesticHelpEntity findByName(String name) {
		return domesticRepo.findByName(name);
	}

	@Override
	public DomesticHelpEntity findByFlatNo(String flatNo) {
		Optional<DomesticHelpEntity> opt = domesticRepo.findById(flatNo);
		DomesticHelpEntity dhelp=null;
		if(opt.isPresent()) {
			//Read User obj from Optional
			dhelp = opt.get();
		}
		return dhelp;
	}

	@Override
	public DomesticHelpEntity deleteByFlatNo(String flatNo) {
		Optional<DomesticHelpEntity> opt = domesticRepo.findById(flatNo);
		DomesticHelpEntity dhelp=null;
		if(opt.isPresent()) {
			//Read User obj from Optional
			dhelp = opt.get();
			domesticRepo.deleteByFlatNo(flatNo);
		}
		return dhelp;
	}

	//***getting all values with pagination and sorting***
		@Override
		public Page<DomesticHelpEntity> searchDomesticHelpWithPaginationAndSorting(int pageNo, int pageSize, String field) {
			Page<DomesticHelpEntity> dhelp = domesticRepo.findAll(PageRequest.of(pageNo, pageSize).withSort(Sort.Direction.ASC, field));
			return dhelp;
		}


	@Override
	public List<DomesticHelpEntity> searchAllDomesticHelp() {
		List<DomesticHelpEntity> dhelpList = domesticRepo.findAll();
		return dhelpList;
	}

}
