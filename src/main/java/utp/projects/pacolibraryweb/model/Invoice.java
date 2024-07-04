package utp.projects.pacolibraryweb.model;

import java.sql.Date;
import java.sql.Time;

/**
 * Represents an invoice in the library system.
 */
public class Invoice {
    private String invoiceNumber;
    private String branch;
    private Time time;
    private Date date;
    private double totalCost;
    private int quantity;

    /**
     * Constructs an invoice object with the specified details.
     * 
     * @param invoiceNumber The invoice number.
     * @param branch The branch.
     * @param time The time.
     * @param date The date.
     * @param totalCost The total cost.
     * @param quantity The quantity.
     */
    public Invoice(String invoiceNumber, String branch, Time time, Date date, double totalCost, int quantity) {
        this.invoiceNumber = invoiceNumber;
        this.branch = branch;
        this.time = time;
        this.date = date;
        this.totalCost = totalCost;
        this.quantity = quantity;
    }

    /**
     * Returns the invoice number.
     * 
     * @return The invoice number.
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Sets the invoice number.
     * 
     * @param invoiceNumber The invoice number to set.
     */
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    /**
     * Returns the branch.
     * 
     * @return The branch.
     */
    public String getBranch() {
        return branch;
    }

    /**
     * Sets the branch.
     * 
     * @param branch The branch to set.
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * Returns the time.
     * 
     * @return The time.
     */
    public Time getTime() {
        return time;
    }

    /**
     * Sets the time.
     * 
     * @param time The time to set.
     */
    public void setTime(Time time) {
        this.time = time;
    }

    /**
     * Returns the date.
     * 
     * @return The date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date.
     * 
     * @param date The date to set.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Returns the total cost.
     * 
     * @return The total cost.
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Sets the total cost.
     * 
     * @param totalCost The total cost to set.
     */
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * Returns the quantity.
     * 
     * @return The quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity.
     * 
     * @param quantity The quantity to set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
