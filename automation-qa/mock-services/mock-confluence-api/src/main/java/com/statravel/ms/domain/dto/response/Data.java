package com.statravel.ms.domain.dto.response;

/**
 * @author STA Development Team
 *
 */
public class Data {

    private boolean authorized;
    private boolean valid;
    private String[] errors;
    private boolean successful;

    /**
     *
     * @param authorized
     *            authorized
     * @param valid
     *            valid
     * @param errors
     *            errors
     * @param successful
     *            successful
     */
    public Data(final boolean authorized, final boolean valid, final String[] errors, final boolean successful) {
        this.setAuthorized(authorized);
        this.setValid(valid);
        this.setErrors(errors);
        this.setSuccessful(successful);
    }

    /**
     *
     * @return authorized
     */
    public boolean isAuthorized() {
        return authorized;
    }

    /**
     *
     * @param authorized
     *            is authorized
     */
    public void setAuthorized(final boolean authorized) {
        this.authorized = authorized;
    }

    /**
     *
     * @return valid
     */
    public boolean isValid() {
        return valid;
    }

    /**
     *
     * @param valid
     *            is valid
     */
    public void setValid(final boolean valid) {
        this.valid = valid;
    }

    /**
     *
     * @return errors
     */
    public String[] getErrors() {
        return errors;
    }

    /**
     *
     * @param errors
     *            some errors
     */
    public void setErrors(final String[] errors) {
        this.errors = errors;
    }

    /**
     *
     * @return successful
     */
    public boolean isSuccessful() {
        return successful;
    }

    /**
     *
     * @param successful
     *            is successful
     */
    public void setSuccessful(final boolean successful) {
        this.successful = successful;
    }
}
