package utp.projects.pacolibraryweb.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utp.projects.pacolibraryweb.dao.interfaces.IClientDao;
import utp.projects.pacolibraryweb.model.Client;
import utp.projects.pacolibraryweb.util.DatabaseConnection;

/**
 * This class represents a data access object for the Client entity. It provides
 * methods to interact with the database and perform CRUD operations on the
 * Client table.
 */
public class ClientDao implements IClientDao {
    private static final String VALIDATE_CLIENT_QUERY = "SELECT COUNT(*) FROM client WHERE email = ? AND password = ?";
    private static final String ADD_CLIENT_QUERY = "INSERT INTO client (first_name, middle_name, last_name, second_last_name, password, email) VALUES (?, ?, ?, ?, ?, ?)";

    /**
     * Validates a client by checking if the provided email and password match a
     * record in the database.
     *
     * @param email The email of the client.
     * @param password The password of the client.
     * @return true if the client is valid, false otherwise.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public boolean validateClient(String email, String password) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(VALIDATE_CLIENT_QUERY)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }
    }

    /**
     * Adds a new client to the database.
     *
     * @param client The client object to be added.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void addClient(Client client) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(ADD_CLIENT_QUERY)) {
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getMiddleName());
            statement.setString(3, client.getLastName());
            statement.setString(4, client.getSecondLastName());
            statement.setString(5, client.getPassword());
            statement.setString(6, client.getEmail());
            statement.executeUpdate();
        }
    }

    /**
     * Retrieves a client from the database by their email.
     *
     * @param email The email of the client to fetch.
     * @return The client object if found, null otherwise.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public Client getClientByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM client WHERE email = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("first_name");
                    String middleName = resultSet.getString("middle_name");
                    String lastName = resultSet.getString("last_name");
                    String secondLastName = resultSet.getString("second_last_name");
                    return new Client(id, firstName, middleName, lastName, secondLastName, email);
                }
            }
            return null;
        }
    }
}
