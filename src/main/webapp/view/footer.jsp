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
