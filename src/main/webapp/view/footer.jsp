<footer>
    <!--MENU-->
    <div class="Menu-footer">
        <ul>
            <li><a href="home.jsp">Home</a></li>
            <li><a href="sobrenosotros.jsp">Sobre Nosotros</a></li>
            <li><a href="sucursal.jsp">Contacto</a></li>
        </ul>  
        <div class="Usuario-footer">
            <a href="perfiles.jsp"><img src="../images/Usuario.png" alt="Usuario"></a>
            <c:choose>
                <c:when test="${not empty userName}">
                    <c:if test="${userType == 'CLIENT'}">
                        Cliente: ${userName}
                    </c:if>
                    <c:if test="${userType == 'EMPLOYEE'}">
                        Empleado: ${userName}
                    </c:if>
                </c:when>
                <c:otherwise>
                    <a href='login.jsp'>Unete</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div> 
    <!--COPYRIGHT-->
    <div class="Copyright">
        <p>© 2024, Libreria ¡Donde Paco!</p>
    </div>
</footer>