package com.statravel.autoqa.paymentformsui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.statravel.autoqa.paymentformsui.domain.entity.PaymentForm;



/**
 * 
 * @author STA Development Team
 *
 */
@Repository
public interface PaymentFormRepository extends JpaRepository<PaymentForm, Long> {
    

}
