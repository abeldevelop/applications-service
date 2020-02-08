package com.abeldevelop.architecture.applications.dto.application;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.abeldevelop.architecture.library.common.dto.pagination.PaginationResponseResource;

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

@ApiModel(description="Resource with pagination information")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ApplicationPaginationResponseResource {

	@ApiModelProperty(notes="Resource with pagination information", required = true, position = 0)
    @NotNull
    private PaginationResponseResource pagination;

    @ApiModelProperty(notes="List of applications", required = true, position = 1)
    @Singular
    private List<ApplicationResponseResource> errorMessages;
    
}
