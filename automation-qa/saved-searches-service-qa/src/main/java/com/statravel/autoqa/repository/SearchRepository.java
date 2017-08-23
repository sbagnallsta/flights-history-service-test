package com.statravel.autoqa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.statravel.autoqa.domain.entity.Search;

/**
 * 
 * @author STA Development Team
 *
 */
@Repository
public interface SearchRepository extends JpaRepository<Search, Long> {

    /**
     * 
     * Deletes a search by user id and point of sale.
     * 
     * @param userId
     *            user id
     * 
     * @param pos
     *            point of sale code
     * 
     */
    @Transactional
    void deleteSearchByUserIdAndPos(String userId, String pos);

    /**
     * Finds destination where departure date is before than the date provided.
     * 
     * @param departureDate
     *            departure date
     * @return destinations where departure date is before than the date provided
     */
    List<Search> findByFlightSearchFlightDestinationListDepartureDateBefore(Date departureDate);

}
