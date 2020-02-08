package com.abeldevelop.architecture.applications.service.validation;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.applications.dto.application.ApplicationFieldsSizeConstants;
import com.abeldevelop.architecture.applications.dto.application.ApplicationResponseResource;
import com.abeldevelop.architecture.applications.service.config.ErrorCodeProperties;
import com.abeldevelop.architecture.library.common.exception.server.ValidationResponseException;
import com.abeldevelop.architecture.library.common.factory.validation.ValidationResource;
import com.abeldevelop.architecture.library.common.util.StringUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ApplicationResponseResourceValidator implements ValidationResource {

	private final ErrorCodeProperties errorCodeProperties;

	@Override
	public boolean areYouTheElement(String elementName) {
		return ApplicationResponseResource.class.getCanonicalName().equals(elementName);
	}

	@Override
	public void validate(Object toValidate) {
		ApplicationResponseResource applicationResponseResource = (ApplicationResponseResource) toValidate;
		validateId(applicationResponseResource);
		validateName(applicationResponseResource);
		validateDescription(applicationResponseResource);
		validateEnabled(applicationResponseResource);
		validateHomeUri(applicationResponseResource);
		validateDocumentationUrl(applicationResponseResource);
		validateVersion(applicationResponseResource);
	}

	private void validateId(ApplicationResponseResource applicationResponseResource) {
		if(applicationResponseResource.getVersion() == null) {
			throw new ValidationResponseException(errorCodeProperties.getApplicationVersionNotNull());
		}
	}
	
	private void validateName(ApplicationResponseResource applicationResponseResource) {
		if(StringUtils.isEmpty(applicationResponseResource.getName())) {
			throw new ValidationResponseException(errorCodeProperties.getApplicationNameNotNull());
		}
		if(!StringUtils.isSizeBetween(applicationResponseResource.getName(), ApplicationFieldsSizeConstants.NAME_MIN_SIZE, ApplicationFieldsSizeConstants.NAME_MAX_SIZE)) {
			throw new ValidationResponseException(errorCodeProperties.getApplicationNameNameSize(), Arrays.asList(ApplicationFieldsSizeConstants.NAME_MIN_SIZE, ApplicationFieldsSizeConstants.NAME_MAX_SIZE));
		}
	}

	private void validateDescription(ApplicationResponseResource applicationResponseResource) {
		if(StringUtils.isEmpty(applicationResponseResource.getDescription())) {
			throw new ValidationResponseException(errorCodeProperties.getApplicationDescriptionNotNull());
		}
		if(!StringUtils.isSizeBetween(applicationResponseResource.getDescription(), ApplicationFieldsSizeConstants.DESCRIPTION_MIN_SIZE, ApplicationFieldsSizeConstants.DESCRIPTION_MAX_SIZE)) {
			throw new ValidationResponseException(errorCodeProperties.getApplicationDescriptionSize(), Arrays.asList(ApplicationFieldsSizeConstants.DESCRIPTION_MIN_SIZE, ApplicationFieldsSizeConstants.DESCRIPTION_MAX_SIZE));
		}
	}

	private void validateEnabled(ApplicationResponseResource applicationResponseResource) {
		if(applicationResponseResource.getEnabled() == null) {
			throw new ValidationResponseException(errorCodeProperties.getApplicationEnabledNotNull());
		}
	}

	private void validateHomeUri(ApplicationResponseResource applicationResponseResource) {
		if(StringUtils.isEmpty(applicationResponseResource.getHomeUri())) {
			throw new ValidationResponseException(errorCodeProperties.getApplicationHomeUriNotNull());
		}
		if(!StringUtils.isSizeBetween(applicationResponseResource.getHomeUri(), ApplicationFieldsSizeConstants.HOME_URI_MIN_SIZE, ApplicationFieldsSizeConstants.HOME_URI_MAX_SIZE)) {
			throw new ValidationResponseException(errorCodeProperties.getApplicationHomeUriSize(), Arrays.asList(ApplicationFieldsSizeConstants.HOME_URI_MIN_SIZE, ApplicationFieldsSizeConstants.HOME_URI_MAX_SIZE));
		}
	}

	private void validateDocumentationUrl(ApplicationResponseResource applicationResponseResource) {
		if(StringUtils.isEmpty(applicationResponseResource.getDocumentationUrl())) {
			throw new ValidationResponseException(errorCodeProperties.getApplicationDocumentationUrlNotNull());
		}
		if(!StringUtils.isSizeBetween(applicationResponseResource.getDocumentationUrl(), ApplicationFieldsSizeConstants.DOCUMENTATION_URL_MIN_SIZE, ApplicationFieldsSizeConstants.DOCUMENTATION_URL_MAX_SIZE)) {
			throw new ValidationResponseException(errorCodeProperties.getApplicationDocumentationUrlSize(), Arrays.asList(ApplicationFieldsSizeConstants.DOCUMENTATION_URL_MIN_SIZE, ApplicationFieldsSizeConstants.DOCUMENTATION_URL_MAX_SIZE));
		}
	}
	
	private void validateVersion(ApplicationResponseResource applicationResponseResource) {
		if(applicationResponseResource.getVersion() == null) {
			throw new ValidationResponseException(errorCodeProperties.getApplicationVersionNotNull());
		}
	}
}
