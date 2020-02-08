package com.abeldevelop.architecture.applications.repository.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.abeldevelop.architecture.applications.model.ApplicationEntity;
import com.abeldevelop.architecture.applications.repository.ApplicationRepository;
import com.abeldevelop.architecture.applications.repository.springdata.ApplicationSpringDataRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository {
	
	private final ApplicationSpringDataRepository applicationSpringDataRepository;
	
	@Override
	public ApplicationEntity executeSave(ApplicationEntity applicationEntity) {
		return applicationSpringDataRepository.save(applicationEntity);
	}

	@Override
	public Optional<ApplicationEntity> executeFindById(Long id) {
		return applicationSpringDataRepository.findById(id);
	}

	@Override
	public void executeDeleteById(Long id) {
		applicationSpringDataRepository.deleteById(id);
	}

	@Override
	public Page<ApplicationEntity> executeFindAll(Pageable pageable) {
		return applicationSpringDataRepository.findAll(pageable);
	}

	@Override
	public Page<ApplicationEntity> executeFindAll(Specification<ApplicationEntity> spec, Pageable pageable) {
		return applicationSpringDataRepository.findAll(spec, pageable);
	}

}
