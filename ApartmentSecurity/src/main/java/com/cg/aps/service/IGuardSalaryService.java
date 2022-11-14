package com.cg.aps.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.aps.entity.GuardSalaryEntity;

public interface IGuardSalaryService {

	GuardSalaryEntity addGuardSalary(GuardSalaryEntity gs);
	GuardSalaryEntity updateGuardSalary(GuardSalaryEntity gs, int guardId);
	GuardSalaryEntity deleteGuardSalaryById(int guardId);
	List<GuardSalaryEntity> getGuardSalaryByName(String guardName);
	GuardSalaryEntity getGuardSalaryById(int guardId);
	List<GuardSalaryEntity> searchAllGuardSalaries();
	Page<GuardSalaryEntity> searchGuardSalaryWithPaginationAndSorting(int pageNo, int pageSize, String field);
}
