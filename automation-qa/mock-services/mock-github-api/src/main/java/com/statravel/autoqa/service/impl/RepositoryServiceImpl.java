package com.statravel.autoqa.service.impl;

import org.springframework.stereotype.Service;

import com.statravel.autoqa.common.Repositories;
import com.statravel.autoqa.service.RepositoryService;

@Service
public class RepositoryServiceImpl implements RepositoryService {

	@Override
	public boolean checkIfRepositoryIsValid(final String repository) {
		
		return Repositories.isRepositoryValid(repository);
		
	}

}
