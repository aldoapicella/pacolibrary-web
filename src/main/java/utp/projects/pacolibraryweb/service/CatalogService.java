package utp.projects.pacolibraryweb.service;

import java.sql.SQLException;
import java.util.List;

import utp.projects.pacolibraryweb.dao.implementations.AuthorDao;
import utp.projects.pacolibraryweb.dao.implementations.BookDao;
import utp.projects.pacolibraryweb.dao.implementations.PublisherDao;
import utp.projects.pacolibraryweb.dao.interfaces.IAuthorDao;
import utp.projects.pacolibraryweb.dao.interfaces.IBookDao;
import utp.projects.pacolibraryweb.dao.interfaces.IPublisherDao;
import utp.projects.pacolibraryweb.model.Author;
import utp.projects.pacolibraryweb.model.Book;
import utp.projects.pacolibraryweb.model.Publisher;

/**
 * The CatalogService class provides methods to interact with the catalog of books,
 * authors, and publishers in the library system.
 */
public class CatalogService {

    private final IBookDao bookDao;
    private final IPublisherDao publisherDao;
    private final IAuthorDao authorDao;

    /**
     * Constructs a new CatalogService object.
     */
    public CatalogService() {
        this.bookDao = new BookDao();
        this.publisherDao = new PublisherDao();
        this.authorDao = new AuthorDao();
    }

    /**
     * Retrieves a list of books based on the given publisher ID and author ID.
     *
     * @param publisherId The ID of the publisher.
     * @param authorId    The ID of the author.
     * @return A list of books matching the given publisher ID and author ID.
     * @throws SQLException If an error occurs while retrieving the books.
     */
    public List<Book> getBooksByPublisherAndAuthor(int publisherId, int authorId) throws SQLException {
        return bookDao.getBooksByPublisherAndAuthor(publisherId, authorId);
    }

    /**
     * Retrieves an author object based on the given author name.
     *
     * @param authorName The name of the author.
     * @return An Author object matching the given author name.
     * @throws SQLException If an error occurs while retrieving the author.
     */
    public Author getAuthorByName(String authorName) throws SQLException {
        return authorDao.getAuthorByName(authorName);
    }

    /**
     * Retrieves a publisher object based on the given publisher name.
     *
     * @param publisherName The name of the publisher.
     * @return A Publisher object matching the given publisher name.
     * @throws SQLException If an error occurs while retrieving the publisher.
     */
    public Publisher getPublisherByName(String publisherName) throws SQLException {
        return publisherDao.getPublisherByName(publisherName);
    }
}