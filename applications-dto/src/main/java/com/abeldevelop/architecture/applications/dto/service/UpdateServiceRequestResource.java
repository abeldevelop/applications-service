package com.abeldevelop.architecture.applications.dto.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description="Update Service resource")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class UpdateServiceRequestResource {

	@ApiModelProperty(notes="Name of the service", example="applications-service", required = true, position = 1)
	@NotNull
	@Size(min = ServiceFieldsSizeConstants.SERVICE_NAME_MIN_SIZE, max = ServiceFieldsSizeConstants.SERVICE_NAME_MAX_SIZE)
	private String name;
	
	@ApiModelProperty(notes="Port of the service", example="8001", required = true, position = 2)
	private Integer port;
	
	@ApiModelProperty(notes="Git repository url", example="http://github.com/repository", required = true, position = 3)
	@NotNull
	@Size(min = ServiceFieldsSizeConstants.GIT_URL_MIN_SIZE, max = ServiceFieldsSizeConstants.GIT_URL_MAX_SIZE)
	private String gitUrl;
	
	@ApiModelProperty(notes="Documentation of the service", example="http://github.com/wiki/repository", required = true, position = 4)
	@NotNull
	@Size(min = ServiceFieldsSizeConstants.DOCUMENTATION_URL_MIN_SIZE, max = ServiceFieldsSizeConstants.DOCUMENTATION_URL_MAX_SIZE)
	private String documentationUrl;
	
}
