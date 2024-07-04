package utp.projects.pacolibraryweb.service;

import java.sql.SQLException;
import java.util.List;

import utp.projects.pacolibraryweb.dao.interfaces.IBookDao;
import utp.projects.pacolibraryweb.dao.interfaces.IPublisherDao;
import utp.projects.pacolibraryweb.dao.implementations.AuthorDao;
import utp.projects.pacolibraryweb.dao.implementations.BookDao;
import utp.projects.pacolibraryweb.dao.implementations.PublisherDao;
import utp.projects.pacolibraryweb.dao.interfaces.IAuthorDao;
import utp.projects.pacolibraryweb.model.Book;
import utp.projects.pacolibraryweb.model.Publisher;
import utp.projects.pacolibraryweb.model.Author;

public class CatalogService {

    private final IBookDao bookDao;
    private final IPublisherDao publisherDao;
    private final IAuthorDao authorDao;

    public CatalogService() {
        this.bookDao = new BookDao();
        this.publisherDao = new PublisherDao();
        this.authorDao = new AuthorDao();
    }

    public List<Book> getBooksByPublisherAndAuthor(int publisherId, int authorId) throws SQLException {
        return bookDao.getBooksByPublisherAndAuthor(publisherId, authorId);
    }

    public Author getAuthorByName(String authorName) throws SQLException {
        return authorDao.getAuthorByName(authorName);
    }

    public Publisher getPublisherByName(String publisherName) throws SQLException {
        return publisherDao.getPublisherByName(publisherName);
    }
}