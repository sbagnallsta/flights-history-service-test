package com.statravel.autoqa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.statravel.autoqa.domain.entity.User;


/**
 * @author STA development team
 *
 */
@Repository
public interface UserRepository  extends JpaRepository<User, String> {

}
