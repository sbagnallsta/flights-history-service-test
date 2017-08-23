package com.statravel.autoqa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.statravel.autoqa.config.ApplicationProperties;
import com.statravel.autoqa.domain.entity.User;
import com.statravel.autoqa.repository.UserRepository;

/**
 * 
 * @author STA Development Team
 *
 */
@SpringBootApplication
public class SavedSearchesAPIAutoQAApplication {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApplicationProperties propertiesConfig;

    /**
     * 
     * @param args
     *            args
     */
    public static void main(final String[] args) {
        SpringApplication.run(SavedSearchesAPIAutoQAApplication.class, args);

    }

    /**
     * 
     * @return User inserted / updated
     */
    @Bean
    public User prepareAutomationFramework() {

        User mystaUser = new User(propertiesConfig.getMystaUserId(), true);

        userRepository.save(mystaUser);

        return mystaUser;
    }
}
