package com.statravel.autoqa.domain.payload;

import java.io.Serializable;

/**
 * @author STA Development Team
 *
 */
public class EmailPayLoad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1102844688278259417L;
	
	private String product;
	
	private Email email;
	
	public EmailPayLoad(String product, Email email) {
		super();
		this.product = product;
		this.email = email;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(final String product) {
		this.product = product;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(final Email email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmailPayLoad [product=" + product + ", email=" + email + "]";
	}	

}
