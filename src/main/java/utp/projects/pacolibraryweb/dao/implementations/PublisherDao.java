package utp.projects.pacolibraryweb.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import utp.projects.pacolibraryweb.dao.interfaces.IPublisherDao;
import utp.projects.pacolibraryweb.model.Publisher;
import utp.projects.pacolibraryweb.util.DatabaseConnection;


/**
 * The PublisherDao class provides methods to interact with the publishers table in the database.
 */
public class PublisherDao implements IPublisherDao {
    private static final Logger LOGGER = Logger.getLogger(PublisherDao.class.getName());

    private static final String GET_PUBLISHER_BY_NAME_QUERY = "SELECT * FROM publishers WHERE name = ?";

    /**
     * Retrieves a publisher from the database based on the specified name.
     *
     * @param name The name of the publisher to retrieve.
     * @return The Publisher object representing the retrieved publisher, or null if not found.
     * @throws SQLException If an error occurs while retrieving the publisher.
     */
    @Override
    public Publisher getPublisherByName(String name) throws SQLException {
        LOGGER.log(Level.INFO, "Getting publisher with name: {0}", name);
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_PUBLISHER_BY_NAME_QUERY)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Publisher publisher = new Publisher(resultSet.getInt("id"), resultSet.getString("name"));
                    LOGGER.log(Level.INFO, "Publisher retrieved: {0}", publisher);
                    return publisher;
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error getting publisher: {0}", e.getMessage());
            throw e;
        }
        return null;
    }
}
