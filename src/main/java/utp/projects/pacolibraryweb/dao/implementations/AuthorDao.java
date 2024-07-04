package utp.projects.pacolibraryweb.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import utp.projects.pacolibraryweb.dao.interfaces.IAuthorDao;
import utp.projects.pacolibraryweb.model.Author;
import utp.projects.pacolibraryweb.util.DatabaseConnection;

/**
 * The AuthorDao class provides methods to interact with the authors table in the database.
 */
public class AuthorDao implements IAuthorDao {
    private static final Logger LOGGER = Logger.getLogger(AuthorDao.class.getName());

    private static final String GET_AUTHOR_BY_ID_QUERY = "SELECT * FROM authors WHERE id = ?";

    /**
     * Retrieves an author from the database based on the specified ID.
     *
     * @param id The ID of the author to retrieve.
     * @return The Author object representing the retrieved author, or null if not found.
     * @throws SQLException If an error occurs while retrieving the author.
     */
    @Override
    public Author getAuthorById(int id) throws SQLException {
        LOGGER.log(Level.INFO, "Getting author with ID: {0}", id);
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_AUTHOR_BY_ID_QUERY)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Author author = new Author(resultSet.getInt("id"), resultSet.getString("name"));
                    LOGGER.log(Level.INFO, "Author retrieved: {0}", author);
                    return author;
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error getting author: {0}", e.getMessage());
            throw e;
        }
        return null;
    }
}
