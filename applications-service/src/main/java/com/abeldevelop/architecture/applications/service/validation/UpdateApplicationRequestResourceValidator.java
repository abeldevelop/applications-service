package com.abeldevelop.architecture.applications.service.validation;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.applications.dto.application.ApplicationFieldsSizeConstants;
import com.abeldevelop.architecture.applications.dto.application.UpdateApplicationRequestResource;
import com.abeldevelop.architecture.applications.service.config.ErrorCodeProperties;
import com.abeldevelop.architecture.library.common.exception.client.ValidationRequestException;
import com.abeldevelop.architecture.library.common.factory.validation.ValidationResource;
import com.abeldevelop.architecture.library.common.util.StringUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UpdateApplicationRequestResourceValidator implements ValidationResource {

	private final ErrorCodeProperties errorCodeProperties;

	@Override
	public boolean areYouTheElement(String elementName) {
		return UpdateApplicationRequestResource.class.getCanonicalName().equals(elementName);
	}

	@Override
	public void validate(Object toValidate) {
		UpdateApplicationRequestResource updateApplicationRequestResource = (UpdateApplicationRequestResource) toValidate;
		validateName(updateApplicationRequestResource);
		validateDescription(updateApplicationRequestResource);
		validateEnabled(updateApplicationRequestResource);
		validateHomeUri(updateApplicationRequestResource);
		validateDocumentationUrl(updateApplicationRequestResource);
		validateVersion(updateApplicationRequestResource);
	}

	private void validateName(UpdateApplicationRequestResource updateApplicationRequestResource) {
		if(StringUtils.isEmpty(updateApplicationRequestResource.getName())) {
			throw new ValidationRequestException(errorCodeProperties.getApplicationNameNotNull());
		}
		if(!StringUtils.isSizeBetween(updateApplicationRequestResource.getName(), ApplicationFieldsSizeConstants.NAME_MIN_SIZE, ApplicationFieldsSizeConstants.NAME_MAX_SIZE)) {
			throw new ValidationRequestException(errorCodeProperties.getApplicationNameNameSize(), Arrays.asList(ApplicationFieldsSizeConstants.NAME_MIN_SIZE, ApplicationFieldsSizeConstants.NAME_MAX_SIZE));
		}
	}

	private void validateDescription(UpdateApplicationRequestResource updateApplicationRequestResource) {
		if(StringUtils.isEmpty(updateApplicationRequestResource.getDescription())) {
			throw new ValidationRequestException(errorCodeProperties.getApplicationDescriptionNotNull());
		}
		if(!StringUtils.isSizeBetween(updateApplicationRequestResource.getDescription(), ApplicationFieldsSizeConstants.DESCRIPTION_MIN_SIZE, ApplicationFieldsSizeConstants.DESCRIPTION_MAX_SIZE)) {
			throw new ValidationRequestException(errorCodeProperties.getApplicationDescriptionSize(), Arrays.asList(ApplicationFieldsSizeConstants.DESCRIPTION_MIN_SIZE, ApplicationFieldsSizeConstants.DESCRIPTION_MAX_SIZE));
		}
	}

	private void validateEnabled(UpdateApplicationRequestResource updateApplicationRequestResource) {
		if(updateApplicationRequestResource.getEnabled() == null) {
			throw new ValidationRequestException(errorCodeProperties.getApplicationEnabledNotNull());
		}
	}

	private void validateHomeUri(UpdateApplicationRequestResource updateApplicationRequestResource) {
		if(StringUtils.isEmpty(updateApplicationRequestResource.getHomeUri())) {
			throw new ValidationRequestException(errorCodeProperties.getApplicationHomeUriNotNull());
		}
		if(!StringUtils.isSizeBetween(updateApplicationRequestResource.getHomeUri(), ApplicationFieldsSizeConstants.HOME_URI_MIN_SIZE, ApplicationFieldsSizeConstants.HOME_URI_MAX_SIZE)) {
			throw new ValidationRequestException(errorCodeProperties.getApplicationHomeUriSize(), Arrays.asList(ApplicationFieldsSizeConstants.HOME_URI_MIN_SIZE, ApplicationFieldsSizeConstants.HOME_URI_MAX_SIZE));
		}
	}

	private void validateDocumentationUrl(UpdateApplicationRequestResource updateApplicationRequestResource) {
		if(StringUtils.isEmpty(updateApplicationRequestResource.getDocumentationUrl())) {
			throw new ValidationRequestException(errorCodeProperties.getApplicationDocumentationUrlNotNull());
		}
		if(!StringUtils.isSizeBetween(updateApplicationRequestResource.getDocumentationUrl(), ApplicationFieldsSizeConstants.DOCUMENTATION_URL_MIN_SIZE, ApplicationFieldsSizeConstants.DOCUMENTATION_URL_MAX_SIZE)) {
			throw new ValidationRequestException(errorCodeProperties.getApplicationDocumentationUrlSize(), Arrays.asList(ApplicationFieldsSizeConstants.DOCUMENTATION_URL_MIN_SIZE, ApplicationFieldsSizeConstants.DOCUMENTATION_URL_MAX_SIZE));
		}
	}
	
	private void validateVersion(UpdateApplicationRequestResource updateApplicationRequestResource) {
		if(updateApplicationRequestResource.getVersion() == null) {
			throw new ValidationRequestException(errorCodeProperties.getApplicationVersionNotNull());
		}
	}
}
