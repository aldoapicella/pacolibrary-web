package utp.projects.pacolibraryweb.dao.interfaces;

import java.sql.SQLException;

import utp.projects.pacolibraryweb.model.Publisher;

/**
 * The IPublisherDao interface provides methods to access and manipulate Publisher data in the database.
 */
public interface IPublisherDao {
    /**
     * Retrieves a Publisher object by its name
     *
     * @param name the name of the Publisher to retrieve
     * @return the Publisher object with the specified ID
     * @throws SQLException if an error occurs while accessing the database
     */
    Publisher getPublisherByName(String name) throws SQLException;
}
