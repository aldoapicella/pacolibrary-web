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
import jakarta.servlet.http.HttpSession;
import utp.projects.pacolibraryweb.dao.implementations.ClientDao;
import utp.projects.pacolibraryweb.dao.implementations.EmployeeDao;
import utp.projects.pacolibraryweb.dao.interfaces.IClientDao;
import utp.projects.pacolibraryweb.dao.interfaces.IEmployeeDao;
import utp.projects.pacolibraryweb.model.Client;
import utp.projects.pacolibraryweb.model.Employee;
import utp.projects.pacolibraryweb.model.UserType;


/**
 * The AuthServlet class is responsible for handling authentication requests.
 * It receives user credentials, validates them against the corresponding DAO,
 * and sets session attributes based on the authentication result. It then
 * redirects the user to the appropriate page based on the authentication status.
 */
@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(AuthServlet.class.getName());

    private final IClientDao clientDao = new ClientDao();
    private final IEmployeeDao employeeDao = new EmployeeDao();

    /**
     * Handles the POST request by validating the user's credentials and setting session attributes.
     * If the user is authenticated, they are redirected to the home page; otherwise, they are redirected to the login page.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserType userType = UserType.valueOf(request.getParameter("user_type"));
        String identifier = request.getParameter("identifier");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        session.setAttribute("userType", userType);

        boolean isAuthenticated = false;
        String userName = "";

        try {
            if (userType == UserType.CLIENT) {
                isAuthenticated = clientDao.validateClient(identifier, password);
                userName = isAuthenticated ? getClientName(identifier) : "";
            } else if (userType == UserType.EMPLOYEE) {
                isAuthenticated = employeeDao.validateEmployee(identifier, password);
                userName = isAuthenticated ? getEmployeeName(identifier) : "";
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "An error occurred while authenticating the user.", e);
        }

        session.setAttribute("isAuthenticated", isAuthenticated);
        session.setAttribute("userName", userName);
        response.sendRedirect(isAuthenticated ? "home.jsp" : "login.jsp");
    }

    private String getClientName(String identifier) throws SQLException {
        Client client = clientDao.getClientByEmail(identifier);
        return client.getFirstName() + " " + client.getLastName();
    }

    private String getEmployeeName(String identifier) throws SQLException {
        Employee employee = employeeDao.getEmployeeById(identifier);
        return employee.getFirstName() + " " + employee.getLastName();
    }
}
