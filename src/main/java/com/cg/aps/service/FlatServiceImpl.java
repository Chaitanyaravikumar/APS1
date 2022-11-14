package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

// import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.aps.entity.FlatEntity;
import com.cg.aps.repository.IFlatEntityRepository;

@Service("FlatService")
// @Transactional

public class FlatServiceImpl implements IFlatService {
	
	@Autowired
	IFlatEntityRepository fRepo;
	
	@Override
	public FlatEntity add(FlatEntity bean) {

		return fRepo.save(bean);
	}

	@Override
	public FlatEntity update(FlatEntity bean) {

		return fRepo.save(bean);
	}

	@Override
	public void delete(String id) {
		
		fRepo.deleteById(id);
	}

	@Override
	public List<FlatEntity> findByName(String name) {
		
		return fRepo.findByOwnerName(name);
	}

	@Override
	public Optional<FlatEntity> findByPk(String id) {
		
		return fRepo.findByFlatNo(id);
	}

	@Override
	public List<FlatEntity> search(FlatEntity bean, long pageNo, int pageSize) {
		
		return null;
	}

	@Override
	public List<FlatEntity> search() {

		return fRepo.findAll();
	}

}
