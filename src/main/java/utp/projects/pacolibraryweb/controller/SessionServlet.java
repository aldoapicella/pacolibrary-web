package utp.projects.pacolibraryweb.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * This servlet handles the session-related functionality for the web application.
 * It retrieves the user's session attributes and forwards the request to the specified destination.
 */
@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String userName = null;
        String userType = null;

        if (session != null) {
            userName = (String) session.getAttribute("userName");
            userType = (String) session.getAttribute("userType");
        }

        request.setAttribute("userName", userName);
        request.setAttribute("userType", userType);

        String destination = request.getParameter("dest");
        if (destination == null || destination.isEmpty()) {
            destination = "home.jsp";
        }

        request.getRequestDispatcher(destination).forward(request, response);
    }
}