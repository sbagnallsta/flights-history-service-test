package com.statravel.autoqa.common;


/**
 * @author STA Development Team
 * 
 */
public enum Repositories {

	SAVED_SEARCHES("savedsearches-api "), GITHUB_SERVICE("github-service"), CONFLUENCE_SERVICE("confluence-service "), TEMPLATE_SERVICE("template-service"),
	JIRA_SERVICE("jira-service"), TEST("testRepository");
	
	private final String repository;

	private Repositories(final String repository) {
		
		this.repository = repository;
		
	}
	
	public static boolean isRepositoryValid(final String repository) {
		
		for (Repositories element : Repositories.values()) {
			
			if (element.getRepository().equals(repository)) {

                return true;

            }
			
		}
		
		return false;
		
	}

	public String getRepository() {
		
		return repository;
		
	}

}
