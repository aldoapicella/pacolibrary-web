<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    HttpSession session = request.getSession(false);
    String userName = (session != null) ? (String) session.getAttribute("userName") : null;
    String userType = (session != null) ? (String) session.getAttribute("userType") : null;
%>
<header>
    <!--LOGO Y REDES-->
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
    <!--MENU-->
    <div class="Menu">
        <ul>
            <li><a href="home.jsp">Home</a></li>
            <li><a href="sobrenosotros.jsp">Sobre Nosotros</a></li>
            <li><a href="sucursal.jsp">Contacto</a></li>
        </ul>  
        <div class="Usuario">
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
</header>