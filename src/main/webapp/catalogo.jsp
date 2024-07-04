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
    <header>
        <!--LOGO Y REDES-->
        <div class="LogoRedes">
            <div class="logo">
                <img src="./images/LOGO.png" alt="Librería ¡Donde Paco!">
            </div>
            <div class="Redes">
                <ul>
                    <li><a href="https://www.instagram.com"><img src="./images/Instagram.png" alt="Instagram"></a></li>
                    <li><a href="https://www.facebook.com"><img src="./images/Facebook.png" alt="Facebook"></a></li>
                    <li><a href="https://www.google.com/webhp?hl=es&sa=X&ved=0ahUKEwjdofSloIGHAxVQmYQIHetICooQPAgI"><img src="../images/Buscar.png" alt="Buscar"></a></li>
                </ul>
            </div>
        </div>
        <!--MENU-->
        <div class="Menu">
            <ul>
                <li><a href="home.jsp">Home</a></li>
                <li><a href="sobrenosotros.jsp">Sobre Nosotros</a></li>
                <li><a href="sucursal.jsp">Contacto</a></li>
            </ul>  
            <div class="Usuario">
                <a href="perfiles.jsp"><img src="./images/Usuario.png" alt="Usuario"></a>
                <c:choose>
                    <c:when test="${not empty userName}">
                        <c:choose>
                            <c:when test="${userType == 'CLIENT'}">
                                Cliente: ${userName}
                            </c:when>
                            <c:when test="${userType == 'EMPLOYEE'}">
                                Empleado: ${userName}
                            </c:when>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <a href='login.jsp'>Únete</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </header>
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
    <footer>
        <link rel="stylesheet" href="./styles/styleheader_footer.css">
        <!--MENU-->
        <div class="Menu-footer">
            <ul>
                <li><a href="home.jsp">Home</a></li>
                <li><a href="sobrenosotros.jsp">Sobre Nosotros</a></li>
                <li><a href="sucursal.jsp">Contacto</a></li>
            </ul>  
            <div class="Usuario-footer">
                <a href="perfiles.jsp"><img src="./images/Usuario.png" alt="Usuario"></a>
                <c:choose>
                    <c:when test="${not empty userName}">
                        <c:choose>
                            <c:when test="${userType == 'CLIENT'}">
                                Cliente: ${userName}
                            </c:when>
                            <c:when test="${userType == 'EMPLOYEE'}">
                                Empleado: ${userName}
                            </c:when>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <a href='login.jsp'>Únete</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div> 
        <!--COPYRIGHT-->
        <div class="Copyright">
            <p>© 2024, Libreria ¡Donde Paco!</p>
        </div>
    </footer>
</body>
</html>