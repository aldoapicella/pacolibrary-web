<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="ISO-8859-1"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
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
    
    <!--HEADER-->
    <header>
        <%@ include file="../view/header.jsp" %>
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
    
</body>
</html>
