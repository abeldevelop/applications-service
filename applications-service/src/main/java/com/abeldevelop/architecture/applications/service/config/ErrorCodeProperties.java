package com.abeldevelop.architecture.applications.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
@ConfigurationProperties("applications-error-code")
public class ErrorCodeProperties {

	private String applicationNameNotNull;
	private String applicationNameNameSize;
	private String applicationDescriptionNotNull;
	private String applicationDescriptionSize;
	private String applicationEnabledNotNull;
	private String applicationHomeUriNotNull;
	private String applicationHomeUriSize;
	private String applicationDocumentationUrlNotNull;
	private String applicationDocumentationUrlSize;
	private String applicationVersionNotNull;
	private String applicationPaginationResponseResourceApplicationsNotNull;
	
}