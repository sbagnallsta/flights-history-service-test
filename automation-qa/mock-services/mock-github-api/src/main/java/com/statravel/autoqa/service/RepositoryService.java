package com.statravel.autoqa.service;

/**
 * @author STA Development Team
 *
 */
public interface RepositoryService {
	
	/**
	 * Checks if repository exits or not. 
	 * 
	 * @param repository
	 * 				repository
	 * @return true if repository exits and false if it doesn't
	 */
	boolean checkIfRepositoryIsValid(String repository);

}
