package com.abeldevelop.architecture.applications.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ServiceEntity.class)
public class ServiceEntity_ {

	public static volatile SingularAttribute<ServiceEntity, Long> id;
	public static volatile SingularAttribute<ServiceEntity, String> name;
	public static volatile SingularAttribute<ServiceEntity, Integer> port;
	public static volatile SingularAttribute<ServiceEntity, String> gitUrl;
	public static volatile SingularAttribute<ServiceEntity, String> documentationUrl;
	
}
