package com.abeldevelop.architecture.applications.dto.application;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.abeldevelop.architecture.applications.dto.service.ServiceResponseResource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

@ApiModel(description="Application resource")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ApplicationResponseResource {

	@ApiModelProperty(notes="ID of the resource", example="1", required = true, position = 0)
    @NotNull
    private Long id;
	
	@ApiModelProperty(notes="Name of the application", example="Architecture", required = true, position = 1)
	@NotNull
	private String name;
	
	@ApiModelProperty(notes="Description of the application", required = true, position = 2)
	@NotNull
	private String description;
	
	@ApiModelProperty(notes="Indicate if the application is enabled", example="true", required = true, position = 3)
	@NotNull
	private Boolean enabled;
	
	@ApiModelProperty(notes="Home URI for the application", example="http://local.com/architecture", required = true, position = 4)
	@NotNull
	private String homeUri;
	
	@ApiModelProperty(notes="Documentation URL for the application", example="http://local.com/doc/architecture/", required = true, position = 5)
	@NotNull
	private String documentationUrl;
	
	@ApiModelProperty(notes="Version of the resource", example="1", required = true, position = 6)
	@NotNull
	private Integer version;
	
	@ApiModelProperty(notes="List of services for the application", required = true, position = 7)
	@NotNull
	@Singular
	private List<ServiceResponseResource> services;
	
}
