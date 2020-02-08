package com.abeldevelop.architecture.applications.service.validation;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.applications.dto.application.ApplicationFieldsSizeConstants;
import com.abeldevelop.architecture.applications.dto.application.CreateApplicationRequestResource;
import com.abeldevelop.architecture.applications.service.config.ErrorCodeProperties;
import com.abeldevelop.architecture.library.common.exception.client.ValidationRequestException;
import com.abeldevelop.architecture.library.common.factory.validation.ValidationResource;
import com.abeldevelop.architecture.library.common.util.StringUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CreateApplicationRequestResourceValidator implements ValidationResource {

	private final ErrorCodeProperties errorCodeProperties;

	@Override
	public boolean areYouTheElement(String elementName) {
		return CreateApplicationRequestResource.class.getCanonicalName().equals(elementName);
	}

	@Override
	public void validate(Object toValidate) {
		CreateApplicationRequestResource createApplicationRequestResource = (CreateApplicationRequestResource) toValidate;
		validateName(createApplicationRequestResource);
		validateDescription(createApplicationRequestResource);
		validateEnabled(createApplicationRequestResource);
		validateHomeUri(createApplicationRequestResource);
		validateDocumentationUrl(createApplicationRequestResource);
	}

	private void validateName(CreateApplicationRequestResource createApplicationRequestResource) {
		if(StringUtils.isEmpty(createApplicationRequestResource.getName())) {
			throw new ValidationRequestException(errorCodeProperties.getApplicationNameNotNull());
		}
		if(!StringUtils.isSizeBetween(createApplicationRequestResource.getName(), ApplicationFieldsSizeConstants.NAME_MIN_SIZE, ApplicationFieldsSizeConstants.NAME_MAX_SIZE)) {
			throw new ValidationRequestException(errorCodeProperties.getApplicationNameNameSize(), Arrays.asList(ApplicationFieldsSizeConstants.NAME_MIN_SIZE, ApplicationFieldsSizeConstants.NAME_MAX_SIZE));
		}
	}

	private void validateDescription(CreateApplicationRequestResource createApplicationRequestResource) {
		if(StringUtils.isEmpty(createApplicationRequestResource.getDescription())) {
			throw new ValidationRequestException(errorCodeProperties.getApplicationDescriptionNotNull());
		}
		if(!StringUtils.isSizeBetween(createApplicationRequestResource.getDescription(), ApplicationFieldsSizeConstants.DESCRIPTION_MIN_SIZE, ApplicationFieldsSizeConstants.DESCRIPTION_MAX_SIZE)) {
			throw new ValidationRequestException(errorCodeProperties.getApplicationDescriptionSize(), Arrays.asList(ApplicationFieldsSizeConstants.DESCRIPTION_MIN_SIZE, ApplicationFieldsSizeConstants.DESCRIPTION_MAX_SIZE));
		}
	}

	private void validateEnabled(CreateApplicationRequestResource createApplicationRequestResource) {
		if(createApplicationRequestResource.getEnabled() == null) {
			throw new ValidationRequestException(errorCodeProperties.getApplicationEnabledNotNull());
		}
	}

	private void validateHomeUri(CreateApplicationRequestResource createApplicationRequestResource) {
		if(StringUtils.isEmpty(createApplicationRequestResource.getHomeUri())) {
			throw new ValidationRequestException(errorCodeProperties.getApplicationHomeUriNotNull());
		}
		if(!StringUtils.isSizeBetween(createApplicationRequestResource.getHomeUri(), ApplicationFieldsSizeConstants.HOME_URI_MIN_SIZE, ApplicationFieldsSizeConstants.HOME_URI_MAX_SIZE)) {
			throw new ValidationRequestException(errorCodeProperties.getApplicationHomeUriSize(), Arrays.asList(ApplicationFieldsSizeConstants.HOME_URI_MIN_SIZE, ApplicationFieldsSizeConstants.HOME_URI_MAX_SIZE));
		}
	}

	private void validateDocumentationUrl(CreateApplicationRequestResource createApplicationRequestResource) {
		if(StringUtils.isEmpty(createApplicationRequestResource.getDocumentationUrl())) {
			throw new ValidationRequestException(errorCodeProperties.getApplicationDocumentationUrlNotNull());
		}
		if(!StringUtils.isSizeBetween(createApplicationRequestResource.getDocumentationUrl(), ApplicationFieldsSizeConstants.DOCUMENTATION_URL_MIN_SIZE, ApplicationFieldsSizeConstants.DOCUMENTATION_URL_MAX_SIZE)) {
			throw new ValidationRequestException(errorCodeProperties.getApplicationDocumentationUrlSize(), Arrays.asList(ApplicationFieldsSizeConstants.DOCUMENTATION_URL_MIN_SIZE, ApplicationFieldsSizeConstants.DOCUMENTATION_URL_MAX_SIZE));
		}
	}
}
