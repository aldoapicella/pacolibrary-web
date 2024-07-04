<div class="LogoRedes">
    <div class="logo">
        <img src="../images/LOGO.png" alt="Librería ¡Donde Paco!">
    </div>
    <div class="Redes">
        <ul>
            <li><a href="https://www.instagram.com"><img src="../images/Instagram.png" alt="Instagram"></a></li>
            <li><a href="https://www.facebook.com"><img src="../images/Facebook.png" alt="Facebook"></a></li>
            <li><a href="https://www.google.com/webhp?hl=es&sa=X&ved=0ahUKEwjdofSloIGHAxVQmYQIHetICooQPAgI"><img src="../images/Buscar.png" alt="Buscar"></a></li>
        </ul>
    </div>
</div>
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
