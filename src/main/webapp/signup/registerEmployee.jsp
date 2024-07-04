<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <head> 
        <meta charset="UTF-8">
        <meta name="viewport" content="width-device-width">
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
</head>
<body>
    <main>
        <div class="registro-container">
            <div class="registro-box">
                <h2>Registro Empleado</h2>
                <form action="registerEmployee" method="post">
                    <label for="id">ID:</label>
                    <input type="text" id="id" name="id" required><br>

                    <label for="firstName">Nombre:</label>
                    <input type="text" id="firstName" name="firstName" required><br>

                    <label for="lastName">Apellido:</label>
                    <input type="text" id="lastName" name="lastName" required><br>

                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required><br>

                    <label for="position">Posición:</label>
                    <select id="position" name="position" required>
                        <option value="ADMINISTRATOR">Administrador</option>
                        <option value="LIBRARIAN">Bibliotecario</option>
                        <option value="ASSISTANT">Asistente</option>
                    </select><br>

                    <button class="btn" type="submit">Registrar</button>
                </form>
            </div>
        </div>
    </main>
</body>
</html>