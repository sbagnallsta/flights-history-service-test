/**
 *
 */
package com.statravel.ms.service;

import org.springframework.stereotype.Service;

import com.statravel.ms.domain.entity.Product;
import com.statravel.ms.domain.entity.Space;
import com.statravel.ms.domain.entity.Team;
import com.statravel.ms.domain.entity.Template;
import com.statravel.ms.domain.entity.Type;

/**
 * @author STA Development Team
 *
 */
@Service
public class MockTemplateService {

    private static String validProductName = "Release Management - Release History - Saved Searches API - ";
    private static String invalidProductName = "Release Management - Release History - Saved Searches API COPY - ";

    /**
     * 
     * @param productName for valid or invalid product
     * @return a template
     */
    private Template createTemplate(final String productName) {

        return new Template(Integer.valueOf(1), productName, Integer.valueOf(107937830), new Product("Saved Searches", 1),
                new Type("Confluence Release Page"), new Team("Internal"), new Space("SWO"),
                "<h1>Release Summary</h1><p><br /></p><table class=\"wrapped confluenceTable\"><colgroup><col /><col /></colgroup><tbody><tr><th class=\"confluenceTh\">Team</th><td class=\"confluenceTd\"><p>Internal</p></td></tr><tr><th class=\"confluenceTh\"><p>Product</p></th><td class=\"confluenceTd\"><p>Saved Searches</p></td></tr><tr><th class=\"confluenceTh\"><p>Release Version</p></th><td class=\"confluenceTd\"><p>1.4</p></td></tr><tr><th colspan=\"1\" class=\"confluenceTh\">GitHub Tag</th><td colspan=\"1\" class=\"confluenceTd\"><p>release-1.4</p></td></tr><tr><th colspan=\"1\" class=\"confluenceTh\">Change Request Number</th><td colspan=\"1\" class=\"confluenceTd\"><p>CHF1234</p></td></tr></tbody></table><h1>Features</h1><h1>Known Issues</h1><p><br /></p><p>&nbsp;</p>",
                null);
        
    }
    
    /**
     * 
     * @return an invalid template
     */
    public Template createInvalidTemplate() {

        return createTemplate(invalidProductName);

    }

    /**
     * 
     * @return a valid template
     */
    public Template createValidTemplate() {

        return createTemplate(validProductName);

    }

}
