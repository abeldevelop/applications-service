package com.abeldevelop.architecture.applications.service.service.v1.impl;

import org.springframework.stereotype.Service;

import com.abeldevelop.architecture.applications.service.domain.Application;
import com.abeldevelop.architecture.applications.service.service.v1.FindApplicationService;
import com.abeldevelop.architecture.library.common.domain.pagination.in.PaginationAndSortIn;
import com.abeldevelop.architecture.library.common.domain.pagination.out.PaginationResult;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindApplicationServiceImpl implements FindApplicationService {
	
	@Override
	public Application executeFindById(Long id) {
		return null;
	}

	@Override
	public PaginationResult<Application> executeFindAll(PaginationAndSortIn paginationAndSortIn, String name, Boolean enabled) {
		return null;
	}

}
