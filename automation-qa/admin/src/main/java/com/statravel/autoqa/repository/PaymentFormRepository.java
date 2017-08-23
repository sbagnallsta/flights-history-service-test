package com.statravel.autoqa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.statravel.autoqa.domain.entity.PaymentFormEntity;
/**
 * 
 * @author STA Development Team
 *
 */
@Repository
public interface PaymentFormRepository extends JpaRepository<PaymentFormEntity, Long> { 

}
