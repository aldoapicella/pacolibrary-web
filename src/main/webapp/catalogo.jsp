<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head> 
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Catálogo</title>
    <link rel="stylesheet" href="./styles/catalogo.css">
</head>
<body>
    <!--HEADER-->
    <%@ include file="./view/header.jsp" %>
    <main>
        <div class="main-content">
            <aside class="filter-section">
                <h3>Filtrar</h3>
                <form action="CatalogoServlet" method="get">
                    <div class="filter-group">
                        <label for="author-filter">Por autor</label>
                        <input type="text" id="autor" name="autor" title="Escriba el Autor" placeholder="Gabriel García Márquez">
                    </div>
                    <div class="filter-group">
                        <label for="editorial-filter">Por editorial</label>
                        <select id="editorial-filter" name="editorial">
                            <option value="Oceano">Oceano</option>
                            <option value="Sudamericana">Sudamericana</option>
                            <option value="Universitaria">Universitaria</option>
                        </select>
                    </div>
                    <button type="submit" class="btn-filtrar">Filtrar</button>
                </form>
            </aside>
            <section class="catalog-section">
                <c:forEach var="book" items="${books}">
                    <div class="product-card">
                        <img src="../images/${book.isbn}.jpg" alt="Imagen del producto">
                        <h4>${book.title}</h4>
                        <p>$${book.price}</p>
                        <button><a href="comprar.html">Comprar</a></button>
                    </div>
                </c:forEach>
            </section>
        </div>
    </main>
    <%@ include file="./view/footer.jsp" %>
</body>
</html>