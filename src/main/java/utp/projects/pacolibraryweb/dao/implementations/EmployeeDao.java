package utp.projects.pacolibraryweb.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import utp.projects.pacolibraryweb.dao.interfaces.IEmployeeDao;
import utp.projects.pacolibraryweb.model.EmployePosition;
import utp.projects.pacolibraryweb.model.Employee;
import utp.projects.pacolibraryweb.util.DatabaseConnection;

/**
 * This class represents a data access object for the Employee entity. It provides
 * methods to interact with the database and perform CRUD operations on the
 * Employee table.
 */
public class EmployeeDao implements IEmployeeDao{
    private static final Logger LOGGER = Logger.getLogger(EmployeeDao.class.getName());
    private static final String VALIDATE_EMPLOYEE_QUERY = "SELECT COUNT(*) FROM employee WHERE id = ? AND password = ?";
    private static final String ADD_EMPLOYEE_QUERY = "INSERT INTO employee (id, first_name, last_name, email, position) VALUES (?, ?, ?, ?, ?)";
    private static final String GET_EMPLOYEE_BY_ID_QUERY = "SELECT id, first_name, last_name, email, birth_date, position, library_code FROM employee WHERE id = ?";

    /**
     * Validates an employee by checking if the provided id and password match a
     * record in the database.
     *
     * @param id The id of the employee.
     * @param password The password of the employee.
     * @return true if the employee is valid, false otherwise.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public boolean validateEmployee(String id, String password) throws SQLException {
        LOGGER.log(Level.INFO, "Validating employee with ID: {0} and password: {1}", new Object[]{id, password});
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(VALIDATE_EMPLOYEE_QUERY)) {
            statement.setString(1, id);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                int count = resultSet.getInt(1);
                LOGGER.log(Level.INFO, "Validation query executed. Result count: {0}", count);
                return count == 1;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error validating employee: {0}", e.getMessage());
            throw e;
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
            statement.setString(1, employee.getId());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.setString(4, employee.getEmail());
            statement.setString(5, employee.getPosition().name());
            statement.executeUpdate();
            LOGGER.log(Level.INFO, "Employee added: {0}", employee.getId());
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error adding employee: {0}", e.getMessage());
            throw e;
        }
    }

    /**
     * Retrieves an employee from the database by their id.
     *
     * @param id The id of the employee to fetch.
     * @return The employee with the specified id.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public Employee getEmployeeById(String id) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(GET_EMPLOYEE_BY_ID_QUERY)) {
            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String email = resultSet.getString("email");
                    Date birthDate = resultSet.getDate("birth_date");
                    EmployePosition position = EmployePosition.valueOf(resultSet.getString("position"));
                    String libraryCode = resultSet.getString("library_code");
                    return new Employee(id, firstName, lastName, email, birthDate, position, libraryCode);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving employee: {0}", e.getMessage());
            throw e;
        }
        return null;
    }
}
