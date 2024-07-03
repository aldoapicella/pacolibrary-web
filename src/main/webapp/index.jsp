<!DOCTYPE html>
<html>
<head>
    <title>Inicio</title>
</head>
<body>
    <header>
        <h1>Bienvenido a DockerJavaWebApp</h1>
        <div>
            <%
                HttpSession session = request.getSession(false);
                if (session != null && session.getAttribute("userName") != null) {
                    String userType = (String) session.getAttribute("userType");
                    String userName = (String) session.getAttribute("userName");
                    if ("CLIENT".equals(userType)) {
                        out.println("Cliente: " + userName);
                    } else if ("EMPLOYEE".equals(userType)) {
                        out.println("Empleado: " + userName);
                    }
                } else {
                    out.println("<a href='login.jsp'>Unete</a>");
                }
            %>
        </div>
    </header>
    <a href="register.jsp">Registrar</a>
    <a href="login.jsp">Iniciar Sesión</a>
</body>
</html>
