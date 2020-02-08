package com.abeldevelop.architecture.applications.service.service.v1.impl;

import org.springframework.stereotype.Service;

import com.abeldevelop.architecture.applications.service.domain.Application;
import com.abeldevelop.architecture.applications.service.service.v1.CreateApplicationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateApplicationServiceImpl implements CreateApplicationService {
	
	@Override
	public Application executeCreate(Application application) {
		
		//TODO => Validate the permisions
		
		return null;
	}

}
