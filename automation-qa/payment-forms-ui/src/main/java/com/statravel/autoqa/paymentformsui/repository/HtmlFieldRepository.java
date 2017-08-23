package com.statravel.autoqa.paymentformsui.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.statravel.autoqa.paymentformsui.domain.entity.HtmlField;

/**
 * 
 * @author STA Development Team
 *
 */
@Repository
public interface HtmlFieldRepository extends JpaRepository<HtmlField, Long> {

    /**
     * 
     * Finds all HTML fields that are not mandatories with given type.
     * 
     * @param type
     *            type
     * 
     * @return a list of all HTML fields
     */
    List<HtmlField> findByTypeAndMandatoryIsFalse(String type);

}
