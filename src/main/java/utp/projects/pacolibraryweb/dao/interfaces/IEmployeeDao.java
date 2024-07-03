package utp.projects.pacolibraryweb.dao.interfaces;

import java.sql.SQLException;

import utp.projects.pacolibraryweb.model.Employee;
/**
 * The IEmployeeDao interface provides methods for accessing and manipulating employee data.
 */
public interface IEmployeeDao {
    
    /**
     * Validates an employee's email and password.
     *
     * @param email    the email of the employee
     * @param password the password of the employee
     * @return true if the employee is valid, false otherwise
     * @throws SQLException if there is an error accessing the database
     */
    boolean validateEmployee(String email, String password) throws SQLException;
    
    /**
     * Adds a new employee to the database.
     *
     * @param employee the employee to be added
     * @throws SQLException if there is an error accessing the database
     */
    void addEmployee(Employee employee) throws SQLException;

    /**
     * Retrieves an employee from the database by their id.
     * 
     * @param id the id of the employee to retrieve
     * @return the employee with the specified id
     * @throws SQLException if there is an error accessing the database
     */
    Employee getEmployeeById(String id) throws SQLException;
}
