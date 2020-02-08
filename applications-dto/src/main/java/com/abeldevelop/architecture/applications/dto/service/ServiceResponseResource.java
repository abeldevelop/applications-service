package com.abeldevelop.architecture.applications.dto.service;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description="Service resource")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ServiceResponseResource {

	@ApiModelProperty(notes="ID of the resource", example="1", required = true, position = 0)
    @NotNull
    private Long id;
	
	@ApiModelProperty(notes="Name of the service", example="applications-service", required = true, position = 1)
	@NotNull
	private String name;
	
	@ApiModelProperty(notes="Port of the service", example="8001", required = true, position = 2)
	@NotNull
	private Integer port;
	
	@ApiModelProperty(notes="Git repository url", example="http://github.com/repository", required = true, position = 3)
	@NotNull
	private String gitUrl;
	
	@ApiModelProperty(notes="Documentation of the service", example="http://github.com/wiki/repository", required = true, position = 4)
	@NotNull
	private String documentationUrl;
	
}
