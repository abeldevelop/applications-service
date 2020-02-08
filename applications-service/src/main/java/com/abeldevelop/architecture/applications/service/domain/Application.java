package com.abeldevelop.architecture.applications.service.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@ToString
public class Application {

	@EqualsAndHashCode.Include
	private Long id;
	private String name;
	private String description;
	private Boolean enabled;
	private String homeUri;
	private String documentationUrl;
	private Integer version;
	private List<Service> services;
	
}
