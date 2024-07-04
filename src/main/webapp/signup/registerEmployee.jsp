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
                    <li><a href="https://www.google.com/webhp?hl=es&sa=X&ved=0ahUKEwjdofSloIGHAxVQmYQIHetICooQPAgI"><img
                                src="../images/Buscar.png" alt="Buscar"></a></li>
                </ul>
            </div>
        </div>
        <!--MENU-->
        <div class="Menu">
            <ul>
                <li><a href="home.html">Home</a></li>
                <li><a href="sobrenosotros.html">Sobre Nosotros</a></li>
                <li><a href="sucursal.html">Contacto</a></li>
            </ul>  
            <div class="Usuario">
                <a href="perfiles.html"><img src="../images/Usuario.png" alt="Usuario"></a>
                <a href="perfiles.html">Iniciar Sesión</a>
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
                        <input type="text" id = "firstName" name="firstName" placeholder="Nombre" required>
                        <input type="text" id = "middleName" name="middleName" placeholder="Segundo nombre"> <!--segundo nombre se define como middleName"-->
                    </div>
                    <div class="input-group">
                        <input type="text" id = "lastName" name="lastName" placeholder="Apellido" required>
                        <input type="text" id = "second surname" name="second surname" placeholder="Segundo apellido"><!--segundo nombre se define como m secondSurname"-->
                    </div>
                    <input type="password" id = "password" name="password" placeholder="Contraseña" required> <!--se agrega contraseña password-->
                    <input type="email" id = "email"  name="email" placeholder="Email" required> <!--se agrega email como  email-->
                    <label for="date_of_birth" id="date_of_birth">Fecha de Nacimiento:</label>
                    <input type="date" name="date_of_birth" placeholder="Fecha de nacimiento" required> <!--se agrega fecha_nacimiento como  date_of_birth-->
                    <div class="input-group">
                        <input type="text" id = "position" name="position" placeholder="Cargo" required> <!--se agrega cargo definido  como  position-->
                        <input type="text" id= "cod_lib " name="cod_lib" placeholder="Codigo librería"> <!--se agrega codigo_libreria definido  como  cod_lib-->
                    </div>
                    <button class="btn" type="submit">Registrar</button>
                </form>
            </div>
        </div>
    </main>

  
    <jsp:include page="../WEB-INF/footer.jsp" />
</body>
</html>