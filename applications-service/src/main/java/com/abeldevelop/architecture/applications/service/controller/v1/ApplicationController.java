package com.abeldevelop.architecture.applications.service.controller.v1;

import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RestController;

import com.abeldevelop.architecture.applications.api.v1.ApplicationApi;
import com.abeldevelop.architecture.applications.dto.application.ApplicationPaginationResponseResource;
import com.abeldevelop.architecture.applications.dto.application.ApplicationResponseResource;
import com.abeldevelop.architecture.applications.dto.application.ApplicationSort;
import com.abeldevelop.architecture.applications.dto.application.CreateApplicationRequestResource;
import com.abeldevelop.architecture.applications.dto.application.UpdateApplicationRequestResource;
import com.abeldevelop.architecture.applications.service.domain.Application;
import com.abeldevelop.architecture.applications.service.mapper.ApplicationMapper;
import com.abeldevelop.architecture.applications.service.mapper.ApplicationSortMapper;
import com.abeldevelop.architecture.applications.service.service.v1.CreateApplicationService;
import com.abeldevelop.architecture.applications.service.service.v1.DeleteApplicationService;
import com.abeldevelop.architecture.applications.service.service.v1.FindApplicationService;
import com.abeldevelop.architecture.applications.service.service.v1.UpdateApplicationService;
import com.abeldevelop.architecture.library.common.domain.pagination.in.PaginationAndSortIn;
import com.abeldevelop.architecture.library.common.domain.pagination.in.PaginationIn;
import com.abeldevelop.architecture.library.common.domain.pagination.out.PaginationResult;
import com.abeldevelop.architecture.library.common.factory.validation.ValidationFactory;
import com.abeldevelop.architecture.library.common.mapper.pagination.PaginationMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ApplicationController implements ApplicationApi {

	private final ValidationFactory validationFactory;
	private final ApplicationMapper applicationMapper;
	private final PaginationMapper paginationMapper;
	private final ApplicationSortMapper applicationSortMapper;
	private final CreateApplicationService createApplicationService;
	private final UpdateApplicationService updateApplicationService;
	private final DeleteApplicationService deleteApplicationService;
	private final FindApplicationService findApplicationService;
	
	@Override
	public ApplicationResponseResource executeCreate(CreateApplicationRequestResource createApplicationRequestResource) {
		log.info("ApplicationController.executeCreate Data IN => createApplicationRequestResource: {}", createApplicationRequestResource);
		validationFactory.validate(createApplicationRequestResource);
		ApplicationResponseResource applicationResponseResource = applicationMapper.mapDomainToResource(createApplicationService.executeCreate(applicationMapper.mapResourceToDomain(createApplicationRequestResource)));
		validationFactory.validate(applicationResponseResource);
		log.info("ApplicationController.executeCreate Data OUT => applicationResponseResource: {}", applicationResponseResource);
		return applicationResponseResource;
	}

	@Override
	public ApplicationResponseResource executeUpdate(Long id, UpdateApplicationRequestResource updateApplicationRequestResource) {
		log.info("ApplicationController.executeUpdate Data IN => id: {}, updateApplicationRequestResource: {}", id, updateApplicationRequestResource);
		validationFactory.validate(updateApplicationRequestResource);
		ApplicationResponseResource applicationResponseResource = applicationMapper.mapDomainToResource(updateApplicationService.executeUpdate(applicationMapper.mapResourceToDomain(id, updateApplicationRequestResource)));
		validationFactory.validate(applicationResponseResource);
		log.info("ApplicationController.executeUpdate Data OUT => applicationResponseResource: {}", applicationResponseResource);
		return applicationResponseResource;
	}

	@Override
	public void executeDelete(Long id) {
		log.info("ApplicationController.executeDelete Data IN => id: {}", id);
		deleteApplicationService.executeDelete(id);
		log.info("ApplicationController.executeDelete Data OUT => NO DATA");
	}

	@Override
	public ApplicationResponseResource executeFindById(Long id) {
		log.info("ApplicationController.executeFindById Data IN => id: {}", id);
		ApplicationResponseResource applicationResponseResource = applicationMapper.mapDomainToResource(findApplicationService.executeFindById(id));
		validationFactory.validate(applicationResponseResource);
		log.info("ApplicationController.executeFindById Data OUT => applicationResponseResource: {}", applicationResponseResource);
		return applicationResponseResource;
	}

	@Override
	public ApplicationPaginationResponseResource executeFindAll(Integer page, Integer size, ApplicationSort sort, String name, Boolean enabled) {
		log.info("ApplicationController.executeFindAll Data IN => page: {}, size: {}, sort: {}, name: {}, enabled: {}, code: {}", page, size, sort, name, enabled);
		PaginationIn paginationIn = paginationMapper.map(page, size);
		PaginationAndSortIn paginationAndSortIn = PaginationAndSortIn.builder()
				.pagination(paginationIn)
				.sort(applicationSortMapper.map(sort))
				.build();
		
		PaginationResult<Application> paginationResult = findApplicationService.executeFindAll(paginationAndSortIn, name, enabled);
		
		ApplicationPaginationResponseResource applicationPaginationResponseResource = ApplicationPaginationResponseResource.builder()
				.pagination(paginationMapper.map(paginationResult.getPagination()))
				.applications(paginationResult.getResults().stream().map(applicationMapper::mapDomainToResource).collect(Collectors.toList()))
				.build();
		
		validationFactory.validate(applicationPaginationResponseResource);
		log.info("ApplicationController.executeFindAll Data OUT => applicationPaginationResponseResource: {}", applicationPaginationResponseResource);
		return applicationPaginationResponseResource;
	}

}
