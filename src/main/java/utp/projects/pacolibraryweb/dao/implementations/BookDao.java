package utp.projects.pacolibraryweb.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import utp.projects.pacolibraryweb.model.Author;
import utp.projects.pacolibraryweb.model.Book;
import utp.projects.pacolibraryweb.model.Publisher;
import utp.projects.pacolibraryweb.util.DatabaseConnection;


/**
 * The BookDao class provides methods to interact with the book data in the database.
 */
public class BookDao {
    private static final Logger LOGGER = Logger.getLogger(BookDao.class.getName());

    private static final String GET_BOOKS_BY_PUBLISHER_AND_AUTHOR =
        "SELECT b.isbn, b.title, b.price, p.id, p.name, a.id, a.name " +
        "FROM book l " +
        "JOIN publisher e ON l.publisher_id = p.id " +
        "JOIN author a ON l.author_id = a.id " +
        "WHERE p.id = ? AND a.id = ?";

    /**
     * Retrieves a list of books based on the given publisher ID and author ID.
     *
     * @param publisherId The ID of the publisher.
     * @param authorId The ID of the author.
     * @return A list of books that match the given publisher ID and author ID.
     * @throws SQLException If an error occurs while retrieving the books.
     */
    public List<Book> getBooksByPublisherAndAuthor(int publisherId, int authorId) throws SQLException {
        LOGGER.log(Level.INFO, "Getting books by publisher ID: {0} and author ID: {1}", new Object[]{publisherId, authorId});
        List<Book> books = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_BOOKS_BY_PUBLISHER_AND_AUTHOR)) {
            statement.setInt(1, publisherId);
            statement.setInt(2, authorId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Publisher publisher = new Publisher(resultSet.getInt("p.id"), resultSet.getString("p.name"));
                    Author author = new Author(resultSet.getInt("a.id"), resultSet.getString("a.name"));
                    Book book = new Book(resultSet.getString("b.isbn"), resultSet.getString("b.title"), resultSet.getDouble("b.price"), author, publisher);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error getting books: {0}", e.getMessage());
            throw e;
        }
        return books;
    }
}
