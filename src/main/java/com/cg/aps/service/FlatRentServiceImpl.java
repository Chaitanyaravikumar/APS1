package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.aps.entity.FlatRentEntity;
import com.cg.aps.repository.IFlatRentRepository;

@Service("FlatRentService")
@Transactional

public class FlatRentServiceImpl implements IFlatRentService {
	

	@Autowired
	IFlatRentRepository frRepo;

	@Override
	public FlatRentEntity add(FlatRentEntity bean) {

		return frRepo.save(bean);
	}

	@Override
	public FlatRentEntity update(FlatRentEntity bean) {

		return frRepo.save(bean);
	}

	@Override
	public void delete(String id) {

		frRepo.deleteById(id);
	}

	@Override
	public List<FlatRentEntity> findByName(String name) {

		return frRepo.findByRenterName(name);
	}

	@Override
	public Optional<FlatRentEntity> findByPk(String id) {
		
		return frRepo.findByFlatId(id);
	}

	@Override
	public List<FlatRentEntity> search(FlatRentEntity bean, long pageNo, int pageSize) {
		
		return null;
	}

	@Override
	public List<FlatRentEntity> search() {
		
		return frRepo.findAll();
	}
	
	

}
