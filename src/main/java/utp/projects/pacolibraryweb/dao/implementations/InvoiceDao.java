package utp.projects.pacolibraryweb.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import utp.projects.pacolibraryweb.dao.interfaces.IInvoiceDao;
import utp.projects.pacolibraryweb.model.Invoice;
import utp.projects.pacolibraryweb.util.DatabaseConnection;

/**
 * The InvoiceDao class is responsible for accessing and manipulating invoice data in the database.
 */
public class InvoiceDao implements IInvoiceDao {
    private static final Logger LOGGER = Logger.getLogger(InvoiceDao.class.getName());

    private static final String GET_ALL_INVOICES =
        "SELECT invoice_number, branch, time, date, total_cost, quantity FROM invoices";

    private static final String GET_INVOICES_BY_BRANCH =
        "SELECT invoice_number, branch, time, date, total_cost, quantity FROM invoices WHERE branch = ?";
    
    /**
     * Retrieves all invoices from the database.
     *
     * @return a list of Invoice objects representing all invoices in the database.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<Invoice> getAllInvoices() throws SQLException {
        List<Invoice> invoices = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_INVOICES);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Invoice invoice = new Invoice(
                    resultSet.getString("invoice_number"),
                    resultSet.getString("branch"),
                    resultSet.getTime("time"),
                    resultSet.getDate("date"),
                    resultSet.getDouble("total_cost"),
                    resultSet.getInt("quantity")
                );
                invoices.add(invoice);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving all invoices", e);
            throw e;
        }
        return invoices;
    }

    /**
     * Retrieves all invoices associated with a specific branch from the database.
     *
     * @param branchName the name of the branch to filter the invoices by.
     * @return a list of Invoice objects representing the invoices associated with the specified branch.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<Invoice> getInvoicesByBranch(String branchName) throws SQLException {
        List<Invoice> invoices = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_INVOICES_BY_BRANCH)) {
            statement.setString(1, branchName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Invoice invoice = new Invoice(
                        resultSet.getString("invoice_number"),
                        resultSet.getString("branch"),
                        resultSet.getTime("time"),
                        resultSet.getDate("date"),
                        resultSet.getDouble("total_cost"),
                        resultSet.getInt("quantity")
                    );
                    invoices.add(invoice);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving invoices by branch", e);
            throw e;
        }
        return invoices;
    }
}