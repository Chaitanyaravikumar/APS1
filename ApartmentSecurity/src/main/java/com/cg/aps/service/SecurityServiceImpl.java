package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.aps.entity.SecurityEntity;
import com.cg.aps.repository.ISecurityRepository;

@Service("SecurityService")
//@Transactional
public class SecurityServiceImpl implements ISecurityService {

	@Autowired
	ISecurityRepository sRepo;
	@Override
	public SecurityEntity add(SecurityEntity bean) {
	
		return sRepo.save(bean);
	}

	@Override
	public SecurityEntity update(SecurityEntity bean) {
		
		return sRepo.save(bean);
	}

	@Override
	public void delete(int id) {
			sRepo.deleteById(id);
	}

	@Override
	public Optional<SecurityEntity> findByPk(Integer id) {
		
		return sRepo.findByAlertId(id);
	}

	@Override
	public List<SecurityEntity> search(Integer pageNo, Integer pageSize) {
		
		return null;
	}

	@Override
	public List<SecurityEntity> search() {
		
		return sRepo.findAll();
	}

}
