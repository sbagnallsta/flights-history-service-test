package com.statravel.autoqa.domain.payload;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author STA Development Team
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class FilePayLoad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5371537673330804801L;

	private String repository;

	private String message;

	private String content;

	private String path;

	private String branch;

	/**
	 * 
	 * @param repository
	 * 			repository
	 * @param message
	 * 			message
	 * @param content
	 * 			content
	 * @param path
	 * 			path
	 * @param branch
	 * 			branch
	 */
	public FilePayLoad(final String repository, final String message, final String content, final String path, final String branch) {
		super();
		this.repository = repository;
		this.message = message;
		this.content = content;
		this.path = path;
		this.branch = branch;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getRepository() {
		return repository;
	}

	public String getMessage() {
		return message;
	}

	public String getContent() {
		return content;
	}

	public String getPath() {
		return path;
	}

	public String getBranch() {
		return branch;
	}

	@Override
	public String toString() {
		return "FilePayLoad [repository=" + repository + ", message=" + message + ", content=" + content + ", path="
				+ path + ", branch=" + branch + "]";
	}

}
