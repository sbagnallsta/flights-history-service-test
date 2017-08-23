package com.statravel.autoqa.paymentformsui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.statravel.autoqa.paymentformsui.domain.entity.PaymentFormsConfiguration;

/**
 * 
 * @author STA Development Team
 *
 */
@Repository
public interface PaymentFormConfigureRepository extends JpaRepository<PaymentFormsConfiguration, Long> {
    /**
     * 
     * @param posId
     *            pos Id
     * @param environment
     *            environment
     * @return payment form configuration
     */
    PaymentFormsConfiguration findByPosIdAndEnvironment(Long posId, String environment);

}
