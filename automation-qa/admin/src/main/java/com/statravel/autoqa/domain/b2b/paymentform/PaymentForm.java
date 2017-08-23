package com.statravel.autoqa.domain.b2b.paymentform;

/**
 * 
 * @author STA Development Team
 *
 */
public class PaymentForm {

    private String formName;

    private String partnerName;

    private String partnerLogo;

    private String tripName;

    private String travelHeading;

    private String travelIntro;

    private boolean finalDepositDateActive;

    private String finalDepositDescription;

    private boolean finalPaymentDateActive;

    private String finalPaymentDescription;

    private String importantInstructionDescription;

    /**
     * Build a payment form object.
     * 
     * @param paymentFormBuilder
     *            payment builder
     */
    public PaymentForm(final PaymentFormBuilder paymentFormBuilder) {
        this.formName = paymentFormBuilder.formName;
        this.partnerName = paymentFormBuilder.partnerName;
        this.partnerLogo = paymentFormBuilder.partnerLogo;
        this.tripName = paymentFormBuilder.tripName;
        this.travelHeading = paymentFormBuilder.travelHeading;
        this.travelIntro = paymentFormBuilder.travelIntro;
        this.finalDepositDateActive = paymentFormBuilder.finalDepositDateActive;
        this.finalDepositDescription = paymentFormBuilder.finalDepositDescription;
        this.finalPaymentDateActive = paymentFormBuilder.finalPaymentDateActive;
        this.finalPaymentDescription = paymentFormBuilder.finalPaymentDescription;
        this.finalPaymentDescription = paymentFormBuilder.finalPaymentDescription;
        this.importantInstructionDescription = paymentFormBuilder.importantInstructionDescription;
    }

    /**
     * @return the formName
     */
    public String getFormName() {
        return formName;
    }

    /**
     * @return the partnerName
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     * @return the partnerLogo
     */
    public String getPartnerLogo() {
        return partnerLogo;
    }

    /**
     * @return the tripName
     */
    public String getTripName() {
        return tripName;
    }

    /**
     * @return the travelHeading
     */
    public String getTravelHeading() {
        return travelHeading;
    }

    /**
     * @return the travelIntro
     */
    public String getTravelIntro() {
        return travelIntro;
    }

    /**
     * @return the finalDepositDate
     */
    public boolean isFinalDepositDateActive() {
        return finalDepositDateActive;
    }

    /**
     * @return the finalPaymentDateActive
     */
    public boolean isFinalPaymentDateActive() {
        return finalPaymentDateActive;
    }

    /**
     * @return the finalDepositDescription
     */
    public String getFinalDepositDescription() {
        return finalDepositDescription;
    }

    /**
     * @return the finalPaymentDescription
     */
    public String getFinalPaymentDescription() {
        return finalPaymentDescription;
    }

    /**
     * @return the importantInstructionDescription
     */
    public String getImportantInstructionDescription() {
        return importantInstructionDescription;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PaymentForm [formName=" + formName + ", partnerName=" + partnerName + ", partnerLogo=" + partnerLogo + ", tripName=" + tripName
                + ", travelHeading=" + travelHeading + ", travelIntro=" + travelIntro + ", finalDepositDateActive=" + finalDepositDateActive
                + ", finalDepositDescription=" + finalDepositDescription + ", finalPaymentDateActive=" + finalPaymentDateActive
                + ", finalPaymentDescription=" + finalPaymentDescription + ", importantInstructionDescription=" + importantInstructionDescription
                + "]";
    }

    /**
     * 
     * @author STA Development Team
     *
     */
    public static class PaymentFormBuilder {

        private String formName;

        private String partnerName;

        private String partnerLogo;

        private String tripName;

        private String travelHeading;

        private String travelIntro;

        private boolean finalDepositDateActive;

        private String finalDepositDescription;

        private boolean finalPaymentDateActive;

        private String finalPaymentDescription;

        private String importantInstructionDescription;

        /**
         * 
         * @param formName
         * @return Payment form builder
         */
        public PaymentFormBuilder setFormName(final String formName) {
            this.formName = formName;
            return this;
        }

        /**
         * 
         * @param partnerName
         * @return Payment form builder
         */
        public PaymentFormBuilder setPartnerName(final String partnerName) {
            this.partnerName = partnerName;
            return this;
        }

        /**
         * 
         * @param partnerLogo
         * @return Payment form builder
         */
        public PaymentFormBuilder setPartnerLogo(final String partnerLogo) {
            this.partnerLogo = partnerLogo;
            return this;
        }

        /**
         * 
         * @param tripName
         * @return Payment form builder
         */
        public PaymentFormBuilder setTripName(final String tripName) {
            this.tripName = tripName;
            return this;
        }

        /**
         * 
         * @param travelHeading
         * @return Payment form builder
         */
        public PaymentFormBuilder setTravelHeading(final String travelHeading) {
            this.travelHeading = travelHeading;
            return this;
        }

        /**
         * 
         * @param travelIntro
         * @return Payment form builder
         */
        public PaymentFormBuilder setTravelIntro(final String travelIntro) {
            this.travelIntro = travelIntro;
            return this;
        }

        /**
         * 
         * @param finalDepositDate
         * @return Payment form builder
         */
        public PaymentFormBuilder setFinalDepositDateActive(final boolean finalDepositDateActive) {
            this.finalDepositDateActive = finalDepositDateActive;
            return this;
        }

        /**
         * 
         * @param finalPaymentDateActive
         * @return Payment form builder
         */
        public PaymentFormBuilder setFinalPaymentDateActive(final boolean finalPaymentDateActive) {
            this.finalPaymentDateActive = finalPaymentDateActive;
            return this;
        }

        /**
         * 
         * @param finalDepositDescription
         * @return Payment form builder
         */
        public PaymentFormBuilder setFinalDepositDescription(final String finalDepositDescription) {
            this.finalDepositDescription = finalDepositDescription;
            return this;
        }

        /**
         * 
         * @param finalPaymentDescription
         * @return Payment form builder
         */
        public PaymentFormBuilder setFinalPaymentDescription(final String finalPaymentDescription) {
            this.finalPaymentDescription = finalPaymentDescription;
            return this;
        }

        /**
         * 
         * @param importantInstructionDescription
         * @return Payment form builder
         */
        public PaymentFormBuilder setImportantInstructionDescription(final String importantInstructionDescription) {
            this.importantInstructionDescription = importantInstructionDescription;
            return this;
        }

        /**
         * Builds Payment form object.
         * 
         * @return payment form object
         */
        public PaymentForm build() {
            return new PaymentForm(this);
        }

    }

}
