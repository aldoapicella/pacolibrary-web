package utp.projects.pacolibraryweb.model;

import java.sql.Date;
import java.sql.Time;

public class Invoice {
    private String invoiceNumber;
    private String branch;
    private Time time;
    private Date date;
    private double totalCost;
    private int quantity;

    public Invoice(String invoiceNumber, String branch, Time time, Date date, double totalCost, int quantity) {
        this.invoiceNumber = invoiceNumber;
        this.branch = branch;
        this.time = time;
        this.date = date;
        this.totalCost = totalCost;
        this.quantity = quantity;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }
}
