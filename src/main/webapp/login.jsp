<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <link rel="shortcut icon" href="./images/LOGO.png" alt="logo">
    <!--Documentos CSS utilizados-->
    <link rel="stylesheet" href="./styles/login.css">
    <!---Fuente Nunito de Google Fonts-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;700&display=swap" rel="stylesheet">
    <!---Fuente Playwrite England SemiJoined de Google Fonts-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Playwrite+GB+S:wght@100..400&display=swap" rel="stylesheet">
</head>
<body>
    <!--HEADER-->
    <header>
        <!--LOGO Y REDES-->
        <div class="LogoRedes">
            <div class="logo">
                <img src="./images/LOGO.png" alt="Librería ¡Donde Paco!">
            </div>
            <div class="Redes">
                <ul>
                    <li><a href="https://www.instagram.com"><img src="./images/Instagram.png" alt="Instagram"></a></li>
                    <li><a href="https://www.facebook.com"><img src="./images/Facebook.png" alt="Facebook"></a></li>
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
    <div class="login-contenedor">
        <div class="login">
            <h2>Inicio de sesión</h2>
            <hr>
            <!-- Enlaces de las pestañas -->
            <div class="tabs">
                <a href="#" class="tab-link current" data-tab="tab-1">Cliente</a>
                <a href="#" class="tab-link" data-tab="tab-2">Empleado</a>
            </div>
            <div id="tab-1" class="tab-content current">
                <form action="/auth" method="post">
                    <input type="hidden" name="user_type" value="CLIENT">
                    <div class="input-group">
                        <label for="client-email">Email</label>
                        <input type="email" id="client-email" name="identifier" required>
                    </div>
                    <div class="input-group">
                        <label for="client-password">Contraseña</label>
                        <input type="password" id="client-password" name="password" required>
                    </div>
                    <button type="submit">Acceder</button>
                </form>
                <div class="registrar">
                    <p>¿No tienes cuenta? <a href="registrocliente.jsp">Regístrate aquí</a></p>
                </div>
            </div>
            <div id="tab-2" class="tab-content">
                <form action="/auth" method="post">
                    <input type="hidden" name="user_type" value="EMPLOYEE">
                    <div class="input-group">
                        <label for="employee-email">Email</label>
                        <input type="email" id="employee-email" name="identifier" required>
                    </div>
                    <div class="input-group">
                        <label for="employee-password">Contraseña</label>
                        <input type="password" id="employee-password" name="password" required>
                    </div>
                    <button type="submit">Acceder</button>
                </form>
                <div class="registrar">
                    <p>¿No tienes cuenta? <a href="registro.jsp">Regístrate aquí</a></p>
                </div>
            </div>
        </div>
    </div>
</main>

<script>
document.addEventListener('DOMContentLoaded', () => {
    const tabs = document.querySelectorAll('.tab-link');
    const contents = document.querySelectorAll('.tab-content');

    tabs.forEach(tab => {
        tab.addEventListener('click', (e) => {
            e.preventDefault(); // Evitar que el enlace recargue la página
            
            tabs.forEach(t => t.classList.remove('current'));
            contents.forEach(c => c.classList.remove('current'));

            tab.classList.add('current');
            document.getElementById(tab.getAttribute('data-tab')).classList.add('current');
        });
    });
});
</script>

</body>
</html>