package utp.projects.pacolibraryweb.dao.interfaces;

import java.sql.SQLException;

import utp.projects.pacolibraryweb.model.Author;

/**
 * The IAuthorDao interface provides methods for accessing and manipulating author data in the database.
 */
public interface IAuthorDao {
    /**
     * Retrieves an author by their name.
     *
     * @param name the name of the author to retrieve
     * @return the Author object representing the author with the specified name
     * @throws SQLException if an error occurs while accessing the database
     */
    Author getAuthorByName(String name) throws SQLException;
}
