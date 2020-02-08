package com.abeldevelop.architecture.applications.service.mapper;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.applications.dto.application.ApplicationSort;
import com.abeldevelop.architecture.applications.model.ApplicationEntity_;
import com.abeldevelop.architecture.library.common.domain.pagination.in.SortDirection;
import com.abeldevelop.architecture.library.common.domain.pagination.in.SortIn;
import com.abeldevelop.architecture.library.common.mapper.pagination.SortMapper;

@Component
public class ApplicationSortMapper implements SortMapper<ApplicationSort> {

	public SortIn map(ApplicationSort enumSort) {
		if(enumSort == null) {
			return getDefault();
		}
		SortIn sortIn = null;
		switch (enumSort) {
			case NAME_DESC:
				sortIn = SortIn.of(SortDirection.DESC, ApplicationEntity_.name.getName());
				break;
			default:
				sortIn = getDefault();
				break;
		}
		return sortIn;
    }
	
	private SortIn getDefault() {
		return SortIn.of(SortDirection.DESC, ApplicationEntity_.name.getName());
	}
}
