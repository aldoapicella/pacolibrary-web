<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registro Exitoso</title>
    <style>
        body {
            font-family: 'Nunito', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #F2E5D5;
        }
        h2 {
            font-family: 'Playwrite GB S', cursive;
            color: #1B3F48;
        }
        main {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #F2E5D5;
        }
    </style>
</head>
    <!--HEADER-->
    <%!
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
    </header>
<body>
    <main>
        <div>
            <h2>Registro Exitoso</h2>
            <img src="realizado.gif" height="100px" width="100px">
        </div>
    </main>
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
</body>
</html>