package utp.projects.pacolibraryweb.service;

import java.sql.SQLException;
import java.util.List;

import utp.projects.pacolibraryweb.dao.implementations.InvoiceDao;
import utp.projects.pacolibraryweb.dao.interfaces.IInvoiceDao;
import utp.projects.pacolibraryweb.model.Invoice;

/**
 * The InvoiceService class provides methods to retrieve invoices from the database.
 */
public class InvoiceService {
    private final IInvoiceDao invoiceDao;

    /**
     * Constructs an InvoiceService object.
     */
    public InvoiceService() {
        this.invoiceDao = new InvoiceDao();
    }

    /**
     * Retrieves all invoices from the database.
     *
     * @return a list of Invoice objects representing all the invoices.
     * @throws SQLException if there is an error accessing the database.
     */
    public List<Invoice> getAllInvoices() throws SQLException {
        return invoiceDao.getAllInvoices();
    }

    /**
     * Retrieves invoices by branch name from the database.
     *
     * @param branchName the name of the branch to filter the invoices.
     * @return a list of Invoice objects representing the invoices for the specified branch.
     * @throws SQLException if there is an error accessing the database.
     */
    public List<Invoice> getInvoicesByBranch(String branchName) throws SQLException {
        return invoiceDao.getInvoicesByBranch(branchName);
    }
}