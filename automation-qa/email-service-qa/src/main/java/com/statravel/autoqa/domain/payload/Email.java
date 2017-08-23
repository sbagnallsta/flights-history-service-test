package com.statravel.autoqa.domain.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author STA Development Team
 *
 */
public class Email implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4459488224792927701L;
	
	private String sender;
	
	private List<String> to = new ArrayList<String>();
	
	private List<String> cc = new ArrayList<String>();
	
	private List<String> bcc = new ArrayList<String>();
	
	private String subject;
	
	private String body;

	public Email(String sender, List<String> to, List<String> cc, List<String> bcc, String subject, String body) {
		super();
		this.sender = sender;
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
		this.subject = subject;
		this.body = body;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(final String sender) {
		this.sender = sender;
	}

	public List<String> getTo() {
		return to;
	}

	public void setTo(final List<String> to) {
		this.to = to;
	}

	public List<String> getCc() {
		return cc;
	}

	public void setCc(final List<String> cc) {
		this.cc = cc;
	}

	public List<String> getBcc() {
		return bcc;
	}

	public void setBcc(final List<String> bcc) {
		this.bcc = bcc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(final String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(final String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Email [sender=" + sender + ", to=" + to + ", cc=" + cc + ", bcc=" + bcc + ", subject=" + subject
				+ ", body=" + body + "]";
	}
	
}
