package com.statravel.autoqa.domain;

/**
 * 
 * @author STA Development Team
 *
 */
public final class User {

    private String username;
    private String password;

    /**
     * @return the login
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param builder
     *            the user builder
     */
    private User(final UserBuilder builder) {
        this.username = builder.username;
        this.password = builder.password;
    }

    /**
     * 
     * @author STA Development Team
     *
     */
    public static class UserBuilder {
        private String username;
        private String password;

        /**
         * 
         * @param username
         *            the users username
         * @return the user builder
         */
        public UserBuilder setUsername(final String username) {
            this.username = username;
            return this;
        }

        /**
         * 
         * @param password
         *            the users password
         * @return the user builder
         */
        public UserBuilder setPassword(final String password) {
            this.password = password;
            return this;
        }

        /**
         * 
         * @return a new User
         */
        public User build() {
            return new User(this);
        }

    }

}
