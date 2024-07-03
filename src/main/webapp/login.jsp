<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="auth" method="post">
        <label for="user_type">User Type:</label>
        <select id="user_type" name="user_type">
            <option value="CLIENT">CLIENT</option>
            <option value="EMPLOYEE">EMPLOYEE</option>
        </select>
        <br>
        <label for="identifier">Email o Cedula:</label>
        <input type="text" id="identifier" name="identifier">
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password">
        <br>
        <button type="submit">Login</button>
    </form>
</body>
</html>