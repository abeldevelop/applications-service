package com.abeldevelop.architecture.applications.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.abeldevelop.architecture.applications.model.ApplicationEntity;

public interface ApplicationRepository {

	public ApplicationEntity executeSave(ApplicationEntity applicationEntity);
    
    public Optional<ApplicationEntity> executeFindById(Long id);
    
    public void executeDeleteById(Long id);

    public Page<ApplicationEntity> executeFindAll(Pageable pageable);
    
    public Page<ApplicationEntity> executeFindAll(Specification<ApplicationEntity> spec, Pageable pageable);
    
}
