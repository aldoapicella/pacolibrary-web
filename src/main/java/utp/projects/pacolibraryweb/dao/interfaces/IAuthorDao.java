package utp.projects.pacolibraryweb.dao.interfaces;

import java.sql.SQLException;

import utp.projects.pacolibraryweb.model.Author;

public interface IAuthorDao {
    Author getAuthorById(int id) throws SQLException;
}
