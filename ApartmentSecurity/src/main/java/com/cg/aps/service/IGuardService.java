package com.cg.aps.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.aps.entity.GuardEntity;

public interface IGuardService {

	GuardEntity addGuard(GuardEntity g);
	GuardEntity updateGuard(GuardEntity g, int guardId);
	GuardEntity deleteGuardById(int guardId);
	List<GuardEntity> getGuardByName(String guardName);
	GuardEntity getGuardById(int guardId);
	List<GuardEntity> searchAllGuards();
	Page<GuardEntity> searchGuardWithPaginationAndSorting(int pageNo, int pageSize, String field);
}
