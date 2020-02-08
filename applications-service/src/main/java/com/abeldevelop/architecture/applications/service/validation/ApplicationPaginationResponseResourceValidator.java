package com.abeldevelop.architecture.applications.service.validation;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.applications.dto.application.ApplicationPaginationResponseResource;
import com.abeldevelop.architecture.applications.service.config.ErrorCodeProperties;
import com.abeldevelop.architecture.library.common.exception.server.ValidationResponseException;
import com.abeldevelop.architecture.library.common.factory.validation.ValidationResource;
import com.abeldevelop.architecture.library.common.validation.PaginationResponseResourceValidation;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ApplicationPaginationResponseResourceValidator implements ValidationResource {

	private final ErrorCodeProperties errorCodeProperties;
	private final ApplicationResponseResourceValidator applicationResponseResourceValidator;
	private final PaginationResponseResourceValidation paginationResponseResourceValidation;
	
	@Override
	public boolean areYouTheElement(String elementName) {
		return ApplicationPaginationResponseResource.class.getCanonicalName().equals(elementName);
	}

	@Override
	public void validate(Object toValidate) {
		ApplicationPaginationResponseResource applicationPaginationResponseResource = (ApplicationPaginationResponseResource) toValidate;
		validatePagination(applicationPaginationResponseResource);
		validateErrorMessages(applicationPaginationResponseResource);
	}

	private void validatePagination(ApplicationPaginationResponseResource applicationPaginationResponseResource) {
		paginationResponseResourceValidation.validate(applicationPaginationResponseResource.getPagination());
	}
	
	private void validateErrorMessages(ApplicationPaginationResponseResource applicationPaginationResponseResource) {
		if(applicationPaginationResponseResource.getApplications() == null) {
			throw new ValidationResponseException(errorCodeProperties.getApplicationPaginationResponseResourceApplicationsNotNull());
		}
		applicationPaginationResponseResource.getApplications().stream().forEach(applicationResponseResourceValidator::validate);
	}
	
}
