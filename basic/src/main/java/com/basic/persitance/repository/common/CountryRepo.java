package com.basic.persitance.repository.common;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.basic.extensible.CurrentStatus;
import com.basic.persitance.model.common.Country;
import com.basic.web.dto.common.IdName;

public interface CountryRepo extends JpaRepository<Country, Long> {
	@Query(value = "SELECT new com.basic.web.dto.common.IdName(c.id,c.name) FROM Country c WHERE c.currentStatus=:currentStatus")
	public List<IdName> getActiveIdName(@Param("currentStatus") CurrentStatus currentStatus);
}
