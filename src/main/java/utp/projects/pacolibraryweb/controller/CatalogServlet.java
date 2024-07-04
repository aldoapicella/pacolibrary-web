package utp.projects.pacolibraryweb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import utp.projects.pacolibraryweb.model.Author;
import utp.projects.pacolibraryweb.model.Book;
import utp.projects.pacolibraryweb.model.Publisher;
import utp.projects.pacolibraryweb.service.CatalogService;

/**
 * The CatalogServlet class is a servlet that handles requests related to the catalog of books.
 * It retrieves information about authors and publishers from the request parameters and uses the CatalogService
 * to fetch the books that match the given author and publisher. The retrieved books are then forwarded to the
 * catalogo.jsp page for display.
 */
@WebServlet("/CatalogServlet")
public class CatalogServlet extends HttpServlet {
    private CatalogService catalogService;

    @Override
    public void init() {
        catalogService = new CatalogService();
    }

    /**
     * Handles the GET request by retrieving the author and publisher names from the request parameters,
     * fetching the books that match the given author and publisher, and forwarding the books to the catalogo.jsp page.
     *
     * If the author or publisher is not found, an error response with status code 404 is sent.
     * If an error occurs while retrieving the catalog, an error response with status code 500 is sent.
     *
     * @param request  The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException If an error occurs while processing the request.
     * @throws IOException      If an error occurs while handling the I/O operations.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String authorName = request.getParameter("autor");
        String publisherName = request.getParameter("editorial");

        try {
            Author author = catalogService.getAuthorByName(authorName);
            Publisher publisher = catalogService.getPublisherByName(publisherName);

            if (author != null && publisher != null) {
                List<Book> books = catalogService.getBooksByPublisherAndAuthor(publisher.getId(), author.getId());

                request.setAttribute("books", books);
                request.getRequestDispatcher("/catalogo.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Autor o editorial no encontrados.");
            }
        } catch (ServletException | IOException | SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener el catálogo de libros.");
        }
    }
}