<footer>
    <link rel="stylesheet" href="../styles/styleheader_footer.css">
    <!--MENU-->
    <div class="Menu-footer">
        <ul>
            <li><a href="home.jsp">Home</a></li>
            <li><a href="sobrenosotros.jsp">Sobre Nosotros</a></li>
            <li><a href="sucursal.jsp">Contacto</a></li>
        </ul>  
        <div class="Usuario-footer">
            <a href="perfiles.jsp"><img src="../images/Usuario.png" alt="Usuario"></a>
            <%
                if (userName != null) {
                    if ("CLIENT".equals(userType)) {
                        out.println("Cliente: " + userName);
                    } else if ("EMPLOYEE".equals(userType)) {
                        out.println("Empleado: " + userName);
                    }
                } else {
                    out.println("<a href='login.jsp'>Únete</a>");
                }
            %>
        </div>
    </div> 
    <!--COPYRIGHT-->
    <div class="Copyright">
        <p>© 2024, Libreria ¡Donde Paco!</p>
    </div>
</footer>