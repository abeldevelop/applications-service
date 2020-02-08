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

}