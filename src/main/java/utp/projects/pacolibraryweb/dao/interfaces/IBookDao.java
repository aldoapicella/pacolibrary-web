package utp.projects.pacolibraryweb.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import utp.projects.pacolibraryweb.model.Book;
public interface IBookDao {
    public List<Book> getBooksByPublisherAndAuthor(int publisherId, int authorId) throws SQLException;
}
