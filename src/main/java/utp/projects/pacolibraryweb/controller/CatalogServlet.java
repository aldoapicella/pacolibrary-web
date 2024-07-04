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

@WebServlet("/CatalogServlet")
public class CatalogServlet extends HttpServlet {
    private CatalogService catalogService;

    @Override
    public void init() {
        catalogService = new CatalogService();
    }

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