package com.statravel.autoqa.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.statravel.autoqa.config.ApplicationProperties;
import com.statravel.autoqa.domain.payload.Settings;

/**
 * 
 * @author STA Development Team
 *
 */
@Component
public class SettingsUtils {

    private static final int NUMBER_OF_SEARCHES_TO_STORE = 6;

    @Autowired
    private ApplicationProperties applicationProperties;

    /**
     * Builds a settings object.
     * 
     * @return settings object built
     */
    public Settings buildSettings() {

        return new Settings(applicationProperties.getPos(), (byte) NUMBER_OF_SEARCHES_TO_STORE, true);
    }

}
