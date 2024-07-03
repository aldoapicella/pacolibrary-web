package utp.projects.pacolibraryweb.dao.interfaces;

import java.sql.SQLException;

import utp.projects.pacolibraryweb.model.Client;

/**
 * The IClientDao interface provides methods for accessing and manipulating client data in the database.
 */
public interface IClientDao {
    
    /**
     * Validates a client's email and password.
     *
     * @param email    the client's email
     * @param password the client's password
     * @return true if the client's email and password are valid, false otherwise
     * @throws SQLException if an error occurs while accessing the database
     */
    boolean validateClient(String email, String password) throws SQLException;
    
    /**
     * Adds a new client to the database.
     *
     * @param client the client to be added
     * @throws SQLException if an error occurs while accessing the database
     */
    void addClient(Client client) throws SQLException;

    /**
     * Retireves a client from the database by their email.
     * 
     * @param email the email of the client to retrieve
     * @return the client with the specified id
     * @throws SQLException if an error occurs while accessing the database
     */
    Client getClientByEmail(String email) throws SQLException;
}
