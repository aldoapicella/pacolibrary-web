package utp.projects.pacolibraryweb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import utp.projects.pacolibraryweb.model.Invoice;
import utp.projects.pacolibraryweb.service.InvoiceService;
/**
 * The InvoiceServlet class is a servlet that handles requests related to invoices.
 * It retrieves invoice data from the InvoiceService and forwards it to the "historialVentas.jsp" page for display.
 */
@WebServlet("/InvoiceServlet")
public class InvoiceServlet extends HttpServlet {
    private InvoiceService invoiceService;

    @Override
    public void init() {
        invoiceService = new InvoiceService();
    }

    /**
     * Handles the HTTP GET request. Retrieves the invoices based on the branch name parameter and forwards the request to the "/historialVentas.jsp" page.
     *
     * @param request  the HttpServletRequest object that contains the request information
     * @param response the HttpServletResponse object that contains the response information
     * @throws ServletException if there is a servlet-related problem
     * @throws IOException      if there is an I/O problem
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String branchName = request.getParameter("Sucursal");
        List<Invoice> invoices;

        try {
            if (branchName == null || branchName.isEmpty()) {
                invoices = invoiceService.getAllInvoices();
            } else {
                invoices = invoiceService.getInvoicesByBranch(branchName);
            }

            request.setAttribute("invoices", invoices);
            request.getRequestDispatcher("/historialVentas.jsp").forward(request, response);
        } catch (ServletException | IOException | SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener el historial de facturas.");
        }
    }
}