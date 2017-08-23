package com.statravel.autoqa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.statravel.autoqa.domain.entity.Settings;

/**
 * @author STA development team
 *
 */
@Repository
public interface SettingsRepository extends JpaRepository<Settings, String> {

}
