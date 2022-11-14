package com.cg.aps.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.aps.entity.GuardShiftEntity;

public interface IGuardShiftService {

	GuardShiftEntity addGuardShift(GuardShiftEntity gsh);
	GuardShiftEntity updateGuardShift(GuardShiftEntity gsh, int guardId);
	GuardShiftEntity deleteGuardShiftById(int guardId);
	List<GuardShiftEntity> getGuardShiftByName(String guardName);
	GuardShiftEntity getGuardShiftById(int guardId);
	List<GuardShiftEntity> searchAllGuardShifts();
	Page<GuardShiftEntity> searchGuardShiftWithPaginationAndSorting(int pageNo, int pageSize, String field);
}
