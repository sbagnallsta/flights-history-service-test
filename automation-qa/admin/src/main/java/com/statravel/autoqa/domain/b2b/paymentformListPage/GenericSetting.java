package com.statravel.autoqa.domain.b2b.paymentformListPage;

/**
 * 
 * @author STA Development Team
 *
 */
public final class GenericSetting {

    private String phoneNo;
    private String bannerCrossSell;
    private String bannerAdHyperlink;
    private String generalTAndC;
    private String insuranceTAndC;
    private String thirdPartyTAndC;
    private String heading;
    private boolean headingActive;
    private boolean phoneNoActive;
    private boolean bannerCrossSellActive;
    private boolean bannerAdHyperlinkActive;
    private boolean generalTAndCActive;
    private boolean insuranceTAndCActive;
    private boolean thirdPartyTAndCActive;

    /**
     * 
     * @param genericSettingBuilder
     *            generic setting builder
     */
    public GenericSetting(final GenericSettingBuilder genericSettingBuilder) {
        this.phoneNo = genericSettingBuilder.phoneNo;
        this.bannerCrossSell = genericSettingBuilder.bannerCrossSell;
        this.bannerAdHyperlink = genericSettingBuilder.bannerAdHyperlink;
        this.generalTAndC = genericSettingBuilder.generalTAndC;
        this.insuranceTAndC = genericSettingBuilder.insuranceTAndC;
        this.thirdPartyTAndC = genericSettingBuilder.thirdPartyTAndC;
        this.heading = genericSettingBuilder.heading;
        this.phoneNoActive = genericSettingBuilder.phoneNoActive;
        this.bannerCrossSellActive = genericSettingBuilder.bannerCrossSellActive;
        this.bannerAdHyperlinkActive = genericSettingBuilder.bannerAdHyperlinkActive;
        this.generalTAndCActive = genericSettingBuilder.generalTAndCActive;
        this.insuranceTAndCActive = genericSettingBuilder.insuranceTAndCActive;
        this.thirdPartyTAndCActive = genericSettingBuilder.thirdPartyTAndCActive;
        this.headingActive = genericSettingBuilder.headingActive;
    }

    /**
     * @return the phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * @return the bannerCrossSell
     */
    public String getBannerCrossSell() {
        return bannerCrossSell;
    }

    /**
     * @return the bannerAdHyperlink
     */
    public String getBannerAdHyperlink() {
        return bannerAdHyperlink;
    }

    /**
     * @return the generalTAndC
     */
    public String getGeneralTAndC() {
        return generalTAndC;
    }

    /**
     * @return the insuranceTAndC
     */
    public String getInsuranceTAndC() {
        return insuranceTAndC;
    }

    /**
     * @return the thirdPartyTAndC
     */
    public String getThirdPartyTAndC() {
        return thirdPartyTAndC;
    }

    /**
     * @return the heading
     */
    public String getHeading() {
        return heading;
    }

    /**
     * @return the headingActive
     */
    public boolean isHeadingActive() {
        return headingActive;
    }

    /**
     * @return the phoneNoActive
     */
    public boolean isPhoneNoActive() {
        return phoneNoActive;
    }

    /**
     * @return the bannerCrossSellActive
     */
    public boolean isBannerCrossSellActive() {
        return bannerCrossSellActive;
    }

    /**
     * @return the bannerAdHyperlinkActive
     */
    public boolean isBannerAdHyperlinkActive() {
        return bannerAdHyperlinkActive;
    }

    /**
     * @return the generalTAndCActive
     */
    public boolean isGeneralTAndCActive() {
        return generalTAndCActive;
    }

    /**
     * @return the insuranceTAndCActive
     */
    public boolean isInsuranceTAndCActive() {
        return insuranceTAndCActive;
    }

    /**
     * @return the thirdPartyTAndCActive
     */
    public boolean isThirdPartyTAndCActive() {
        return thirdPartyTAndCActive;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "GenericSetting [phoneNo=" + phoneNo + ", bannerCrossSell=" + bannerCrossSell + ", bannerAdHyperlink=" + bannerAdHyperlink
                + ", generalTAndC=" + generalTAndC + ", insuranceTAndC=" + insuranceTAndC + ", thirdPartyTAndC=" + thirdPartyTAndC + ", heading="
                + heading + ", headingActive=" + headingActive + ", phoneNoActive=" + phoneNoActive + ", bannerCrossSellActive="
                + bannerCrossSellActive + ", bannerAdHyperlinkActive=" + bannerAdHyperlinkActive + ", generalTAndCActive=" + generalTAndCActive
                + ", insuranceTAndCActive=" + insuranceTAndCActive + ", thirdPartyTAndCActive=" + thirdPartyTAndCActive + "]";
    }

    /**
     * 
     * @author STA Development Team
     *
     */
    public static class GenericSettingBuilder {
        private String phoneNo;
        private String bannerCrossSell;
        private String bannerAdHyperlink;
        private String generalTAndC;
        private String insuranceTAndC;
        private String thirdPartyTAndC;
        private String heading;
        private boolean headingActive;
        private boolean phoneNoActive;
        private boolean bannerCrossSellActive;
        private boolean bannerAdHyperlinkActive;
        private boolean generalTAndCActive;
        private boolean insuranceTAndCActive;
        private boolean thirdPartyTAndCActive;

        /**
         * 
         * @param headingActive
         * @return generic setting builder
         */
        public GenericSettingBuilder setHeadingActive(final boolean headingActive) {
            this.headingActive = headingActive;
            return this;
        }

        /**
         * 
         * @param phoneNoActive
         * @return generic setting builder
         */
        public GenericSettingBuilder setPhoneNoActive(final boolean phoneNoActive) {
            this.phoneNoActive = phoneNoActive;
            return this;
        }

        /**
         * 
         * @param bannerCrossSellActive
         * @return generic setting builder
         */
        public GenericSettingBuilder setBannerCrossSellActive(final boolean bannerCrossSellActive) {
            this.bannerCrossSellActive = bannerCrossSellActive;
            return this;
        }

        /**
         * 
         * @param bannerAdHyperlinkActive
         * @return generic setting builder
         */
        public GenericSettingBuilder setBannerAdHyperlinkActive(final boolean bannerAdHyperlinkActive) {
            this.bannerAdHyperlinkActive = bannerAdHyperlinkActive;
            return this;
        }

        /**
         * 
         * @param generalTAndCActive
         * @return generic setting builder
         */
        public GenericSettingBuilder setGeneralTAndCActive(final boolean generalTAndCActive) {
            this.generalTAndCActive = generalTAndCActive;
            return this;
        }

        /**
         * 
         * @param insuranceTAndCActive
         * @return generic setting builder
         */
        public GenericSettingBuilder setInsuranceTAndCActive(final boolean insuranceTAndCActive) {
            this.insuranceTAndCActive = insuranceTAndCActive;
            return this;
        }

        /**
         * 
         * @param thirdPartyTAndCActive
         * @return generic setting builder
         */
        public GenericSettingBuilder setThirdPartyTAndCActive(final boolean thirdPartyTAndCActive) {
            this.thirdPartyTAndCActive = thirdPartyTAndCActive;
            return this;
        }

        /**
         * 
         * @param phoneNo
         * @return generic setting builder
         */
        public GenericSettingBuilder setPhoneNo(final String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        /**
         * 
         * @param bannerCrossSell
         * @return generic setting builder
         */
        public GenericSettingBuilder setBannerCrossSell(final String bannerCrossSell) {
            this.bannerCrossSell = bannerCrossSell;
            return this;
        }

        /**
         * 
         * @param bannerAdHyperlink
         * @return generic setting builder
         */
        public GenericSettingBuilder setBannerAdHyperlink(final String bannerAdHyperlink) {
            this.bannerAdHyperlink = bannerAdHyperlink;
            return this;
        }

        /**
         * 
         * @param generalTAndC
         * @return generic setting builder
         */
        public GenericSettingBuilder setGeneralTAndC(final String generalTAndC) {
            this.generalTAndC = generalTAndC;
            return this;
        }

        /**
         * 
         * @param insuranceTAndC
         * @return generic setting builder
         */
        public GenericSettingBuilder setInsuranceTAndC(final String insuranceTAndC) {
            this.insuranceTAndC = insuranceTAndC;
            return this;
        }

        /**
         * 
         * @param thirdPartyTAndC
         * @return generic setting builder
         */
        public GenericSettingBuilder setThirdPartyTAndC(final String thirdPartyTAndC) {
            this.thirdPartyTAndC = thirdPartyTAndC;
            return this;
        }

        /**
         * 
         * @param heading
         * @return generic setting builder
         */
        public GenericSettingBuilder setHeading(final String heading) {
            this.heading = heading;
            return this;
        }

        /**
         * build generic setting object.
         * 
         * @return generic setting object
         */
        public GenericSetting build() {
            return new GenericSetting(this);
        }
    }

}
