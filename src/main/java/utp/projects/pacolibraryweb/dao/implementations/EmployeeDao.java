package utp.projects.pacolibraryweb.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utp.projects.pacolibraryweb.dao.interfaces.IEmployeeDao;
import utp.projects.pacolibraryweb.model.Employee;
import utp.projects.pacolibraryweb.util.DatabaseConnection;

/**
 * This class represents a data access object for the Employee entity. It provides
 * methods to interact with the database and perform CRUD operations on the
 * Employee table.
 */
public class EmployeeDao implements IEmployeeDao{
    private static final String VALIDATE_EMPLOYEE_QUERY = "SELECT COUNT(*) FROM employees WHERE email = ? AND password = ?";
    private static final String ADD_EMPLOYEE_QUERY = "INSERT INTO employees (first_name, last_name, email, password, position) VALUES (?, ?, ?, ?, ?)";

    /**
     * Validates an employee by checking if the provided email and password match a
     * record in the database.
     *
     * @param email The email of the employee.
     * @param password The password of the employee.
     * @return true if the employee is valid, false otherwise.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public boolean validateEmployee(String email, String password) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(VALIDATE_EMPLOYEE_QUERY)) {
            statement.setString(1, email);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                return resultSet.getInt(1) == 1;
            }
        }
    }

    /**
     * Adds a new employee to the database.
     *
     * @param employee The employee object to be added.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void addEmployee(Employee employee) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(ADD_EMPLOYEE_QUERY)) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getEmail());
            statement.setString(4, employee.getPassword());
            statement.setString(5, employee.getPosition().name());
            statement.executeUpdate();
        }
    }
}
