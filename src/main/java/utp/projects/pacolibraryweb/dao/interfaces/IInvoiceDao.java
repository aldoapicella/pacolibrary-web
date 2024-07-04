package utp.projects.pacolibraryweb.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import utp.projects.pacolibraryweb.model.Invoice;

/**
 * This interface represents the data access object for invoices.
 */
public interface IInvoiceDao {
    
    /**
     * Retrieves all invoices from the database.
     *
     * @return a list of all invoices
     * @throws SQLException if a database access error occurs
     */
    List<Invoice> getAllInvoices() throws SQLException;
    
    /**
     * Retrieves invoices by branch name from the database.
     *
     * @param branchName the name of the branch
     * @return a list of invoices for the specified branch
     * @throws SQLException if a database access error occurs
     */
    List<Invoice> getInvoicesByBranch(String branchName) throws SQLException;
}