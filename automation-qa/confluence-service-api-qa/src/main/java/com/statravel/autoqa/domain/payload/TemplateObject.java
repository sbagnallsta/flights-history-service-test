package com.statravel.autoqa.domain.payload;

/**
 * @author STA Development Team
 *
 */
public class TemplateObject {

    private String team;
    private String product;
    private String githubTag;
    private String changeRequestNumber;
    private String version;

    /**
     * 
     */
    public TemplateObject() {
        super();
        this.team = "Internal";
        this.product = "Saved Searches";
        this.version = "1.4";
        this.githubTag = "release-1.4";
        this.changeRequestNumber = "CHF1234";

    }

    /**
     * @return the team
     */
    public String getTeam() {
        return team;
    }

    /**
     * @param team
     *            the team to set
     */
    public void setTeam(String team) {
        this.team = team;
    }

    /**
     * @return the product
     */
    public String getProduct() {
        return product;
    }

    /**
     * @param product
     *            the product to set
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * @return the githubTag
     */
    public String getGithubTag() {
        return githubTag;
    }

    /**
     * @param githubTag
     *            the githubTag to set
     */
    public void setGithubTag(String githubTag) {
        this.githubTag = githubTag;
    }

    /**
     * @return the changeRequestNumber
     */
    public String getChangeRequestNumber() {
        return changeRequestNumber;
    }

    /**
     * @param changeRequestNumber
     *            the changeRequestNumber to set
     */
    public void setChangeRequestNumber(String changeRequestNumber) {
        this.changeRequestNumber = changeRequestNumber;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version
     *            the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

	@Override
	public String toString() {
		return "TemplateObject [team=" + team + ", product=" + product + ", githubTag=" + githubTag
				+ ", changeRequestNumber=" + changeRequestNumber + ", version=" + version + "]";
	}

}
