<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Empleado</title>
    <link rel="shortcut icon" href="../images/LOGO.png" alt="logo">
    <!--Documentos CSS utilizados-->
    <link rel="stylesheet" href="../styles/registro.css">
    <!---Fuente Nunito de Google Fonts-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200..1000;1,200..1000&display=swap" rel="stylesheet">
    <!---Fuente Playwrite England SemiJoined de Google Fonts-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Playwrite+GB+S:wght@100..400&display=swap" rel="stylesheet">
</head>
<body>
    <%!
        HttpSession session = request.getSession(false);
        String userName = (session != null) ? (String) session.getAttribute("userName") : null;
        String userType = (session != null) ? (String) session.getAttribute("userType") : null;
    %>
    <!--HEADER-->
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
    <main>
        <div class="registro-container">
            <div class="registro-box">
                <h2>Registro de Empleado</h2>
                <hr>
                <form action="registerEmployee" method="post">
                    <label for="id">ID:</label>
                    <input type="text" id="id" name="id" required>
                    <div class="input-group">
                        <input type="text" id="firstName" name="firstName" placeholder="Nombre" required>
                        <input type="text" id="middleName" name="middleName" placeholder="Segundo nombre">
                    </div>
                    <div class="input-group">
                        <input type="text" id="lastName" name="lastName" placeholder="Apellido" required>
                        <input type="text" id="secondSurname" name="secondSurname" placeholder="Segundo apellido">
                    </div>
                    <input type="password" id="password" name="password" placeholder="Contraseña" required>
                    <input type="email" id="email" name="email" placeholder="Email" required>
                    <label for="date_of_birth">Fecha de Nacimiento:</label>
                    <input type="date" id="date_of_birth" name="date_of_birth" required>
                    <div class="input-group">
                        <input type="text" id="position" name="position" placeholder="Cargo" required>
                        <input type="text" id="cod_lib" name="cod_lib" placeholder="Codigo librería">
                    </div>
                    <button class="btn" type="submit">Registrar</button>
                </form>
            </div>
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
