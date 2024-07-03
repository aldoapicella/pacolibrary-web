package utp.projects.pacolibraryweb.controller;

import java.io.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import utp.projects.pacolibraryweb.model.Client;
import utp.projects.pacolibraryweb.model.Employee;
import utp.projects.pacolibraryweb.model.UserType;

import utp.projects.pacolibraryweb.dao.implementations.ClientDao;
import utp.projects.pacolibraryweb.dao.implementations.EmployeeDao;
import utp.projects.pacolibraryweb.dao.interfaces.IClientDao;
import utp.projects.pacolibraryweb.dao.interfaces.IEmployeeDao;

/**
 * The AuthServlet class provides a servlet for authenticating clients and employees.
 */
@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(AuthServlet.class.getName());

    private IClientDao clientDao = new ClientDao();
    private IEmployeeDao employeeDao = new EmployeeDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserType userType = UserType.valueOf(request.getParameter("user_type"));
        String identifier = request.getParameter("identifier");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        session.setAttribute("userType", userType);

        boolean isAuthenticated = false;
        String username = null;

        try {
            if (userType == UserType.CLIENT) {
                isAuthenticated = clientDao.validateClient(identifier, password);
                if (isAuthenticated) {
                    Client client = clientDao.getClientByEmail(identifier);
                    username = client.getFirstName() + " " + client.getLastName();
                }
            } else if (userType == UserType.EMPLOYEE) {
                isAuthenticated = employeeDao.validateEmployee(identifier, password);
                if (isAuthenticated) {
                    Employee employee = employeeDao.getEmployeeById(identifier);
                    username = employee.getFirstName() + " " + employee.getLastName();
                }
            }	
        } catch (Exception e) {
        }
