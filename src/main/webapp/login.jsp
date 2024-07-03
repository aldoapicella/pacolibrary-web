<%@ include file="./view/header.jsp" %>

<main>
    <div class="login-contenedor">
        <div class="login">
            <h2>Inicio de sesión</h2>
            <hr>
            <ul class="tabs">
                <li class="tab-link current" data-tab="tab-1">Cliente</li>
                <li class="tab-link" data-tab="tab-2">Empleado</li>
            </ul>
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

<%@ include file="./view/footer.jsp" %>

<!-- Incluir el archivo JavaScript externo -->
<script src="./js/tabs.js"></script>