package com.cg.aps.repository;


import com.cg.aps.entity.DomesticHelpEntity;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomesticHelpRepository extends JpaRepository<DomesticHelpEntity, String> 
{
	DomesticHelpEntity name(String name);

	DomesticHelpEntity findByName(String name);
	
	Optional<DomesticHelpEntity> deleteByFlatNo(String flatNo);

	Optional<DomesticHelpEntity> findByFlatNo(String flatNo);
}
