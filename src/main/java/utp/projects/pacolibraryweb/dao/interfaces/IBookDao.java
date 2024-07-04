package utp.projects.pacolibraryweb.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import utp.projects.pacolibraryweb.model.Book;
/**
 * This interface represents a data access object for managing books.
 */
public interface IBookDao {
    /**
     * Retrieves a list of books based on the given publisher ID and author ID.
     *
     * @param publisherId The ID of the publisher.
     * @param authorId The ID of the author.
     * @return A list of books that match the given publisher ID and author ID.
     * @throws SQLException If an error occurs while retrieving the books.
     */
    public List<Book> getBooksByPublisherAndAuthor(int publisherId, int authorId) throws SQLException;
}
