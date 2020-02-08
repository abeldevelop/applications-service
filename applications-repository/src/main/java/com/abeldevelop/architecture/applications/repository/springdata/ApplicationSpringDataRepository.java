package com.abeldevelop.architecture.applications.repository.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.abeldevelop.architecture.applications.model.ApplicationEntity;

public interface ApplicationSpringDataRepository extends JpaRepository<ApplicationEntity, Long>, JpaSpecificationExecutor<ApplicationEntity> {

}
