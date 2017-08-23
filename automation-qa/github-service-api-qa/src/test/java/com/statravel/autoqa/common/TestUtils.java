package com.statravel.autoqa.common;



import com.statravel.autoqa.domain.payload.FilePayLoad;
import com.statravel.autoqa.domain.payload.TagPayLoad;


/**
 * 
 * @author STA Development Team.
 *
 */
public class TestUtils {

	private static final String TEST_REPOSITORY_WRONG = "testRepositoryWrong";
	private static final String BODY_NAME_TAG = "CI Body";
	private static final String REPOSITORY_NAME = "testRepository";
	private static final String TAG_NAME = "tagName";
	
	private static final String MESSAGE_FILE = "CI commit message";
	private static final String CONTENT_FILE = "CI content";
	private static final String BRANCH_FILE = "master";
	private static final String PATH_FILE = "fileName.log";

	/**
	 * 
	 * @return {@link com.statravel.autoqa.domain.payload.TagPayLoad}
	 */
	public TagPayLoad buildTag() {
		
		return new TagPayLoad(TAG_NAME, BODY_NAME_TAG, REPOSITORY_NAME);

	}
	
	/**
	 * 
	 * @return {@link com.statravel.autoqa.domain.payload.TagPayLoad}
	 */
	public TagPayLoad buildTag(final String tagName, final String body, final String repository) {

		return new TagPayLoad(tagName, body, repository);

	}
	
	/**
	 * 
	 * @return {@link com.statravel.autoqa.domain.payload.TagPayLoad}
	 */
	public TagPayLoad buildTagWrongRepository() {

		return new TagPayLoad(TAG_NAME, BODY_NAME_TAG, TEST_REPOSITORY_WRONG);

	}
	
	/**
	 * 
	 * @return {@link com.statravel.autoqa.domain.payload.TagPayLoad}
	 */
	public FilePayLoad buildFile() {
		
		return new FilePayLoad(REPOSITORY_NAME, MESSAGE_FILE, CONTENT_FILE, PATH_FILE, BRANCH_FILE);

	}
	
	/**
	 * 
	 * @return {@link com.statravel.autoqa.domain.payload.TagPayLoad}
	 */
	public FilePayLoad buildFile(final String message, final String path, final String repository, final String content, final String branch) {

		return new FilePayLoad(repository, message, content, path, branch);

	}
	
	/**
	 * 
	 * @return {@link com.statravel.autoqa.domain.payload.TagPayLoad}
	 */
	public FilePayLoad buildFileWrongRepository() {
		
		return new FilePayLoad(TEST_REPOSITORY_WRONG, MESSAGE_FILE, CONTENT_FILE, PATH_FILE, BRANCH_FILE);


	}
	
}
