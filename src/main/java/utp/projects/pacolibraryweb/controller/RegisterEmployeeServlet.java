package utp.projects.pacolibraryweb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import utp.projects.pacolibraryweb.dao.implementations.EmployeeDao;
import utp.projects.pacolibraryweb.dao.interfaces.IEmployeeDao;
import utp.projects.pacolibraryweb.model.EmployePosition;
import utp.projects.pacolibraryweb.model.Employee;

/**
 * Servlet implementation class RegisterEmployeeServlet
 */
@WebServlet("/registerEmployee")
public class RegisterEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(RegisterEmployeeServlet.class.getName());

    private final IEmployeeDao employeeDao = new EmployeeDao();

    /**
     * Handles the HTTP POST method to register a new employee.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String firstName = request.getParameter("first_name");
        String middleName = request.getParameter("middle_name");
        String lastName = request.getParameter("last_name");
        String secondLastName = request.getParameter("second_surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String positionStr = request.getParameter("position");
        String dateOfBirthStr = request.getParameter("date_of_birth");

        EmployePosition position = EmployePosition.valueOf(positionStr);
        
        // Parse the date of birth
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate;
        try {
            birthDate = dateFormat.parse(dateOfBirthStr);
        } catch (ParseException e) {
            LOGGER.log(Level.SEVERE, "Error parsing date of birth", e);
            response.sendRedirect("registroError.jsp");
            return;
        }

        Employee employee = new Employee(id, firstName, middleName, lastName, secondLastName, email, password, birthDate, position, null);

        try {
            employeeDao.addEmployee(employee);
            response.sendRedirect("registroExitoso.jsp");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error adding employee", e);
            response.sendRedirect("registroError.jsp");
        }
    }
}