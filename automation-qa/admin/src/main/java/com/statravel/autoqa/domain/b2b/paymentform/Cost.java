package com.statravel.autoqa.domain.b2b.paymentform;

/**
 * 
 * @author STA Development Team
 *
 */
public final class Cost {

    private int flightAmount;
    private int airFareAmount;
    private int taxesAmount;
    private String termsAndConditionInput;
    private int accommodationAmount;
    private int transferAmount;
    private int otherAmount;
    private int depositAmount;
    private boolean flightAmountActive;
    private boolean airFareAmountActive;
    private boolean taxesAmountActive;
    private boolean termsAndConditionInputActive;
    private boolean accommodationAmountActive;
    private boolean transferAmountActive;
    private boolean otherAmountActive;
    private boolean depositAmountActive;

    /**
     * 
     * @param costBuilder
     *            cost builder
     */
    private Cost(final CostBuilder costBuilder) {
        this.flightAmount = costBuilder.flightAmount;
        this.airFareAmount = costBuilder.airFareAmount;
        this.taxesAmount = costBuilder.taxesAmount;
        this.termsAndConditionInput = costBuilder.termsAndConditionInput;
        this.accommodationAmount = costBuilder.accommodationAmount;
        this.transferAmount = costBuilder.transferAmount;
        this.otherAmount = costBuilder.otherAmount;
        this.depositAmount = costBuilder.depositAmount;
        this.flightAmountActive = costBuilder.flightAmountActive;
        this.airFareAmountActive = costBuilder.airFareAmountActive;
        this.taxesAmountActive = costBuilder.taxesAmountActive;
        this.termsAndConditionInputActive = costBuilder.termsAndConditionInputActive;
        this.accommodationAmountActive = costBuilder.accommodationAmountActive;
        this.transferAmountActive = costBuilder.transferAmountActive;
        this.otherAmountActive = costBuilder.otherAmountActive;
        this.depositAmountActive = costBuilder.depositAmountActive;
    }

    /**
     * @return the flightAmount
     */
    public int getFlightAmount() {
        return flightAmount;
    }

    /**
     * @return the airFareAmount
     */
    public int getAirFareAmount() {
        return airFareAmount;
    }

    /**
     * @return the taxesAmount
     */
    public int getTaxesAmount() {
        return taxesAmount;
    }

    /**
     * @return the termsAndConditionInput
     */
    public String getTermsAndConditionInput() {
        return termsAndConditionInput;
    }

    /**
     * @return the accommodationAmount
     */
    public int getAccommodationAmount() {
        return accommodationAmount;
    }

    /**
     * @return the transferAmount
     */
    public int getTransferAmount() {
        return transferAmount;
    }

    /**
     * @return the otherAmount
     */
    public int getOtherAmount() {
        return otherAmount;
    }

    /**
     * @return the depositAmount
     */
    public int getDepositAmount() {
        return depositAmount;
    }

    /**
     * @return the flightAmountActive
     */
    public boolean isFlightAmountActive() {
        return flightAmountActive;
    }

    /**
     * @return the accommodationAmountActive
     */
    public boolean isAccommodationAmountActive() {
        return accommodationAmountActive;
    }

    /**
     * @return the transferAmountActive
     */
    public boolean isTransferAmountActive() {
        return transferAmountActive;
    }

    /**
     * @return the otherAmountActive
     */
    public boolean isOtherAmountActive() {
        return otherAmountActive;
    }

    /**
     * @return the airFareAmountActive
     */
    public boolean isAirFareAmountActive() {
        return airFareAmountActive;
    }

    /**
     * @return the taxesAmountActive
     */
    public boolean isTaxesAmountActive() {
        return taxesAmountActive;
    }

    /**
     * @return the ermsAndConditionInputActive
     */
    public boolean isTermsAndConditionInputActive() {
        return termsAndConditionInputActive;
    }

    /**
     * @return the depositAmountActive
     */
    public boolean isDepositAmountActive() {
        return depositAmountActive;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Cost [flightAmount=" + flightAmount + ", airFareAmount=" + airFareAmount + ", taxesAmount=" + taxesAmount
                + ", termsAndConditionInput=" + termsAndConditionInput + ", accommodationAmount=" + accommodationAmount + ", transferAmount="
                + transferAmount + ", otherAmount=" + otherAmount + ", depositAmount=" + depositAmount + ", flightAmountActive=" + flightAmountActive
                + ", airFareAmountActive=" + airFareAmountActive + ", taxesAmountActive=" + taxesAmountActive + ", termsAndConditionInputActive="
                + termsAndConditionInputActive + ", accommodationAmountActive=" + accommodationAmountActive + ", transferAmountActive="
                + transferAmountActive + ", otherAmountActive=" + otherAmountActive + ", depositAmountActive=" + depositAmountActive + "]";
    }

    /**
     * 
     * @author STA Development Team
     *
     */
    public static class CostBuilder {

        private int flightAmount;
        private int airFareAmount;
        private int taxesAmount;
        private String termsAndConditionInput;
        private int accommodationAmount;
        private int transferAmount;
        private int otherAmount;
        private int depositAmount;
        private boolean flightAmountActive;
        private boolean airFareAmountActive;
        private boolean taxesAmountActive;
        private boolean termsAndConditionInputActive;
        private boolean accommodationAmountActive;
        private boolean transferAmountActive;
        private boolean otherAmountActive;
        private boolean depositAmountActive;

        /**
         * 
         * @param depositAmountActive
         * @return cost builder
         */
        public CostBuilder setDepositAmountActive(final boolean depositAmountActive) {
            this.depositAmountActive = depositAmountActive;
            return this;
        }

        /**
         * 
         * @param airFareAmountActive
         * @return cost builder
         */
        public CostBuilder setAirFareAmountActive(final boolean airFareAmountActive) {
            this.airFareAmountActive = airFareAmountActive;
            return this;
        }

        /**
         * 
         * @param taxesAmountActive
         * @return cost builder
         */
        public CostBuilder setTaxesAmountActive(final boolean taxesAmountActive) {
            this.taxesAmountActive = taxesAmountActive;
            return this;
        }

        /**
         * 
         * @param termsAndConditionInputActive
         * @return cost builder
         */
        public CostBuilder setTermsAndConditionInputActive(final boolean termsAndConditionInputActive) {
            this.termsAndConditionInputActive = termsAndConditionInputActive;
            return this;
        }

        /**
         * 
         * @param flightAmount
         * @return cost builder
         */
        public CostBuilder setFlightAmount(final int flightAmount) {
            this.flightAmount = flightAmount;
            return this;
        }

        /**
         * 
         * @param airFareAmount
         * @return cost builder
         */
        public CostBuilder setAirFareAmount(final int airFareAmount) {
            this.airFareAmount = airFareAmount;
            return this;
        }

        /**
         * 
         * @param taxesAmount
         * @return cost builder
         */
        public CostBuilder setTaxesAmount(final int taxesAmount) {
            this.taxesAmount = taxesAmount;
            return this;
        }

        /**
         * 
         * @param termsAndConditionInput
         * @return cost builder
         */
        public CostBuilder setTermsAndConditionInput(final String termsAndConditionInput) {
            this.termsAndConditionInput = termsAndConditionInput;
            return this;
        }

        /**
         * 
         * @param accommodationAmount
         * @return cost builder
         */
        public CostBuilder setAccommodationAmount(final int accommodationAmount) {
            this.accommodationAmount = accommodationAmount;
            return this;
        }

        /**
         * 
         * @param transferAmount
         * @return cost builder
         */
        public CostBuilder setTransferAmount(final int transferAmount) {
            this.transferAmount = transferAmount;
            return this;
        }

        /**
         * 
         * @param otherAmount
         * @return cost builder
         */
        public CostBuilder setOtherAmount(final int otherAmount) {
            this.otherAmount = otherAmount;
            return this;
        }

        /**
         * 
         * @param depositAmount
         * @return cost builder
         */
        public CostBuilder setDepositAmount(final int depositAmount) {
            this.depositAmount = depositAmount;
            return this;
        }

        /**
         * 
         * @param flightAmountActive
         * @return cost builder
         */
        public CostBuilder setFlightAmountActive(final boolean flightAmountActive) {
            this.flightAmountActive = flightAmountActive;
            return this;
        }

        /**
         * 
         * @param accommodationAmountActive
         * @return cost builder
         */
        public CostBuilder setAccommodationAmountActive(final boolean accommodationAmountActive) {
            this.accommodationAmountActive = accommodationAmountActive;
            return this;
        }

        /**
         * 
         * @param transferAmountActive
         * @return cost builder
         */
        public CostBuilder setTransferAmountActive(final boolean transferAmountActive) {
            this.transferAmountActive = transferAmountActive;
            return this;
        }

        /**
         * 
         * @param otherAmountActive
         * @return cost builder
         */
        public CostBuilder setOtherAmountActive(final boolean otherAmountActive) {
            this.otherAmountActive = otherAmountActive;
            return this;
        }

        /**
         * Build cost object.
         * 
         * @return cost object
         */
        public Cost build() {
            return new Cost(this);
        }

    }
}
