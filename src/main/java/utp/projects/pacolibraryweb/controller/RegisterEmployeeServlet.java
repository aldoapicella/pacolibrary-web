package utp.projects.pacolibraryweb.controller;

import java.io.IOException;
import java.sql.SQLException;
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
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String positionStr = request.getParameter("position");

        EmployePosition position = EmployePosition.valueOf(positionStr);

        Employee employee = new Employee(id, firstName, lastName, email, null, position, null);

        try {
            employeeDao.addEmployee(employee);
            response.sendRedirect("registroExitoso.jsp"); // Página de éxito
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error adding employee", e);
            response.sendRedirect("registroError.jsp"); // Página de error
        }
    }
}