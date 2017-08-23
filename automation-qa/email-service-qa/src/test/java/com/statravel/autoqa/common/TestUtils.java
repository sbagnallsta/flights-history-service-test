package com.statravel.autoqa.common;

import java.util.ArrayList;
import java.util.List;

import com.statravel.autoqa.domain.payload.Email;
import com.statravel.autoqa.domain.payload.EmailPayLoad;

/**
 * 
 * @author STA Development Team.
 *
 */
public class TestUtils {
	
	private static final String BAD_REQUEST_PRODUCT = "404";
	private static final String SERVER_ERROR_PRODUCT = "502";
	
	private static final String PRODUCT = "B2B API";
	private static final String SENDER = "noreply@statravel.com";
	private static final String TO = "test@statravel.com";
	private static final String CC = "testcc@statravel.com";
	private static final String BCC = "testbcc@statravel.com";
	private static final String SUBJECT = "Subject";
	private static final String BODY = "Body";

	public static final String ERRORS = "errors";
	
	/**
	 * 
	 * @return EmailPayLoad
	 */
	public EmailPayLoad buildEmail() {
		
		Email email = prepareEmail();
		
		return new EmailPayLoad(PRODUCT, email);

	}

    /**
     * @param sender2 the sender
     * @param to2 to
     * @param cc2 cc
     * @param bcc2 bcc
     * @return EmailPayLoad
     */
    public EmailPayLoad buildEmail(final String sender2, final String to2, final String cc2, final String bcc2) {
        
        Email email = prepareEmail(sender2, to2, cc2, bcc2);
        
        return new EmailPayLoad(PRODUCT, email);
        
    }
    
    /**
     * @return EmailPayload
     */
    public EmailPayLoad buildUnknowProductEmail() {
        
        Email email = prepareEmail();
        
        return new EmailPayLoad(BAD_REQUEST_PRODUCT, email);
        
    }
    
    /**
     * @return EmailPayload
     */
    public EmailPayLoad buildBadGateGayEmailRequest() {
        
        Email email = prepareEmail();
        
        return new EmailPayLoad(SERVER_ERROR_PRODUCT, email);
        
    }
    
    
    /**
     * 
     * @return a standard email object
     */
    private Email prepareEmail() {
        
        return prepareEmail(SENDER, TO, CC, BCC);
    }
    
    /**
     * @param sender the sender
     * @param to to
     * @param cc cc
     * @param bcc bcc
     * @return EmailPayLoad
     */
    public Email prepareEmail(final String sender, final String to, final String cc, final String bcc) {
        List<String> toList = new ArrayList<String>();
        toList.add(to);
        
        List<String> ccList = new ArrayList<String>();
        ccList.add(cc);
        
        List<String> bccList = new ArrayList<String>();
        bccList.add(bcc);
        
        return new Email(sender, toList, ccList, bccList, SUBJECT, BODY);
    }
    
}
