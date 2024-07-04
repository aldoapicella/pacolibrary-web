<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registro Empleado</title>
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
            background-color: #F2E5D5;
            padding: 10%;
            font-family: 'Nunito', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: calc(79vh - 165px); /* Ajusta la altura restando la altura del header y footer */
        }
        .registro-container {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 100%;
            height: auto;
        }
        .registro-box {
            background-color: white;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: center;
            width: 400px;
            border: 1px solid #1B3F48;
        }
        .registro-box h2 {
            margin: 0;
            color: #000;
            font-size: 24px; /* Ajuste del tamaño de la fuente */
            font-weight: bold; /* Texto en negrita */
        }
        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        input, select {
            width: 95%;
            padding: 10px;
            border-radius: 20px;
            border: 1px solid #1B3F48;
            outline: none;
        }
        label {
            color: #000;
            text-align: left;
        }
        button.btn {
            background-color: #1B3F48;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 20px;
            cursor: pointer;
            font-family: 'Nunito', sans-serif;
        }
        button.btn:hover {
            background-color: #163439;
        }
    </style>
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