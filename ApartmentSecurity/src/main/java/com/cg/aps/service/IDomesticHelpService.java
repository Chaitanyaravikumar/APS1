package com.cg.aps.service;
import java.util.List;
//import java.util.Optional;

import org.springframework.data.domain.Page;
import com.cg.aps.entity.DomesticHelpEntity;

public interface IDomesticHelpService
{
	DomesticHelpEntity add(DomesticHelpEntity dhelp);
	
	DomesticHelpEntity updateDomesticHelp(DomesticHelpEntity dhelp, String flatNo);
	
	DomesticHelpEntity deleteByFlatNo(String flatNo);
	
	DomesticHelpEntity findByName(String Name);
	
	DomesticHelpEntity findByFlatNo(String flatNo);
	
	List<DomesticHelpEntity> searchAllDomesticHelp();

	Page<DomesticHelpEntity> searchDomesticHelpWithPaginationAndSorting(int pageNo, int pageSize, String field);
	
}
