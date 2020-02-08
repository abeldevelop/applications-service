package com.abeldevelop.architecture.applications.service.service.v1;

import com.abeldevelop.architecture.applications.service.domain.Application;
import com.abeldevelop.architecture.library.common.domain.pagination.in.PaginationAndSortIn;
import com.abeldevelop.architecture.library.common.domain.pagination.out.PaginationResult;

public interface FindApplicationService {

	public Application executeFindById(Long id);
	
	public PaginationResult<Application> executeFindAll(PaginationAndSortIn paginationAndSortIn, String name, Boolean enabled);
	
}
