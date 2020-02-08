package com.abeldevelop.architecture.applications.service.domain;

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
public class Service {

	@EqualsAndHashCode.Include
	private Long id;
	private String name;
	private Integer port;
	private String gitUrl;
	private String documentationUrl;
	
}
