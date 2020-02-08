package com.abeldevelop.architecture.applications.dto.application;

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

@ApiModel(description="Update Application resource")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class UpdateApplicationRequestResource {

	@ApiModelProperty(notes="Name of the application", example="Architecture", required = true, position = 1)
	@NotNull
	@Size(min = ApplicationFieldsSizeConstants.NAME_MIN_SIZE, max = ApplicationFieldsSizeConstants.NAME_MAX_SIZE)
	private String name;
	
	@ApiModelProperty(notes="Description of the application", required = true, position = 2)
	@NotNull
	@Size(min = ApplicationFieldsSizeConstants.DESCRIPTION_MIN_SIZE, max = ApplicationFieldsSizeConstants.DESCRIPTION_MAX_SIZE)
	private String description;
	
	@ApiModelProperty(notes="Indicate if the application is enabled", example="true", required = true, position = 3)
	@NotNull
	private Boolean enabled;
	
	@ApiModelProperty(notes="Home URI for the application", example="http://local.com/architecture", required = true, position = 4)
	@NotNull
	@Size(min = ApplicationFieldsSizeConstants.HOME_URI_MIN_SIZE, max = ApplicationFieldsSizeConstants.HOME_URI_MAX_SIZE)
	private String homeUri;
	
	@ApiModelProperty(notes="Documentation URL for the application", example="http://local.com/doc/architecture/", required = true, position = 5)
	@NotNull
	@Size(min = ApplicationFieldsSizeConstants.DOCUMENTATION_URL_MIN_SIZE, max = ApplicationFieldsSizeConstants.DOCUMENTATION_URL_MAX_SIZE)
	private String documentationUrl;
	
	@ApiModelProperty(notes="Version of the resource", example="1", required = true, position = 6)
	@NotNull
	private Integer version;
	
}
