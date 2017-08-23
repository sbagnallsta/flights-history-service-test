package com.statravel.autoqa.domain.b2b.paymentform;

/**
 * 
 * @author STA Development Team
 *
 */
public final class CancellationFee {

    private String type;

    private String dueDate;

    private String penalty;

    /**
     * 
     * @param type
     *            cancellation type
     * @param dueDate
     *            due date
     * @param penalty
     *            penalty info
     */
    public CancellationFee(final String type, final String dueDate, final String penalty) {
        super();
        this.type = type;
        this.dueDate = dueDate;
        this.penalty = penalty;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the dueDate
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * @return the penalty
     */
    public String getPenalty() {
        return penalty;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CancellationFees [type=" + type + ", dueDate=" + dueDate + ", penalty=" + penalty + "]";
    }

}
