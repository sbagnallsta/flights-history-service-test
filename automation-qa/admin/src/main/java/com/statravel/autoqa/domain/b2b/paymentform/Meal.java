package com.statravel.autoqa.domain.b2b.paymentform;

/**
 * 
 * @author STA Development Team
 *
 */
public final class Meal {

    private String vegetarian;
    private String diabetic;
    private String kosher;
    private String vegan;
    private String other;

    /**
     * 
     * @param mealBuilder
     *            meal builder
     */
    private Meal(final MealBuilder mealBuilder) {
        this.vegetarian = mealBuilder.vegetarian;
        this.diabetic = mealBuilder.diabetic;
        this.kosher = mealBuilder.kosher;
        this.vegan = mealBuilder.vegan;
        this.other = mealBuilder.other;
    }

    /**
     * @return the vegetarian
     */
    public String getVegetarian() {
        return vegetarian;
    }

    /**
     * @return the diabetic
     */
    public String getDiabetic() {
        return diabetic;
    }

    /**
     * @return the kosher
     */
    public String getKosher() {
        return kosher;
    }

    /**
     * @return the vegan
     */
    public String getVegan() {
        return vegan;
    }

    /**
     * @return the other
     */
    public String getOther() {
        return other;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Meal [vegetarian=" + vegetarian + ", diabetic=" + diabetic + ", kosher=" + kosher + ", vegan=" + vegan + ", other=" + other + "]";
    }

    /**
     * 
     * @author STA Development Team
     *
     */
    public static class MealBuilder {

        private String vegetarian;
        private String diabetic;
        private String kosher;
        private String vegan;
        private String other;

        /**
         * 
         * @param vegetarian
         * @return meal builder
         */
        public MealBuilder setVegetarian(final String vegetarian) {
            this.vegetarian = vegetarian;
            return this;

        }

        /**
         * 
         * @param diabetic
         * @return meal builder
         */
        public MealBuilder setDiabetic(final String diabetic) {
            this.diabetic = diabetic;
            return this;

        }

        /**
         * 
         * @param kosher
         * @return meal builder
         */
        public MealBuilder setKosher(final String kosher) {
            this.kosher = kosher;
            return this;
        }

        /**
         * 
         * @param vegan
         * @return meal breaker
         */
        public MealBuilder setVegan(final String vegan) {
            this.vegan = vegan;
            return this;
        }

        /**
         * 
         * @param other
         * @return meal object
         */
        public MealBuilder setOther(final String other) {
            this.other = other;
            return this;
        }

        /**
         * Build meal object.
         * 
         * @return seat object
         */
        public Meal build() {
            return new Meal(this);
        }
    }

}
